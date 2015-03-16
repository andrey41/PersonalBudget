package ru.gr41.PersonalBudget.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import ru.gr41.PersonalBudget.R;

/**
 * Created by Andrey on 16.03.2015.
 */
public class RecordPage extends Activity {
    ViewGroup.LayoutParams ur1_fL,ur1_s1,ur1_lL,ur1_tv1,ur1_s2,ur1_tv2;
    int drawBack, drawUr1Verh,drawUr1Button,drawUr2Pole,drawUr2Buttons,drawRamkaRecord,delIndex;
    boolean delMode;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delMode=false;
        setContentView(R.layout.records_page);
        startDrawbleResourses(getIntent().getStringExtra("type"),getIntent().getStringExtra("categoryName"));
        getLayoutParamsForUr1AndClearScroll((LinearLayout)findViewById(R.id.records_ur1_scrollLayout));
        addListenersToUr1();
        addListenersToUr2();
        addListenersToUr4();

    }

    public void startDrawbleResourses(String type,String categoryName)
    {
        if (type.equals("dohod"))
        {
            drawBack=R.drawable.arrow_dohod;
            drawUr1Button=R.drawable.zagolovok_buttons_dohod;
            drawUr1Verh=R.drawable.zagolovok_dohod;
            drawUr2Pole=R.drawable.pole_dohod;
            drawUr2Buttons=R.drawable.button_okno_dohod;
            drawRamkaRecord=R.drawable.scrol_record_dohod;
        }
        else
        {
            drawBack=R.drawable.arrow_rashod;
            drawUr1Button=R.drawable.zagolovok_buttons_rashod;
            drawUr1Verh=R.drawable.zagolovok_rashod;
            drawUr2Pole=R.drawable.pole_rashod;
            drawUr2Buttons=R.drawable.button_okno_rashod;
            drawRamkaRecord=R.drawable.scrol_record_rashod;
        }
        findViewById(R.id.record_back).setBackgroundResource(drawBack);
        findViewById(R.id.record_ur1_verh).setBackgroundResource(drawUr1Verh);
        findViewById(R.id.record_ur1_add).setBackgroundResource(drawUr1Button);
        findViewById(R.id.record_ur1_del).setBackgroundResource(drawUr1Button);
        findViewById(R.id.record_ur1_bol).setBackgroundResource(drawUr1Button);
        ((TextView)findViewById(R.id.record_category_name)).setText(categoryName);

        findViewById(R.id.records_ur2_pole).setBackgroundResource(drawUr2Pole);
        findViewById(R.id.records_ur2_alert).setBackgroundResource(drawUr1Button);
        findViewById(R.id.records_ur2_ok).setBackgroundResource(drawUr2Buttons);

        findViewById(R.id.records_ur4_alert).setBackgroundResource(drawUr1Button);
        findViewById(R.id.records_ur4_yes).setBackgroundResource(drawUr2Buttons);
        findViewById(R.id.records_ur4_no).setBackgroundResource(drawUr2Buttons);

    }

    public void addListenersToUr1()
    {
        Button back = (Button)findViewById(R.id.record_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCategoryPage=new Intent(RecordPage.this,CategoryPage.class);
                toCategoryPage.putExtra("type",getIntent().getStringExtra("type"));
                delMode=false;
                startActivity(toCategoryPage);
            }
        });

        Button add = (Button)findViewById(R.id.record_ur1_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.records_ur2).setVisibility(View.VISIBLE);

                EditText pole=(EditText)findViewById(R.id.records_ur2_pole);
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.showSoftInput(pole, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        Button del = (Button)findViewById(R.id.record_ur1_del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delMode=true;
                findViewById(R.id.records_ur1_panel).setVisibility(View.GONE);
                findViewById(R.id.record_ur1_del_mes).setVisibility(View.VISIBLE);
            }
        });

        TextView delMes=(TextView)findViewById(R.id.record_ur1_del_mes);
        delMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delMode=false;
                findViewById(R.id.records_ur1_panel).setVisibility(View.VISIBLE);
                findViewById(R.id.record_ur1_del_mes).setVisibility(View.GONE);
            }
        });
    }
    public void addListenersToUr2()
    {
        LinearLayout l1=(LinearLayout)findViewById(R.id.records_ur2_l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.records_ur2).setVisibility(View.GONE);

                EditText pole=(EditText)findViewById(R.id.records_ur2_pole);
                pole.setText("");
                //hide keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pole.getWindowToken(), 0);
            }
        });

        LinearLayout l2=(LinearLayout)findViewById(R.id.records_ur2_l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.records_ur2).setVisibility(View.GONE);

                EditText pole=(EditText)findViewById(R.id.records_ur2_pole);
                pole.setText("");
                //hide keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pole.getWindowToken(), 0);
            }
        });

        Button ok=(Button)findViewById(R.id.records_ur2_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.records_ur2).setVisibility(View.GONE);

                EditText pole=(EditText)findViewById(R.id.records_ur2_pole);

                addRecordToScrollLayout((LinearLayout)findViewById(R.id.records_ur1_scrollLayout),pole.getText().toString());
                pole.setText("");
                //hide keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pole.getWindowToken(), 0);
            }
        });
    }
    public void addListenersToUr4()
    {
        LinearLayout l1=(LinearLayout)findViewById(R.id.records_ur4_l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.records_ur4).setVisibility(View.GONE);
            }
        });

        LinearLayout l2=(LinearLayout)findViewById(R.id.records_ur4_l2);

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.records_ur4).setVisibility(View.GONE);
            }
        });

        Button no=(Button)findViewById(R.id.records_ur4_no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.records_ur4).setVisibility(View.GONE);
            }
        });

        Button yes=(Button)findViewById(R.id.records_ur4_yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delRecordFromScrollLayout((LinearLayout)findViewById(R.id.records_ur1_scrollLayout),delIndex);
                findViewById(R.id.records_ur4).setVisibility(View.GONE);
            }
        });

    }

    public void getLayoutParamsForUr1AndClearScroll(LinearLayout scrollLayout)
    {
        FrameLayout frameLayout=(FrameLayout)scrollLayout.getChildAt(0);
        ur1_fL=frameLayout.getLayoutParams();

        Space space1=(Space)frameLayout.getChildAt(0);
        ur1_s1=space1.getLayoutParams();

        LinearLayout linearLayout=(LinearLayout)frameLayout.getChildAt(1);
        ur1_lL=linearLayout.getLayoutParams();

        TextView textView1=(TextView)linearLayout.getChildAt(0);
        ur1_tv1=textView1.getLayoutParams();

        Space space2=(Space)linearLayout.getChildAt(1);
        ur1_s2=space2.getLayoutParams();

        TextView textView2=(TextView)linearLayout.getChildAt(0);
        ur1_tv2=textView2.getLayoutParams();

        scrollLayout.removeAllViews();

    }
    public void addRecordToScrollLayout(LinearLayout scrollLayout,String money)
    {
        float scale = getResources().getDisplayMetrics().density;
        int a=(int) (8*scale + 0.5f);
        int b=(int) (5*scale + 0.5f);

        FrameLayout frameLayout=new FrameLayout(this);
        frameLayout.setLayoutParams(ur1_fL);

        LinearLayout space1=new LinearLayout(this);
        space1.setLayoutParams(ur1_s1);
        space1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout scrollLayout=(LinearLayout) findViewById(R.id.records_ur1_scrollLayout);
                FrameLayout record=(FrameLayout)v.getParent();
                if (delMode)
                {
                    delMode=false;
                    delIndex=scrollLayout.indexOfChild(record);
                    findViewById(R.id.records_ur1_panel).setVisibility(View.VISIBLE);
                    findViewById(R.id.record_ur1_del_mes).setVisibility(View.GONE);
                    findViewById(R.id.records_ur4).setVisibility(View.VISIBLE);
                }
                else
                {

                }
            }
        });

        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setLayoutParams(ur1_lL);

        TextView textView1=new TextView(this);
        textView1.setLayoutParams(ur1_tv1);
        textView1.setText("today");
        textView1.setTextSize(24);
        textView1.setTextColor(Color.BLACK);
        textView1.setGravity(Gravity.CENTER);
        textView1.setPadding(a,b,0,b);

        Space space2=new Space(this);
        space2.setLayoutParams(ur1_s2);

        TextView textView2=new TextView(this);
        textView2.setLayoutParams(ur1_tv2);
        textView2.setText(""+money);
        textView2.setTextSize(24);
        textView2.setTextColor(Color.BLACK);
        textView2.setGravity(Gravity.CENTER);
        textView2.setPadding(0,b,a,b);




        linearLayout.addView(textView1);
        linearLayout.addView(space2);
        linearLayout.addView(textView2);

        frameLayout.addView(space1);
        frameLayout.addView(linearLayout);
        frameLayout.setBackgroundResource(drawRamkaRecord);
        scrollLayout.addView(frameLayout);

    }

    public void delRecordFromScrollLayout(LinearLayout scrollLayout,int index)
    {
        scrollLayout.removeViewAt(index);
    }
}
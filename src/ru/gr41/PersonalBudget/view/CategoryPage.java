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
 * Created by Andrey on 15.03.2015.
 */
public class CategoryPage extends Activity {
    ViewGroup.LayoutParams ur1_fL,ur1_s1,ur1_lL,ur1_tv1,ur1_s2,ur1_tv2;
    int drawBack,drawAddUr1,drawDelUr1,drawUr1Verh,drawUr23,drawPole,drawUr23Button;
    CharSequence text;
    CharSequence totalText="";
    boolean delMode;
    int delIndex;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_page);
        delMode=false;
        startDrawResourses(getIntent().getStringExtra("type"));
        addListenersToUr1();
        addListenersToUr2();
        addListenersToUr3();
        getLayoutParamsForUr1AndClearScroll((ScrollView)findViewById(R.id.scrolCategories));

    }
    public void startDrawResourses(String finObjType)
    {

        if (finObjType.equals("dohod"))
        {
            text="Доходы";
            totalText="общая сумма доходов";
            drawBack=R.drawable.arrow_dohod;
            drawAddUr1=R.drawable.zagolovok_buttons_dohod;
            drawDelUr1=R.drawable.zagolovok_buttons_dohod;
            drawUr1Verh=R.drawable.zagolovok_dohod;
            drawUr23=R.drawable.zagolovok_buttons_dohod;
            drawPole=R.drawable.pole_dohod;
            drawUr23Button=R.drawable.button_okno_dohod;
        }
        else
        {
            text="Расходы";
            totalText="общая сумма расходов";
            drawBack=R.drawable.arrow_rashod;
            drawAddUr1=R.drawable.zagolovok_buttons_rashod;
            drawDelUr1=R.drawable.zagolovok_buttons_rashod;
            drawUr1Verh=R.drawable.zagolovok_rashod;
            drawUr23=R.drawable.zagolovok_buttons_rashod;
            drawPole=R.drawable.pole_rashod;
            drawUr23Button=R.drawable.button_okno_rashod;
        }
        findViewById(R.id.Category_ur1_verh).setBackgroundResource(drawUr1Verh);
        findViewById(R.id.add_category_ur1).setBackgroundResource(drawAddUr1);
        findViewById(R.id.del_category_ur1).setBackgroundResource(drawDelUr1);
        findViewById(R.id.back).setBackgroundResource(drawBack);
        ((TextView)findViewById(R.id.finObj)).setText(text);
        findViewById(R.id.category_ur3_alert).setBackgroundResource(drawUr23);
        findViewById(R.id.category_ur2_alert).setBackgroundResource(drawUr23);
        findViewById(R.id.category_ur2_edit).setBackgroundResource(drawPole);
        findViewById(R.id.category_ur2_ok).setBackgroundResource(drawUr23Button);
        findViewById(R.id.category_ur3_yes).setBackgroundResource(drawUr23Button);
        findViewById(R.id.category_ur3_no).setBackgroundResource(drawUr23Button);

    }

    public void addListenersToUr1()
    {
        Button back=(Button)findViewById(R.id.back);
        Button addUr1=(Button)findViewById(R.id.add_category_ur1);
        Button delUr1=(Button)findViewById(R.id.del_category_ur1);
        TextView delMes=(TextView)findViewById(R.id.category_ur1_del_mes);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStartPage=new Intent(CategoryPage.this,StartPage.class);
                findViewById(R.id.category_ur1_total).setVisibility(View.VISIBLE);
                findViewById(R.id.category_ur1_del_mes).setVisibility(View.GONE);
                delMode=false;
                startActivity(toStartPage);
            }
        });

        addUr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Category_ur2).setVisibility(View.VISIBLE);

                EditText pole=(EditText)findViewById(R.id.category_ur2_edit);
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.showSoftInput(pole, InputMethodManager.SHOW_IMPLICIT);

            }
        });

        delUr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delMode=true;
                findViewById(R.id.category_ur1_total).setVisibility(View.GONE);
                findViewById(R.id.category_ur1_del_mes).setVisibility(View.VISIBLE);
            }
        });

        delMes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delMode=false;
                findViewById(R.id.category_ur1_total).setVisibility(View.VISIBLE);
                findViewById(R.id.category_ur1_del_mes).setVisibility(View.GONE);
            }
        });
    }

    public void addListenersToUr2()
    {
        LinearLayout l1=(LinearLayout)findViewById(R.id.category_ur2_l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Category_ur2).setVisibility(View.GONE);
                EditText pole=(EditText)findViewById(R.id.category_ur2_edit);
                pole.setText("");
                //hide keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pole.getWindowToken(), 0);
            }
        });

        LinearLayout l2=(LinearLayout)findViewById(R.id.category_ur2_l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Category_ur2).setVisibility(View.GONE);
                EditText pole=(EditText)findViewById(R.id.category_ur2_edit);
                pole.setText("");
                //hide keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(
                        INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pole.getWindowToken(), 0);
            }
        });

        Button ok=(Button)findViewById(R.id.category_ur2_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Category_ur2).setVisibility(View.GONE);
                ScrollView scroll=(ScrollView)findViewById(R.id.scrolCategories);
                EditText pole=(EditText)findViewById(R.id.category_ur2_edit);
                if (!pole.getText().toString().equals(""))
                    addCategoryToScrollLayout((LinearLayout) scroll.getChildAt(0), pole.getText().toString(), 0);
                pole.setText("");
                InputMethodManager imm = (InputMethodManager)getSystemService(
                       INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(pole.getWindowToken(), 0);
            }
        });
    }

    public void addListenersToUr3()
    {
        LinearLayout l1=(LinearLayout)findViewById(R.id.category_ur3_l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Category_ur3).setVisibility(View.GONE);
            }
        });

        LinearLayout l2=(LinearLayout)findViewById(R.id.category_ur3_l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Category_ur3).setVisibility(View.GONE);
            }
        });

        Button yes=(Button)findViewById(R.id.category_ur3_yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView scroll=(ScrollView)findViewById(R.id.scrolCategories);
                delCategoryFromScrollLayout((LinearLayout) scroll.getChildAt(0),delIndex);
                findViewById(R.id.Category_ur3).setVisibility(View.GONE);
            }
        });

        Button no=(Button)findViewById(R.id.category_ur3_no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Category_ur3).setVisibility(View.GONE);
            }
        });


    }
    public void getLayoutParamsForUr1AndClearScroll(ScrollView scroll)
    {
        FrameLayout frameLayout=(FrameLayout)((LinearLayout)scroll.getChildAt(0)).getChildAt(0);
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

        ((LinearLayout)scroll.getChildAt(0)).removeAllViews();

    }
    public void addCategoryToScrollLayout(final LinearLayout scrolLayout,CharSequence name,int money)
    {

        FrameLayout frameLayout=new FrameLayout(this);
        frameLayout.setLayoutParams(ur1_fL);

            LinearLayout space1=new LinearLayout(this);
            space1.setLayoutParams(ur1_s1);
            space1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ScrollView scroll=(ScrollView)findViewById(R.id.scrolCategories);
                    LinearLayout scrollLayout=(LinearLayout) scroll.getChildAt(0);
                    FrameLayout category=(FrameLayout)v.getParent();
                    String categoryName=(String)((TextView)((LinearLayout)category.getChildAt(1)).getChildAt(0)).getText();
                    if (delMode)
                    {
                        delMode=false;

                        delIndex=scrollLayout.indexOfChild(category);

                        findViewById(R.id.category_ur1_total).setVisibility(View.VISIBLE);
                        findViewById(R.id.category_ur1_del_mes).setVisibility(View.GONE);

                        findViewById(R.id.Category_ur3).setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        Intent toRecordPage = new Intent(CategoryPage.this, RecordPage.class);
                        toRecordPage.putExtra("type", getIntent().getStringExtra("type"));
                        toRecordPage.putExtra("categoryName",categoryName);
                        startActivity(toRecordPage);
                    }
                }
            });

            LinearLayout linearLayout=new LinearLayout(this);
            linearLayout.setLayoutParams(ur1_lL);

                TextView textView1=new TextView(this);
                textView1.setLayoutParams(ur1_tv1);
                textView1.setText(name);
                textView1.setTextSize(28);
                textView1.setTextColor(Color.BLACK);
                textView1.setGravity(Gravity.CENTER);

                Space space2=new Space(this);
                space2.setLayoutParams(ur1_s2);

                TextView textView2=new TextView(this);
                textView2.setLayoutParams(ur1_tv2);
                textView2.setText(""+money);
                textView2.setTextSize(28);
                textView2.setTextColor(Color.BLACK);
                textView2.setGravity(Gravity.CENTER);

            linearLayout.addView(textView1);
            linearLayout.addView(space2);
            linearLayout.addView(textView2);

        frameLayout.addView(space1);
        frameLayout.addView(linearLayout);

        scrolLayout.addView(frameLayout);

    }

    public void delCategoryFromScrollLayout(LinearLayout scrollLayout,int index)
    {
        scrollLayout.removeViewAt(index);
    }


}
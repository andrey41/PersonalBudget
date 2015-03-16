package ru.gr41.PersonalBudget.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import ru.gr41.PersonalBudget.R;
import ru.gr41.PersonalBudget.model.ModelManager;

import java.util.Calendar;


public class StartPage extends Activity {
    /**
     * Called when the activity is first created.
     */
    ModelManager modelManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        modelManager=new ModelManager(Calendar.getInstance().get(Calendar.DAY_OF_MONTH),Calendar.getInstance().get(Calendar.MONTH)+1,Calendar.getInstance().get(Calendar.YEAR));

        Button dohod=(Button)findViewById(R.id.dohod);
       dohod.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent dohodPage = new Intent(StartPage.this, CategoryPage.class);
               dohodPage.putExtra("type","dohod");
               modelManager.chooseFinObj("dohod");
               startActivity(dohodPage);
           }
       });

        Button rashod=(Button)findViewById(R.id.rashod);
        rashod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent rashodPage = new Intent(StartPage.this, CategoryPage.class);
                rashodPage.putExtra("type", "rashod");
                modelManager.chooseFinObj("rashod");
                startActivity(rashodPage);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        modelManager.readFile(this);
        ((TextView)findViewById(R.id.date)).setText(modelManager.getCurrentDate());
        ((TextView)findViewById(R.id.balance)).setText("текущий баланс: "+(int)modelManager.getBalance());
        ((Button)findViewById(R.id.dohod)).setText("Доходы\n " + (int) modelManager.getDohodForCurrentMonth());
        ((Button)findViewById(R.id.rashod)).setText("Расходы\n "+(int)modelManager.getRashodForCurrentMonth());

    }

    @Override
    protected void onStop() {
        super.onStop();
        modelManager.writeFile(this);
    }
}

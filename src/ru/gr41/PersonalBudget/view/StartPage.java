package ru.gr41.PersonalBudget.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ru.gr41.PersonalBudget.R;


public class StartPage extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Button dohod=(Button)findViewById(R.id.dohod);
       dohod.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent dohodPage = new Intent(StartPage.this, CategoryPage.class);
               dohodPage.putExtra("type","dohod");
               startActivity(dohodPage);
           }
       });

        Button rashod=(Button)findViewById(R.id.rashod);
        rashod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent rashodPage = new Intent(StartPage.this, CategoryPage.class);
                rashodPage.putExtra("type", "rashod");
                startActivity(rashodPage);
            }
        });

    }
}

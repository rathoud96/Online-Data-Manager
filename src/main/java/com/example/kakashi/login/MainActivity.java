package com.example.kakashi.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridLayout maingrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page1);

        maingrid = (GridLayout)findViewById(R.id.maingrid);
        setSingleEvent(maingrid);
    }

    private void setSingleEvent(GridLayout maingrid) {
        for(int i=0;i<maingrid.getChildCount();i++)
        {
            CardView cardView = (CardView)maingrid.getChildAt(i);
            final int finale = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finale == 0)
                    {
                      Intent intent = new Intent(MainActivity.this,Ad_home.class);
                       startActivity(intent);
                    }
                    else if(finale == 1)
                    {
                        Toast.makeText(MainActivity.this,"Coming Soon",Toast.LENGTH_SHORT).show();
                       // Intent intent = new Intent(MainActivity.this,Ad_home.class);
                       // startActivity(intent);
                    }
                    else if (finale == 2)
                    {
                        Toast.makeText(MainActivity.this,"Coming Soon",Toast.LENGTH_SHORT).show();
                       // Intent intent = new Intent(MainActivity.this,Ad_home.class);
                       // startActivity(intent);
                    }
                    else if(finale==3)
                    {
                        Intent intent = new Intent(MainActivity.this,Ad_home.class);
                        startActivity(intent);
                    }
                    else if(finale == 4)
                    {
                       Intent intent = new Intent(MainActivity.this,Company_page.class);
                       startActivity(intent);
                    }
                    else if(finale == 5)
                    {
                        Intent intent = new Intent(MainActivity.this,developer.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }
}

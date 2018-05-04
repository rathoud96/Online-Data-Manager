package com.example.kakashi.login;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;


/**
 * Created by Kakashi on 11/22/2017.
 */

public class Employees_1 extends AppCompatActivity {

    GridLayout employeeGrid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employees);

        employeeGrid = (GridLayout)findViewById(R.id.grid2);
        setSingleEvent(employeeGrid);
    }

    private void setSingleEvent(GridLayout employeeGrid) {
        for(int i=0;i<employeeGrid.getChildCount();i++)
        {
            CardView cardView = (CardView)employeeGrid.getChildAt(i);
            final int finale = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finale == 0)
                    {
                        Intent intent = new Intent(Employees_1.this,order_details.class);
                        startActivity(intent);
                    }
                    else if(finale == 1)
                    {
                         Intent intent = new Intent(Employees_1.this,Machine_process.class);
                         startActivity(intent);
                    }
                    else if (finale == 2)
                    {
                        // Intent intent = new Intent(MainActivity.this,Ad_home.class);
                        // startActivity(intent);
                    }
                    else if(finale==3)
                    {

                    }
                    else if(finale == 4)
                    {
                        // Intent intent = new Intent(MainActivity.this,Ad_home.class);
                        // startActivity(intent);
                    }
                    else if(finale == 5)
                    {
                        Intent intent = new Intent(Employees_1.this,developer.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }
}

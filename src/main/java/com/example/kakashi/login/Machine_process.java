package com.example.kakashi.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Machine_process extends AppCompatActivity implements View.OnClickListener {
    EditText order_id,machine_name,on_time,off_time,item_count,brand_name;
    Button Submit,Delete,Show;
    FirebaseAuth firebaseAuth;
    DatabaseReference myRef;
    FirebaseDatabase database;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        order_id = (EditText)findViewById(R.id.item_id);
        machine_name = (EditText)findViewById(R.id.machine_name);
        on_time = (EditText)findViewById(R.id.on_time);
        off_time = (EditText)findViewById(R.id.off_time);
        item_count = (EditText)findViewById(R.id.item_count);
        brand_name = (EditText)findViewById(R.id.item_brand);
        Submit = (Button)findViewById( R.id.btn_add);
        Show = (Button)findViewById( R.id.btn_show);
        Delete = (Button)findViewById(R.id.btn_del);
        textView = (TextView)findViewById(R.id.txtview1);

        Submit.setOnClickListener(this);
        Show.setOnClickListener(this);
        Delete.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReferenceFromUrl("https://login-ff8f7.firebaseio.com");


    }

    @Override
    public void onClick(View view)
    {


        if (view.getId() == R.id.btn_add)
        {
            //Toast.makeText(order_details.this,"Clicked",Toast.LENGTH_SHORT).show();
            myRef.child(order_id.getText().toString())
                    .child("Machine Name").setValue(machine_name.getText().toString());



            myRef.child(order_id.getText().toString())
                    .child("On TIme").setValue(on_time.getText().toString());


            myRef.child(order_id.getText().toString())
                    .child("Off Time").setValue(off_time.getText().toString());


            myRef.child(order_id.getText().toString())
                    .child("Item Produced").setValue(item_count.getText().toString());


            myRef.child(order_id.getText().toString())
                    .child("Branding").setValue(brand_name.getText().toString());
            brand_name.setText("");
            order_id.setText("");
            machine_name.setText("");
            on_time.setText("");
            off_time.setText("");
            item_count.setText("");
        }

        else if(view.getId() == R.id.btn_show)
        {
            database.getReference(order_id.getText().toString()).child("Machine Name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    machine_name.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            database.getReference(order_id.getText().toString()).child("On TIme").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    on_time.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            database.getReference(order_id.getText().toString()).child("Off Time").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    off_time.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            database.getReference(order_id.getText().toString()).child("Item Produced").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    item_count.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            database.getReference(order_id.getText().toString()).child("Branding").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    brand_name.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }
        else if (view.getId() == R.id.btn_del)
        {
            database.getReference(order_id.getText().toString()).removeValue();
        }
    }
}

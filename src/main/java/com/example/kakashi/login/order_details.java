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


public class order_details extends AppCompatActivity implements View.OnClickListener {
    EditText order_id,item_name,item_quantity,customer_nmae,item_size,brand_name;
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
        item_name = (EditText)findViewById(R.id.itme_name);
        item_quantity = (EditText)findViewById(R.id.item_quantity);
        customer_nmae = (EditText)findViewById(R.id.item_company);
        item_size = (EditText)findViewById(R.id.item_size);
        brand_name = (EditText)findViewById(R.id.item_brand);
        Submit = (Button)findViewById( R.id.btn_submit);
        Show = (Button)findViewById( R.id.btn_view);
        Delete = (Button)findViewById(R.id.btn_delete);
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


        if (view.getId() == R.id.btn_submit)
        {
            //Toast.makeText(order_details.this,"Clicked",Toast.LENGTH_SHORT).show();
            myRef.child(order_id.getText().toString())
                    .child("Item Name").setValue(item_name.getText().toString());



            myRef.child(order_id.getText().toString())
                    .child("Quantity").setValue(item_quantity.getText().toString());


            myRef.child(order_id.getText().toString())
                    .child("Item Size").setValue(item_size.getText().toString());


            myRef.child(order_id.getText().toString())
                    .child("Customer Name").setValue(customer_nmae.getText().toString());


            myRef.child(order_id.getText().toString())
                    .child("Branding").setValue(brand_name.getText().toString());
            brand_name.setText("");
            order_id.setText("");
            item_name.setText("");
            item_quantity.setText("");
            item_size.setText("");
            customer_nmae.setText("");
        }

        else if(view.getId() == R.id.btn_view)
        {
            database.getReference(order_id.getText().toString()).child("Item Name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    item_name.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            database.getReference(order_id.getText().toString()).child("Quantity").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    item_quantity.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            database.getReference(order_id.getText().toString()).child("Item Size").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    item_size.setText(value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            database.getReference(order_id.getText().toString()).child("Customer Name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    customer_nmae.setText(value);
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
        else if (view.getId() == R.id.btn_delete)
        {
            database.getReference(order_id.getText().toString()).removeValue();
        }
    }
}

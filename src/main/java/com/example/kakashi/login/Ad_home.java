package com.example.kakashi.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Kakashi on 11/25/2017.
 */

public class Ad_home extends AppCompatActivity implements View.OnClickListener{

    Button login1,chngpass1;
    EditText username1,password1;
    private FirebaseAuth auth,auth1;
    LinearLayout layout1;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login1 = (Button)findViewById(R.id.btnlogin1);
        chngpass1 = (Button)findViewById(R.id.btnchangepass1);
        username1 = (EditText)findViewById(R.id.editusername1);
        password1 = (EditText)findViewById(R.id.editpass1);
        layout1 = (LinearLayout)findViewById(R.id.linearlayout1);

        login1.setOnClickListener(this);
        chngpass1.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null)
        {
                    if(username1.getText().toString().equals("rathoud96@gmail.com") && password1.getText().length()!=0)
                    {
                        startActivity(new Intent(Ad_home.this, Admin_view.class));
                        finish();
                    }
                    else if(username1.getText().length()!=0 &&  password1.getText().length()!=0)
                    {
                        startActivity(new Intent(Ad_home.this, Employees_1.class));
                        finish();
                    }

        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnlogin1)
        {
            if(username1.getText().length() == 0 && password1.getText().length() == 0)
            {
                Toast.makeText(Ad_home.this,"Please Enter Email or Password",Toast.LENGTH_SHORT).show();
            }
            else if(password1.getText().length()<6)
            {
                Toast.makeText(Ad_home.this,"Password must be 6 character long",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Loginuser(username1.getText().toString(),password1.getText().toString());
                username1.setText("");
                password1.setText("");
            }
        }
        else if(view.getId() == R.id.btnchangepass1)
        {
            Intent intent = new Intent(Ad_home.this,signup.class);
            startActivity(intent);
            finish();

        }
    }

    private void Loginuser(String email, final String password)
    {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                        {
                            if(password.length()<6)
                            {
                                Snackbar snackbar = Snackbar.make(layout1,"Password must be 6 character long",Snackbar.LENGTH_SHORT);
                                snackbar.show();
                            }
                        }
                        else
                        {
                            Intent intent = new Intent(Ad_home.this,Employees_1.class);
                            startActivity(intent );
                            finish();

                        }

                    }
                });
    }
}

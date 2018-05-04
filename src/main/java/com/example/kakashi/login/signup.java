package com.example.kakashi.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class signup extends AppCompatActivity implements View.OnClickListener{
    Button signup;
    EditText emailenter,passenter;
    LinearLayout linear_signup;
    private FirebaseAuth auth;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup = (Button)findViewById(R.id.btnsignup);
        emailenter = (EditText)findViewById(R.id.input_mail);
        passenter = (EditText)findViewById(R.id.input_password);
        linear_signup = (LinearLayout)findViewById(R.id.signup_layout);

        signup.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnsignup)
        {
            if(emailenter.getText().length() == 0 && passenter.getText().length() == 0)
            {
                Toast.makeText(signup.this,"Please Enter Email or Password",Toast.LENGTH_SHORT).show();
            }
            else if(passenter.getText().length()<6)
            {
                Toast.makeText(signup.this,"Password must be 6 character long",Toast.LENGTH_SHORT).show();
            }
            else
            {
                signupuser(emailenter.getText().toString(),passenter.getText().toString());
                emailenter.setText("");
                passenter.setText("");
            }
        }

    }

    private void signupuser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                        {
                            Snackbar snackbar = Snackbar.make(linear_signup,"Error"+task.getException(),Snackbar.LENGTH_SHORT);
                            snackbar.show();
                        }
                        else
                        {
                            Snackbar snackbar = Snackbar.make(linear_signup,"Register Succesful",Snackbar.LENGTH_SHORT);
                            snackbar.show();
                            startActivity(new Intent(signup.this,Ad_home.class));
                            finish();

                        }
                    }
                });
    }
}

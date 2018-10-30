package com.example.adity.major_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    DatabaseHelper helper= new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button,button2;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        button=(Button)findViewById(R.id.sign_up_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity();
            }
        });




        button2=(Button)findViewById(R.id.sign_in_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email=(EditText)findViewById(R.id.email);
                EditText pass=(EditText)findViewById(R.id.password);

                String stremail=email.getText().toString();
                String strpass=pass.getText().toString();


                String password=helper.searchPass(stremail);


                if(strpass.equals(password))
                {
                    Intent intent= new Intent(SignUpActivity.this,HomePage.class);

                    String un=helper.searchName(stremail);
                    Toast toast = Toast.makeText(SignUpActivity.this,"Welcome "+un, Toast.LENGTH_SHORT);
                    toast.show();
                    intent.putExtra("send_name",un);
                    startActivity(intent);
                }

                else
                {
                    Toast toast = Toast.makeText(SignUpActivity.this,"Login credentials incorrect, try again! ", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public void RegisterActivity()
    {
        Intent intent= new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}

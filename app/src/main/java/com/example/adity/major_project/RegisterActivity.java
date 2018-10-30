package com.example.adity.major_project;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button =(Button)findViewById(R.id.register_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=(EditText)findViewById(R.id.name);
                EditText email=(EditText)findViewById(R.id.email);
                EditText contact=(EditText)findViewById(R.id.contact);
                EditText pass=(EditText)findViewById(R.id.password);
                EditText conf_pass=(EditText)findViewById(R.id.confirm_password);

                String strname=name.getText().toString();
                String stremail=email.getText().toString();
                String strcontact=contact.getText().toString();
                String strpass=pass.getText().toString();
                String strconf=conf_pass.getText().toString();

                if(!(strpass).equals(strconf)) {
                    Toast toast = Toast.makeText(RegisterActivity.this,"Passwords don't match ", Toast.LENGTH_SHORT);
                    toast.show();
                }

                if(strpass.equals(strconf) && strpass.length()<6)
                {
                    Toast toast = Toast.makeText(RegisterActivity.this,"Password should have a minimum length of 6", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if(!stremail.contains("@"))
                {
                    Toast toast = Toast.makeText(RegisterActivity.this,"email is invalid", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if(strcontact.length()!=10)
                {
                    Toast toast = Toast.makeText(RegisterActivity.this,"Contact number invalid", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else
                {
                    Contacts contacts=new Contacts();
                    contacts.setName(strname);
                    contacts.setEmail(stremail);
                    contacts.setContact(strcontact);
                    contacts.setPass(strpass);

                    helper.insertContact(contacts);

                    Toast toast = Toast.makeText(RegisterActivity.this,"Signup successful ", Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(RegisterActivity.this,SignUpActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
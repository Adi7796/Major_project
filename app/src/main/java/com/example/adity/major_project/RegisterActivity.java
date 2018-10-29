package com.example.adity.major_project;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

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

                Toast toast=Toast.makeText(RegisterActivity.this,strname +" "+strpass,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}

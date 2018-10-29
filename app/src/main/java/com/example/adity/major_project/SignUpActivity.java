package com.example.adity.major_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        button=(Button)findViewById(R.id.sign_up_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity();
            }
        });

    }

    public void RegisterActivity()
    {
        Intent intent= new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}

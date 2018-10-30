package com.example.adity.major_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Bundle data=getIntent().getExtras();
        String name=data.getString("send_name");

        TextView text_name=(TextView)findViewById(R.id.t1);
        text_name.setText("Welcome, "+name);
    }
}

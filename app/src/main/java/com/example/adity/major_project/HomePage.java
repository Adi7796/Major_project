package com.example.adity.major_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle data=getIntent().getExtras();
        final String name=data.getString("send_name");

        TextView text_name=(TextView)findViewById(R.id.t1);
        text_name.setText("Welcome, "+name);

        TextView t=(TextView)findViewById(R.id.pulse);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomePage.this,CheckPulseActivity.class);
                intent.putExtra("send_name",name);
                startActivity(intent);
            }
        });

        TextView t1=(TextView)findViewById(R.id.temp);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(HomePage.this,CheckTempActivity.class);
                startActivity(intent1);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate your main_menu into the menu
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        switch (id)
        {
            case R.id.sign_out:
            {
                Intent i=new Intent(HomePage.this,SignUpActivity.class);
                startActivity(i);
            }
        }


        return true;
    }
}

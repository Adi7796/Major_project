package com.example.adity.major_project;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactDoctorActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_doctor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        show();

        FloatingActionButton f=(FloatingActionButton)findViewById(R.id.fab);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(ContactDoctorActivity.this,AddDoctorDetails.class);
                startActivity(i);
            }
        });
    }


    public void show() {

        ListView list = (ListView) findViewById(R.id.ListView);
        myDB = new DatabaseHelper(this);

        ArrayList<String> newlist = new ArrayList<>();
        Cursor data = myDB.getList();

        if (data.getCount() == 0) {
            Toast toast = Toast.makeText(ContactDoctorActivity.this, "N0 records found", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            while (data.moveToNext()) {
                newlist.add(data.getString(0));
                ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,R.layout.acti_list,R.id.list_content,newlist);
                list.setAdapter(listAdapter);
            }
        }

    }
}

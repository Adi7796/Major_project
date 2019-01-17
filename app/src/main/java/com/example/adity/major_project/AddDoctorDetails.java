package com.example.adity.major_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDoctorDetails extends AppCompatActivity {

    DatabaseHelper helper=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor_details);

       button =(Button)findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=(EditText)findViewById(R.id.name);
                EditText email=(EditText)findViewById(R.id.email);
                EditText number=(EditText)findViewById(R.id.number);
                EditText specialization=(EditText)findViewById(R.id.specs);


                String strname=name.getText().toString();
                String stremail=email.getText().toString();
                String strnumber=number.getText().toString();
                String strspecs=specialization.getText().toString();

               DocDetails details =new DocDetails();
                details.setName(strname);
                details.setNumber(strnumber);
                details.setEmail(stremail);
                details.setSpecialization(strspecs);

               helper.insertDetails(details);

                Toast toast = Toast.makeText(AddDoctorDetails.this,"Details added successfully", Toast.LENGTH_SHORT);
                toast.show();

                Intent intent= new Intent(AddDoctorDetails.this,ContactDoctorActivity.class);
                startActivity(intent);

            }
        });

    }
}

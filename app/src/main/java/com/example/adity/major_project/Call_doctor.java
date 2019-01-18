package com.example.adity.major_project;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Call_doctor extends AppCompatActivity {

    private static final int REQUEST_CALL=1;

    String num="",email="",specs="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setContentView(R.layout.activity_call_doctor);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        TextView text = (TextView) findViewById(R.id.name);
        text.setText(message);
        show(message);



    }

    public void show(String message) {
        DatabaseHelper db = new DatabaseHelper(this);
        SQLiteDatabase sdb;
        final TextView number = (TextView) findViewById(R.id.number);
        TextView mail = (TextView) findViewById(R.id.mail);
        TextView specialization = (TextView) findViewById(R.id.specs);


        sdb = db.getReadableDatabase();
        Cursor cursor = db.getInfo(message, sdb);


        if (cursor.moveToFirst()) {
            specs = cursor.getString(0);
            num = cursor.getString(1);
            email = cursor.getString(2);
            mail.setText(email);
            number.setText(num);
            specialization.setText(specs);
        }
        ImageButton b = (ImageButton) findViewById(R.id.call);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            makePhoneCall();
            }
        });
}



    private void makePhoneCall()
    {

        if (ContextCompat.checkSelfPermission(Call_doctor.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Call_doctor.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else
        {
            String url = "tel:"+num;
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
            startActivity(intent);
        }
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode== REQUEST_CALL)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                makePhoneCall();
            }
            else {
                Toast.makeText(Call_doctor.this,"Permission denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

}

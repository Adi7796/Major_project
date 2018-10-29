package com.example.adity.major_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adity on 10/29/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static  final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_CONTACT="contact";
    private static final String COLUMN_PASS="pass";
    SQLiteDatabase db;

    private static final String TABLE_CREATE="create table contacts (id integer primary key not null auto_increment ," +
            "name text not null, " +
            "email text not null," +
            "contact text not null, " +
            "pass text not null)";


    public DatabaseHelper(Context context){

    super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

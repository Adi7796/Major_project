package com.example.adity.major_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adity on 10/29/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static  final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME1="contacts";
    private static final String TABLE_NAME2="details";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_CONTACT="contact";
    private static final String COLUMN_NUMBER="number";
    private static final String COLUMN_PASS="pass";
    private static final String COLUMN_SPECIALIZATION="specialization";
    SQLiteDatabase db;

    private static final String TABLE_CREATE1="create table contacts (id integer primary key not null, " +
            "name text not null, " +
            "email text not null," +
            "contact text not null, " +
            "pass text not null)";

    private static final String TABLE_CREATE2="create table "+ TABLE_NAME2 + " (id integer primary key not null, " +
            "name text not null, " +
            "number text not null," +
            "email text not null, " +
            "specialization text not null)";


    public DatabaseHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE1);
        db.execSQL(TABLE_CREATE2);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="DROP TABLE IF EXISTS" + TABLE_NAME1;
        String query2="DROP TABLE IF EXISTS" + TABLE_NAME2;
        db.execSQL(query);
       db.execSQL(query2);
        this.onCreate(db);
    }

    public void insertContact(Contacts contacts)
    {
        db = this.getWritableDatabase();
        ContentValues values= new ContentValues();

        String query="select * from contacts";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,contacts.getName());
        values.put(COLUMN_EMAIL,contacts.getEmail());
        values.put(COLUMN_CONTACT,contacts.getContact());
        values.put(COLUMN_PASS,contacts.getPass());

        db.insert(TABLE_NAME1,null,values);
        db.close();
    }

    public void insertDetails(DocDetails details)
    {
        db= this.getWritableDatabase();
        ContentValues values= new ContentValues();

        String query="select * from "+ TABLE_NAME2;
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,details.getName());
        values.put(COLUMN_NUMBER,details.getNumber());
        values.put(COLUMN_EMAIL,details.getEmail());
        values.put(COLUMN_SPECIALIZATION,details.getSpecialization());

        db.insert(TABLE_NAME2,null,values);
        db.close();
    }

    public Cursor getList()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        String projections[]={COLUMN_NAME,COLUMN_NUMBER};
        Cursor data= db.query(TABLE_NAME2,projections,null,
                null,null,null,null);
        return data;
    }


    public String searchPass(String email)
    {
        db=this.getReadableDatabase();
        String query="select email,pass from "+TABLE_NAME1;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);
                if(a.equals(email))
                {
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext()) ;
        }
        return b;

    }

    public String searchName(String email)
    {
        db=this.getReadableDatabase();
        String query="select email,name from "+TABLE_NAME1;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do{
                a=cursor.getString(0);
                if(a.equals(email))
                {
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext()) ;
        }
        return b;

    }

   /* public String getNumber(String name)
    {
        db=this.getReadableDatabase();
        String query="select number from "+TABLE_NAME2 +" where name = "+name;
        Cursor cursor=db.rawQuery(query,null);
        String s1="";
        if (cursor.moveToFirst())

        {
            do
            {
                s1 = cursor.getString(cursor.getColumnIndex("number"));
            }while (cursor.moveToNext());
        }

        return s1;
    }

    public String getEmail(String name)
    {
        db=this.getReadableDatabase();
        String query="select email from "+TABLE_NAME2 +" where name = "+name;
        Cursor cursor=db.rawQuery(query,null);
        String s2="";
        if (cursor.moveToFirst())

        {
            do
            {
                s2 = cursor.getString(cursor.getColumnIndex("number"));
            }while (cursor.moveToNext());
        }

        return s2;
    }

    public String getSpecs(String name)
    {
        db=this.getReadableDatabase();
        String query="select specialization from "+TABLE_NAME2 +" where name = "+'name';
        Cursor cursor=db.rawQuery(query,null);
        String s3="";
        if (cursor.moveToFirst())

        {
            do
            {
                s3 = cursor.getString(cursor.getColumnIndex("number"));
            }while (cursor.moveToNext());
        }

        return s3;
    }
*/

   public Cursor getInfo(String name, SQLiteDatabase db)
   {
       String[] projection={COLUMN_SPECIALIZATION,COLUMN_NUMBER,COLUMN_EMAIL};
       String selection=COLUMN_NAME + " LIKE ?";
       String[] selection_args={name};
       Cursor cursor=db.query(TABLE_NAME2,projection,selection,selection_args,null,null,null);
       return cursor;

   }
}
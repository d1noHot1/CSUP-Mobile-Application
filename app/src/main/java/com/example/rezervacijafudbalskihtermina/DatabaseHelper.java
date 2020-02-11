package com.example.rezervacijafudbalskihtermina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {

        super(context, "Login.db", null, 4);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create TABLE user(username text primary key, password text, email text)");
        db.execSQL("Create TABLE rezervacije(opis text, vrijeme text primary key, korisnik text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists rezervacije");
        onCreate(db);


    }

    public boolean insert(String username, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email", email);
        contentValues.put("password ", password);
        long ins = db.insert("user", null, contentValues);
        if(ins==-1) return false;
        else return true;

    }


    public boolean napraviRezervaciju(String opis, String vrijeme, String korisnik){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("opis", opis);
        contentValues.put("vrijeme", vrijeme);
        contentValues.put("korisnik", korisnik);
        long ins = db.insert("rezervacije", null, contentValues);
        if(ins==-1) return false;
        else return true;


    }




    public Boolean provjeriUsername(String username){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where USERNAME=?", new String []{username});
        if (cursor.getCount()>0)

            return false;


        else

            return true;
    }

    public Boolean provjeriVrijeme(String vrijeme){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from rezervacije where vrijeme=?", new String[] {vrijeme});
        if(cursor.getCount()>0)

            return false;
        else
            return true;

    }

    public boolean UsernamePassword(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{username,password});
        if(cursor.getCount()>0) return true;
        else return false;


    }

    public Cursor alldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from rezervacije", null);
        return cursor;

    }

    public void deleteAll(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("rezervacije", null, null);


    }


}

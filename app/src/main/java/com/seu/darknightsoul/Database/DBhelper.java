package com.seu.darknightsoul.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.seu.darknightsoul.Model.Users;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {


    SQLiteDatabase database;

    public DBhelper( Context context) {
        super(context, "login", null, 1);

        database =getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(Users.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("DROP TABLE IF EXISTS Users" + Users.TABLE_NAME);

        onCreate(database);

    }

    //add new users
    public boolean insertUsers(String userName,String phone,  String email, String password)
    {

        ContentValues contentValues = new ContentValues();

        contentValues.put(Users.u_UserName,userName);
        contentValues.put(Users.u_Phone,phone);
        contentValues.put(Users.u_Email,email);
        contentValues.put(Users.u_Password,password);

        return database.insert(Users.TABLE_NAME,null,contentValues)>0;
    }

//    public boolean checkUserPass(String userName ,String password ){
//
//        Cursor cursor = database.rawQuery("SELECT * FROM "+Users.TABLE_NAME+" Where userName =? AND password =?",new String[] {userName,password});
//        return cursor.getCount() > 0;
//
//    }

    @SuppressLint("Range")
    public ArrayList<Users> getAllUser(){
        SQLiteDatabase database = this.getWritableDatabase();

        ArrayList<Users> users =new ArrayList<>();

        String sqlquery = "SELECT * FROM "+Users.TABLE_NAME+" ORDER BY ID DESC";
        Cursor cursor = database.rawQuery(sqlquery,null);

        if (cursor.moveToFirst())
        {
            do{
                Users user=new Users();
                user.setId(cursor.getInt(cursor.getColumnIndex(Users.u_ID)));
                user.setPhone(cursor.getString(cursor.getColumnIndex(Users.u_Phone)));
                user.setUserName(cursor.getString(cursor.getColumnIndex(Users.u_UserName)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(Users.u_Email)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(Users.u_Password)));


                users.add(user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }

    //استعلام لعملية تسجيل الدخول من خلال اسم المستخدم وكلمة المرور
    @SuppressLint("Range")
    public ArrayList<Users> getAllUserBy(String userName, String password){


        ArrayList<Users> users =new ArrayList<>();

        String sqlquery = "SELECT * FROM "+Users.TABLE_NAME+" Where userName =? AND password =?";
        String[] arr ={userName,password};
        Cursor cursor = database.rawQuery(sqlquery,arr);

        if (cursor.moveToFirst())
        {
            do{
                Users user=new Users();
                user.setId(cursor.getInt(cursor.getColumnIndex(Users.u_ID)));
                user.setPhone(cursor.getString(cursor.getColumnIndex(Users.u_Phone)));
                user.setUserName(cursor.getString(cursor.getColumnIndex(Users.u_UserName)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(Users.u_Email)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(Users.u_Password)));


                users.add(user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }


}

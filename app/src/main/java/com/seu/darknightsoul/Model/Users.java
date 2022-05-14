package com.seu.darknightsoul.Model;

import java.io.Serializable;

public class Users implements Serializable {
    public int id ;
    public String userName ;
    public String phone ;
    public String email ;
    public String password ;

    public static final String TABLE_NAME = "users";

    public Users(int id, String userName, String phone, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    //Name Column table
    public static final String u_ID = "id";
    public static final String u_UserName = "userName";
    public static final String u_Phone = "phone";
    public static final String u_Email = "email";
    public static final String u_Password = "password";



    //create table
    public static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME +" ("+u_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            u_UserName +" TEXT,"+
            u_Phone +" TEXT,"+
            u_Email +" TEXT,"+
            u_Password +" TEXT"+");";

    public Users() {

    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}

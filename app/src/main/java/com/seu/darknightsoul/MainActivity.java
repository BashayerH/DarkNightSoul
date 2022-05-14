package com.seu.darknightsoul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.seu.darknightsoul.Database.DBhelper;
import com.seu.darknightsoul.Model.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText userName,password;
    TextView sigUp;
    ImageView logIn;
    DBhelper dp;
    ArrayList<Users> data ;
    ArrayList<Users> newData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName=findViewById(R.id.username);
        password =findViewById(R.id.pass);
        sigUp =findViewById(R.id.signUp);
        logIn = findViewById(R.id.logIn);
        data = new ArrayList<>();

       dp = new DBhelper(this);
        newData.addAll(dp.getAllUser());


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ediUserName = userName.getText().toString().trim();
                String ediPass = password.getText().toString().trim();

                if (ediUserName.isEmpty() && ediPass.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Please fill in all the details!", Toast.LENGTH_SHORT).show();
                }else {

                    if (newData.size() != 0) {

                        if (newData.get(0).getUserName().equals(ediUserName) && newData.get(0).getPassword().equals(ediPass)) {
                            data.addAll(dp.getAllUserBy(ediUserName, ediPass));

                            SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
                        editor.putString("name", newData.get(0).getUserName());
                        editor.apply();

                            Intent intentI = new Intent(getApplicationContext(),Home.class);
                            intentI.putExtra("users", data);
                            startActivity(intentI);
                            finish();
                            Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Error In Password OR UserName", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Data2.Size == 0", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });



        sigUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });


    }
}
package com.seu.darknightsoul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.seu.darknightsoul.Database.DBhelper;

public class SignUp extends AppCompatActivity {
    EditText entName,entPassword,entPhone,entEmail;
    ImageView signIn;
    DBhelper dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        entEmail= findViewById(R.id.emil);
        entName = findViewById(R.id.name);
        entPhone = findViewById(R.id.phone);
        entPassword = findViewById(R.id.password);
        signIn = findViewById(R.id.signIn);

        dp = new DBhelper(this);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edtEmil = entEmail.getText().toString().trim();
                String edtName = entName.getText().toString().trim();
                String edtPhone = entPhone.getText().toString().trim();
                String edtPass = entPassword.getText().toString().trim();

                if (edtName.isEmpty()&& edtEmil.isEmpty()&&edtPhone.isEmpty()&&edtPass.isEmpty()){

                    Toast.makeText(SignUp.this, "Please fill in all the details!", Toast.LENGTH_SHORT).show();
                }else {

                    Boolean insert = dp.insertUsers(edtName,edtPhone,edtEmil,edtPass);
                    if (insert){

                        Toast.makeText(SignUp.this, "Your account has been created", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(SignUp.this, "Your account has been created", Toast.LENGTH_LONG).show();


                    }else {
                        Toast.makeText(SignUp.this, "There is something wrong,no account created!!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
package com.seu.darknightsoul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.seu.darknightsoul.Model.DrList;

public class DrDetails extends AppCompatActivity {

    ImageView drImgDt,call,msg;
    TextView nameD,spcD,detailD;
    Button send;
    DrList object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_details);

        drImgDt= findViewById(R.id.imageViewdr);
        nameD = findViewById(R.id.textViewName);
        spcD = findViewById(R.id.textViewSpc);
        detailD = findViewById(R.id.textViewDet);
        call =findViewById(R.id.call);
        msg = findViewById(R.id.sms);

        getDrInfo();

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog smsD =new Dialog(DrDetails.this);
                smsD.setContentView(R.layout.sms_dialog);
                send = smsD.findViewById(R.id.buttonSend);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(DrDetails.this, "the message send", Toast.LENGTH_SHORT).show();
                        smsD.dismiss();
                        }

                });
                smsD.show();
            }
        });
    }



    private void  getDrInfo(){
        object = (DrList) getIntent().getSerializableExtra("object");
        detailD.setText(object.getDrDtl());
        spcD.setText(object.getDrSpecial());
        nameD.setText(object.getDrName());
        drImgDt.setImageResource(object.getDrImg());


    }

}
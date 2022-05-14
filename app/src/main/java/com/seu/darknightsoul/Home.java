package com.seu.darknightsoul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.seu.darknightsoul.Adapters.InfoAdapter;
import com.seu.darknightsoul.Database.DBhelper;
import com.seu.darknightsoul.Model.InfoList;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private InfoAdapter infoAdapter;
    private RecyclerView infoRV;
    TextView userName;
    DBhelper dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dp = new DBhelper(this);
        userName= findViewById(R.id.theName);
        userName.setText(dp.getAllUser().get(0).getUserName());

        List<InfoList> listOfInfo = new ArrayList<>();
        listOfInfo.add(new InfoList("the meaning",R.drawable.night,"The ‘dark night’ symbolizes an obscuration, and ‘soul’ usually refers to an individual’s true essence. In other words: the dark night of the soul is the obscuration of the true self. The obscuration may consist of a previous idea of what one believes about themselves or the world that is thrown into question.\n"+
                "As we grow through different stages of life, we are influenced by many aspects of our surroundings. From birth, the family impresses upon a child a name, what the family believes, and what is acceptable and unacceptable"));
        listOfInfo.add(new InfoList("the Sign!",R.drawable.sign,"\n" +
                "1- You feel a deep sense of sadness, which often verges on despair (this sadness is often triggered by the state of your life, humanity, and/or the world as a whole)\n" +
                "2- You feel an acute sense of unworthiness\n" +
                "3- You have the constant feeling of being lost or “condemned” to a life of suffering or emptiness\n" +
                "4- You possess a painful feeling of powerlessness and hopelessness\n" +
                "5- Your will and self-control is weakened, making it difficult for you to act\n" +
                "6- You lack interest and find no joy in things that once excited you\n" +
                "7- You crave for the loss of something intangible; a longing for a distant place or to “return home” again"));
        listOfInfo.add(new InfoList("during of time",R.drawable.time,"This night is more like a polar night, where due to the earth’s tilt (life conditions), the area is in darkness much longer than the regular night and day (happiness and sadness) the rest of the world (the person) is used to. This experience, however, as miserable as it may seem, hides extraordinary potential. Patience is essential as any attempt to forcefully speed up the process will inevitably hinder it.\n"+"" +
                "The hardest part of the dark night of the soul is to face your shadow which contains the repressed parts of yourself such as your fears, desires, traumas, and beliefs. Behind the dark night of the soul is the treasure of the underworld. It is guarded by a dragon, but you must go into the belly of this beast. If you turn away it will slowly devour you."));
        listOfInfo.add(new InfoList("Need Help",R.drawable.help,""));



        setInfoRV(listOfInfo);
    }

    private void setInfoRV(List<InfoList> listOfInfo){
        infoRV = findViewById(R.id.recyclerInfo);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        infoRV.setLayoutManager(layoutManager);
        infoAdapter = new InfoAdapter(this,listOfInfo);
        infoRV.setAdapter(infoAdapter);
    }
}
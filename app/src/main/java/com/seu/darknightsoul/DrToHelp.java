package com.seu.darknightsoul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.seu.darknightsoul.Adapters.DrAdapter;
import com.seu.darknightsoul.Model.DrList;

import java.util.ArrayList;
import java.util.List;

public class DrToHelp extends AppCompatActivity {

    private DrAdapter drAdapter;
    private RecyclerView drRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_to_help);

        List<DrList> listOfDr = new ArrayList<>();
        listOfDr.add(new DrList("Dr.Bashair AlTabbaa",R.drawable.drf1,"Mood disorders (depression), \n" +
                "Anxiety disorders and obsessions, \n" +
                "Marriage Counselling/Relationship Disorders","Separation Anxiety Disorder,\n"+
                " Generalized Anxiety Disorder,\n"+ "and Social Phobia, Bipolar disorders","English And Arabic"));
        listOfDr.add(new DrList("Dr. Mahmoud Sahloul",R.drawable.drm1,"Mood disorders (depression), \n" +
                "Anxiety disorders and obsessions, \n" +
                "Psychotic disorders, \n" +
                "Addiction","Mood Disorders,\n"+" Posttraumatic Stress Disorde","English And Arabic"));
        listOfDr.add(new DrList("Dr. Zacharia Fakhoury",R.drawable.drm2,"Adolescence disorders, \n" +
                "Mood disorders (depression), \n" +
                "Anxiety disorders and obsessions, \n" +
                "Marriage Counselling/Relationship Disorders, \n" +
                "Sexual disorders, \n" +
                "Old age disorders","Depression, Anxiety Disorders","English And Arabic"));
        listOfDr.add(new DrList("Dr.Ahmed Hashish",R.drawable.drm3,"Mood disorders (depression), \n" +
                "Anxiety disorders and obsessions, \n" +
                "Marriage Counselling/Relationship Disorders, \n" +
                "Addiction, \n" +
                "Sexual disorders,","Anxiety Disorders, \n"+"Posttraumatic Stress Disorder","English And Arabic"));
        listOfDr.add(new DrList("Dr.Fatma Mahmoud",R.drawable.drf2,"Child disorders, \n" +
                "Mood disorders (depression), \n" +
                "Anxiety disorders and obsessions, \n" +
                "Psychotic disorders, ","Depression,\n"+" Obsessive-Compulsive Disorder","English And Arabic"));
        listOfDr.add(new DrList("Dr.Amira Moustafa",R.drawable.drf3,"Child disorders, \n" +
                "Adolescence disorders, \n" +
                "Mood disorders (depression), \n" +
                "Anxiety disorders and obsessions, \n" +
                "Marriage Counselling/Relationship Disorders, ","Depression,\n"+" Specific Phobia and Social Phobia","Arabic"));
        listOfDr.add(new DrList("Dr.Ayman Eldeeb",R.drawable.drm1,"Adolescence disorders, \n" +
                "Mood disorders (depression), \n" +
                "Marriage Counselling/Relationship Disorders,","Depression,\n"+" Personality disorders","English And Arabic"));
        setDrRV(listOfDr);
    }

    private void setDrRV(List<DrList> listOfDr){
        drRV = findViewById(R.id.recyclerDr);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);

        drRV.setLayoutManager(layoutManager);
        drAdapter = new DrAdapter(this,listOfDr);
        drRV.setAdapter(drAdapter);
    }
}
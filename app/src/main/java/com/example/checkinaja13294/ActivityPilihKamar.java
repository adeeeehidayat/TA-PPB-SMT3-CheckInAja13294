package com.example.checkinaja13294;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ActivityPilihKamar extends AppCompatActivity {

    ActionBar actionBar;
    RecyclerView recyclerView;
    ArrayList<Model> arrayList = new ArrayList<>();

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void pesanKamar(View view) {
        Intent intent = new Intent(ActivityPilihKamar.this, ActivityPesanKamar.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_kamar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new Model(R.drawable.single_room,
                "Single Room",
                "Rp. 255.000",
                "1 Single Bed",
                "Kamar Mandi",
                "",
                "",
                ""));
        arrayList.add(new Model(R.drawable.double_room,
                "Double Room",
                "Rp. 500.000",
                "2 Double Bed",
                "Kamar Mandi",
                "",
                "",
                ""));
        arrayList.add(new Model(R.drawable.twin_room,
                "Twin Room",
                "Rp. 400.000",
                "2 Single Bed",
                "Kamar Mandi",
                "",
                "",
                ""));
        arrayList.add(new Model(R.drawable.junior_suite,
                "Junior Suite",
                "Rp. 800.000",
                "2 King Size Bed",
                "1 Sofa",
                "1 Meja Kerja",
                "Kamar Mandi",
                ""));
        arrayList.add(new Model(R.drawable.senior_suite,
                "Senior Suite",
                "Rp. 1.100.000",
                "2 King Size Bed",
                "2 Sofa",
                "2 Meja Kerja",
                "Kamar Mandi",
                ""));

        ModelRecyclerView modelRecyclerView = new ModelRecyclerView(this,arrayList);
        recyclerView.setAdapter(modelRecyclerView);
    }
}
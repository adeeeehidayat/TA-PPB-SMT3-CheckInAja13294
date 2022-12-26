package com.example.checkinaja13294;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTampilanKamar extends AppCompatActivity {

    ActionBar actionBar;
    ImageView img;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;

    // fungsi untuk button pesan kamar
    // akan diarahkan ke activity pesan kamar
    public void pesanKamar(View view) {
        Intent intent = new Intent(ActivityTampilanKamar.this, ActivityPesanKamar.class);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_kamar);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        img = findViewById(R.id.img);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);

        // menampilkan isi konten tampilan kamar dari arraylist
        Intent intent = getIntent();
        String nama = intent.getExtras().getString("nama");
        String harga = intent.getExtras().getString("harga");
        String deskripsi1 = intent.getExtras().getString("deskripsi1");
        String deskripsi2 = intent.getExtras().getString("deskripsi2");
        String deskripsi3 = intent.getExtras().getString("deskripsi3");
        String deskripsi4 = intent.getExtras().getString("deskripsi4");
        String deskripsi5 = intent.getExtras().getString("deskripsi5");
        int image = intent.getExtras().getInt("foto");

        tv1.setText(nama);
        tv2.setText(harga);
        tv3.setText(deskripsi1);
        tv4.setText(deskripsi2);
        tv5.setText(deskripsi3);
        tv6.setText(deskripsi4);
        tv7.setText(deskripsi5);
        img.setImageResource(image);

    }
}


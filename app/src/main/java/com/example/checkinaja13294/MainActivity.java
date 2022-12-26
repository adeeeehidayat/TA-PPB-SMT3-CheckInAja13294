package com.example.checkinaja13294;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AdapterDataTamu adapterDataTamu;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelPesanKamar> listDataTamu;
    RecyclerView tampil_data_tamu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tampil_data_tamu = findViewById(R.id.tampil_data_tamu);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        tampil_data_tamu.setLayoutManager(mLayout);
        tampil_data_tamu.setItemAnimator(new DefaultItemAnimator());

        tampilDataTamu();
    }

    // menampilkan data tamu dari database firebase
    private void tampilDataTamu() {
        database.child("dataTamu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listDataTamu = new ArrayList<>();
                for (DataSnapshot item : snapshot.getChildren()){
                    ModelPesanKamar tamu = item.getValue(ModelPesanKamar.class);
                    tamu.setKey(item.getKey());
                    listDataTamu.add(tamu);
                }
                adapterDataTamu = new AdapterDataTamu(listDataTamu, MainActivity.this);
                tampil_data_tamu.setAdapter(adapterDataTamu);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    // fungsi untuk button lihat kamar
    // diarahkan ke activity pilih kamar
    public void pindahKamar(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityPilihKamar.class);
        startActivity(intent);
    }
    // fungsi untuk button lihat lokasi
    // diarahkan ke aplikasi google maps sesuai koordinat
    public void showMap (View view){
        Uri uri = Uri.parse("geo:-6.982628,110.409207=");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    // fungsi untuk button telepon
    // diarahkan ke aplikasi telepon
    public void telepon (View view){
        Uri uri = Uri.parse("tel:089644135314");
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }
    // fungsi untuk button email
    // diarahkan untuk mengirim pesan lewat email
    public void email (View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"111202113294@mhs.dinus.ac.id"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Email dari Aplikasi Android");

        try {
            startActivity(Intent.createChooser(intent, "Ingin Mengirim Email ?"));
        } catch (android.content.ActivityNotFoundException ignored) {

        }
    }
}
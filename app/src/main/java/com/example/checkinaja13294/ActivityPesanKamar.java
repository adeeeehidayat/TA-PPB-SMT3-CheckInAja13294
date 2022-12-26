package com.example.checkinaja13294;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityPesanKamar extends AppCompatActivity {

    EditText edtJenisKelamin, edtKewarganegaraan, edtTipeKamar, edtNamaTamu,
            edtEmail, edtNotelpon, edtCekin, edtCekout, edtJmlDewasa, edtJmlAnak;
    Button btnPesanTamu;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesan_kamar);

        edtTipeKamar = findViewById(R.id.edtTipeKamar);
        edtNamaTamu = findViewById(R.id.edtNamaTamu);
        edtJenisKelamin = findViewById(R.id.edtJenisKelamin);
        edtKewarganegaraan = findViewById(R.id.edtKewarganegaraan);
        edtEmail = findViewById(R.id.edtEmail);
        edtNotelpon = findViewById(R.id.edtNotelpon);
        edtCekin = findViewById(R.id.edtCekin);
        edtCekout = findViewById(R.id.edtCekout);
        edtJmlDewasa = findViewById(R.id.edtJmlDewasa);
        edtJmlAnak = findViewById(R.id.edtJmlAnak);
        btnPesanTamu = findViewById(R.id.btnPesanTamu);

        // fungsi untuk button pesan sekarang
        // akan memasukkan data tamu ke dalam database firebase
        btnPesanTamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTipeKamar = edtTipeKamar.getText().toString();
                String getNamaTamu = edtNamaTamu.getText().toString();
                String getJenisKelamin = edtJenisKelamin.getText().toString();
                String getKewarganegaraan = edtKewarganegaraan.getText().toString();
                String getEmail = edtEmail.getText().toString();
                String getNoTelpon = edtNotelpon.getText().toString();
                String getCekin = edtCekin.getText().toString();
                String getCekout = edtCekout.getText().toString();
                String getJmlDewasa = edtJmlDewasa.getText().toString();
                String getJmlAnak = edtJmlAnak.getText().toString();

                if(getTipeKamar.isEmpty()){
                    edtTipeKamar.setError("Masukkan Tipe Kamar...");
                }else if (getNamaTamu.isEmpty()){
                    edtNamaTamu.setError("Masukkan Nama Tamu...");
                }else if (getJenisKelamin.isEmpty()){
                    edtJenisKelamin.setError("Masukkan Jenis Kelamin...");
                }else if (getKewarganegaraan.isEmpty()){
                    edtKewarganegaraan.setError("Masukkan Kewarganegaraan...");
                }else if (getEmail.isEmpty()){
                    edtEmail.setError("Masukkan Email...");
                }else if (getNoTelpon.isEmpty()){
                    edtNotelpon.setError("Masukkan No Telpon...");
                }else if (getCekin.isEmpty()){
                    edtCekin.setError("Masukkan Tanggal Check-In...");
                }else if (getCekout.isEmpty()){
                    edtCekout.setError("Masukkan Tanggal Check-Out...");
                }else if (getJmlDewasa.isEmpty()){
                    edtJmlDewasa.setError("Masukkan Jumlah Dewasa...");
                }else if (getJmlAnak.isEmpty()){
                    edtJmlAnak.setError("Masukkan Jumlah Anak-anak...");
                }else{
                    database.child("dataTamu").push().setValue(new ModelPesanKamar(
                            getTipeKamar, getNamaTamu, getJenisKelamin, getKewarganegaraan,
                            getEmail, getNoTelpon, getCekin, getCekout, getJmlDewasa, getJmlAnak
                    )).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        // jika berhasil input data maka munculkan pesan "Data berhasil disimpan" dengan toast
                        public void onSuccess(Void unused) {
                            Toast.makeText(ActivityPesanKamar.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ActivityPesanKamar.this, MainActivity.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        // jika gagal input data maka munculkan pesan "Gagal menyimpan data..." dengan toast
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ActivityPesanKamar.this, "Gagal menyimpan data...", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
package com.example.checkinaja13294;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {
    String tipeKamar, namaTamu, jenisKelamin, kewarganegaraan, email, notelpon, cekin, cekout, jmlDewasa, jmlAnak, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogForm(String tipeKamar, String namaTamu, String jenisKelamin, String kewarganegaraan, String email, String notelpon, String cekin, String cekout, String jmlDewasa, String jmlAnak, String key, String pilih) {
        this.tipeKamar = tipeKamar;
        this.namaTamu = namaTamu;
        this.jenisKelamin = jenisKelamin;
        this.kewarganegaraan = kewarganegaraan;
        this.email = email;
        this.notelpon = notelpon;
        this.cekin = cekin;
        this.cekout = cekout;
        this.jmlDewasa = jmlDewasa;
        this.jmlAnak = jmlAnak;
        this.key = key;
        this.pilih = pilih;
    }

    TextView txtNamaTamu, txtNoTelpon, txtEmail, txtJenisKelamin,
            txtKewarganegaraan, txtTipeKamar, txtCekin, txtCekout,
            txtJmlDewasa, txtJmlAnak;
    Button btnPesanTamu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.pesan_kamar, container, false);
        txtNamaTamu = view.findViewById(R.id.edtNamaTamu);
        txtNoTelpon = view.findViewById(R.id.edtNotelpon);
        txtEmail = view.findViewById(R.id.edtEmail);
        txtJenisKelamin = view.findViewById(R.id.edtJenisKelamin);
        txtKewarganegaraan = view.findViewById(R.id.edtKewarganegaraan);
        txtTipeKamar = view.findViewById(R.id.edtTipeKamar);
        txtCekin = view.findViewById(R.id.edtCekin);
        txtCekout = view.findViewById(R.id.edtCekout);
        txtJmlDewasa = view.findViewById(R.id.edtJmlDewasa);
        txtJmlAnak = view.findViewById(R.id.edtJmlAnak);
        btnPesanTamu = view.findViewById(R.id.btnPesanTamu);

        txtNamaTamu.setText(namaTamu);
        txtNoTelpon.setText(notelpon);
        txtEmail.setText(email);
        txtJenisKelamin.setText(jenisKelamin);
        txtKewarganegaraan.setText(kewarganegaraan);
        txtTipeKamar.setText(tipeKamar);
        txtCekin.setText(cekin);
        txtCekout.setText(cekout);
        txtJmlDewasa.setText(jmlDewasa);
        txtJmlAnak.setText(jmlAnak);
        btnPesanTamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaTamu = txtNamaTamu.getText().toString();
                String noTelpon = txtNoTelpon.getText().toString();
                String email = txtEmail.getText().toString();
                String jenisKelamin = txtJenisKelamin.getText().toString();
                String kewarganegaraan = txtKewarganegaraan.getText().toString();
                String tipeKamar = txtTipeKamar.getText().toString();
                String cekin = txtCekin.getText().toString();
                String cekout = txtCekout.getText().toString();
                String jmlDewasa = txtJmlDewasa.getText().toString();
                String jmlAnak = txtJmlAnak.getText().toString();
                if (pilih.equals("Ubah")){
                    database.child("dataTamu").child(key).setValue(new ModelPesanKamar(namaTamu, noTelpon, email,
                            jenisKelamin, kewarganegaraan, tipeKamar, cekin, cekout, jmlDewasa, jmlAnak)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Berhasil update data", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Gagal update data", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}

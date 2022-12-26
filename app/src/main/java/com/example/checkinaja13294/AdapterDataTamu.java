package com.example.checkinaja13294;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterDataTamu extends RecyclerView.Adapter<AdapterDataTamu.ViewHolder> {
    private List<ModelPesanKamar> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdapterDataTamu(List<ModelPesanKamar>mList, Activity activity){
        this.mList = mList;
        this.activity = activity;
    }
    @NonNull
    @Override
    // menampilkan layout data tamu
    public AdapterDataTamu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_data_tamu, parent, false);
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDataTamu.ViewHolder holder, int position) {
        final ModelPesanKamar data = mList.get(position);
        holder.txtNamaTamu.setText(data.getNamaTamu());
        holder.txtNoTelpon.setText(data.getNotelpon());
        holder.txtEmail.setText(data.getEmail());
        holder.txtJenisKelamin.setText(data.getJenisKelamin());
        holder.txtKewarganegaraan.setText(data.getKewarganegaraan());
        holder.txtTipeKamar.setText(data.getTipeKamar());
        holder.txtCekin.setText(data.getCekin());
        holder.txtCekout.setText(data.getCekout());
        holder.txtJmlDewasa.setText(data.getJmlDewasa());
        holder.txtJmlAnak.setText(data.getJmlAnak());

        // fungsi button hapus data tamu
        holder.btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // jika tekan iya maka data akan dihapus
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        database.child("dataTamu").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                // jika berhasil menghapus data tampilkan pesan "Data berhasil dihapus"
                                Toast.makeText(activity, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // jika gagal menghapus data tampilkan pesan "Gagal menghapus data"
                                Toast.makeText(activity, "Gagal menghapus data", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                // jika tekan tidak maka akan dismiss kembali ke menu utama
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setMessage("Apakah yakin mau menghapus ? " + data.getNamaTamu());
                builder.show();
            }
        });

        // menampilkan cardview untuk update data tamu
        // dengan melakukan tekan & tahan pada data tamu
        holder.card_tamu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                DialogForm dialog = new DialogForm(
                        data.getTipeKamar(),
                        data.getNamaTamu(),
                        data.getJenisKelamin(),
                        data.getKewarganegaraan(),
                        data.getEmail(),
                        data.getNotelpon(),
                        data.getCekin(),
                        data.getCekout(),
                        data.getJmlDewasa(),
                        data.getJmlAnak(),
                        data.getKey(),
                        "Ubah"
                );
                dialog.show(manager, "form");
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaTamu, txtNoTelpon, txtEmail, txtJenisKelamin,
                txtKewarganegaraan, txtTipeKamar, txtCekin, txtCekout,
                txtJmlDewasa, txtJmlAnak;
        ImageView btn_hapus;
        CardView card_tamu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamaTamu = itemView.findViewById(R.id.txtNamaTamu);
            txtNoTelpon = itemView.findViewById(R.id.txtNoTelpon);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtJenisKelamin = itemView.findViewById(R.id.txtJenisKelamin);
            txtKewarganegaraan = itemView.findViewById(R.id.txtKewarganegaraan);
            txtTipeKamar = itemView.findViewById(R.id.txtTipeKamar);
            txtCekin = itemView.findViewById(R.id.txtCekin);
            txtCekout = itemView.findViewById(R.id.txtCekout);
            txtJmlDewasa = itemView.findViewById(R.id.txtJmlDewasa);
            txtJmlAnak = itemView.findViewById(R.id.txtJmlAnak);
            card_tamu = itemView.findViewById(R.id.card_tamu);
            btn_hapus = itemView.findViewById(R.id.hapus);
        }
    }
}

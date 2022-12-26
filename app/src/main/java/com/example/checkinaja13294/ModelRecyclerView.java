package com.example.checkinaja13294;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModelRecyclerView extends RecyclerView.Adapter<ModelRecyclerView.ViewHolder> {

    Context context;
    ArrayList<Model> arrayList = new ArrayList<>();

    public ModelRecyclerView(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_pilihan_kamar, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    // fungsi untuk menampilkan list kamar yang tersedia
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImage());
        holder.textView1.setText(arrayList.get(position).getNama());
        holder.textView2.setText(arrayList.get(position).getHarga());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityTampilanKamar.class);
                intent.putExtra("foto", arrayList.get(position).getImage());
                intent.putExtra("nama", arrayList.get(position).getNama());
                intent.putExtra("harga", arrayList.get(position).getHarga());
                intent.putExtra("deskripsi1", arrayList.get(position).getDeskripsi1());
                intent.putExtra("deskripsi2", arrayList.get(position).getDeskripsi2());
                intent.putExtra("deskripsi3", arrayList.get(position).getDeskripsi3());
                intent.putExtra("deskripsi4", arrayList.get(position).getDeskripsi4());
                intent.putExtra("deskripsi5", arrayList.get(position).getDeskripsi5());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}

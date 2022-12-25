package com.example.checkinaja13294;

public class Model {
    int image;
    String nama, harga, deskripsi1, deskripsi2, deskripsi3, deskripsi4, deskripsi5;

    public Model(int image, String nama, String harga, String deskripsi1, String deskripsi2, String deskripsi3, String deskripsi4, String deskripsi5) {
        this.image = image;
        this.nama = nama;
        this.harga = harga;
        this.deskripsi1 = deskripsi1;
        this.deskripsi2 = deskripsi2;
        this.deskripsi3 = deskripsi3;
        this.deskripsi4 = deskripsi4;
        this.deskripsi5 = deskripsi5;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDeskripsi1() {
        return deskripsi1;
    }

    public void setDeskripsi1(String deskripsi1) {
        this.deskripsi1 = deskripsi1;
    }

    public String getDeskripsi2() {
        return deskripsi2;
    }

    public void setDeskripsi2(String deskripsi2) {
        this.deskripsi2 = deskripsi2;
    }

    public String getDeskripsi3() {
        return deskripsi3;
    }

    public void setDeskripsi3(String deskripsi3) {
        this.deskripsi3 = deskripsi3;
    }

    public String getDeskripsi4() {
        return deskripsi4;
    }

    public void setDeskripsi4(String deskripsi4) {
        this.deskripsi4 = deskripsi4;
    }

    public String getDeskripsi5() {
        return deskripsi5;
    }

    public void setDeskripsi5(String deskripsi5) {
        this.deskripsi5 = deskripsi5;
    }
}


package com.example.checkinaja13294;

public class ModelPesanKamar {
    String tipeKamar, namaTamu, jenisKelamin, kewarganegaraan, email, notelpon, cekin, cekout, jmlDewasa, jmlAnak, key;

    public ModelPesanKamar(){

    }

    public ModelPesanKamar(String tipeKamar, String namaTamu, String jenisKelamin, String kewarganegaraan, String email, String notelpon, String cekin, String cekout, String jmlDewasa, String jmlAnak) {
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
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public void setNamaTamu(String namaTamu) {
        this.namaTamu = namaTamu;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotelpon() {
        return notelpon;
    }

    public void setNotelpon(String notelpon) {
        this.notelpon = notelpon;
    }

    public String getCekin() {
        return cekin;
    }

    public void setCekin(String cekin) {
        this.cekin = cekin;
    }

    public String getCekout() {
        return cekout;
    }

    public void setCekout(String cekout) {
        this.cekout = cekout;
    }

    public String getJmlDewasa() {
        return jmlDewasa;
    }

    public void setJmlDewasa(String jmlDewasa) {
        this.jmlDewasa = jmlDewasa;
    }

    public String getJmlAnak() {
        return jmlAnak;
    }

    public void setJmlAnak(String jmlAnak) {
        this.jmlAnak = jmlAnak;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

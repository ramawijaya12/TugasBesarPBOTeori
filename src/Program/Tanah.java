/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

/**
 *
 * @author RAMA
 */
public class Tanah {
    private String pemilik,lokasi;
    private float panjang,lebar,harga,hargatot;
    private int id;
    public Tanah() {
    }
    public Tanah(String pemilik){
        this.pemilik=pemilik;
    }
//    Tanah(String pemilik,String lokasi,float p,float l,float h, float htot){
//        this.pemilik = pemilik;
//        this.lokasi = lokasi;
//    }
    public Tanah(String pemilik,int id){
        this.pemilik=pemilik;
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tanah(String pemilik, String lokasi, float panjang, float lebar, float harga, float hargatot) {
        this.pemilik = pemilik;
        this.lokasi = lokasi;
        this.panjang = panjang;
        this.lebar = lebar;
        this.harga = harga;
        this.hargatot = hargatot;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
     public float getPanjang() {
        return panjang;
    }

    public void setPanjang(float panjang) {
        this.panjang = panjang;
    }

    public float getLebar() {
        return lebar;
    }

    public void setLebar(float lebar) {
        this.lebar = lebar;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public float getHargatot() {
        return hargatot;
    }

    public void setHargatot(float hargatot) {
        this.hargatot = hargatot;
    }
}

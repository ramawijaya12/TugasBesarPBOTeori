/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author RAMA
 */
public class Utama {
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        InterfaceTanah crud = new CRUD();
        Tanah tanah = new  Tanah();
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String pemilik,lokasi;
        float l,p,h,htot;
        int pilih;
        do{
        System.out.println("Penjualan Tanah ");
        System.out.println("1. Tambah Data Penjualan ");
        System.out.println("2. Update Data ");
        System.out.println("3. Delete Data ");
        System.out.println("4. Tampil");
        System.out.println("5. Keluar");
        System.out.print("Masukan Pilihan : ");
        pilih=Integer.parseInt(s.readLine());
        
        switch (pilih) {
            case 1 :System.out.println("Tambah Data Penjualan Tanah ");
                    System.out.print("1. Pemilik : ");
                    pemilik =s.readLine();  
                    System.out.print("2. Lokasi : ");
                    lokasi = s.readLine();
                    tanah.setLokasi(lokasi);
                    System.out.print("3. Panjang Tanah(m2) : ");
                    p=Float.parseFloat(s.readLine());
                    tanah.setPanjang(p);
                    System.out.print("4. Lebar Tanah(m2)  : ");
                    l=Float.parseFloat(s.readLine());
                    tanah.setLebar(l);
                    System.out.print("5. Harga/m2 : ");
                    h=Float.parseFloat(s.readLine());
                    tanah.setHarga(h);
                    System.out.print("6. Harga Total : ");
                    htot=((p*l)*h);
                    System.out.println(htot);
                    tanah.setHargatot(htot);
                    tanah = new Tanah(pemilik,lokasi,p,l,h,htot);
                    crud.insert(tanah);
                       break;
            case 2:
                System.out.print("Masukkan nama pemilik yang baru :");
                String pemilikBaru = s.readLine();
                tanah.setPemilik(pemilikBaru);
                System.out.print("Pada id : ");
                int id = Integer.parseInt(s.readLine());
                tanah.setId(id);
                tanah = new Tanah(pemilikBaru,id);
                crud.update(tanah, id);
                break;
            case 3:
                System.out.print("Masukan id yang akan dihapus : ");
                id = Integer.parseInt(s.readLine());
                tanah.setId(id);
                crud.delete(id);
                break;
            case 4:
                crud.tampil();
                break;
        }
     }while (pilih!=5);
        
        
//Test Koneksi
//      Connection connection = null;
//        try {
//            connection=Koneksi.getConnection();
//            if(connection!=null){
//                System.out.println("Successfull");
//            }
//            else{
//                System.out.println("Failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
   }
}
  

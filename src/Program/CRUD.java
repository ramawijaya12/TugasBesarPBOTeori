/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAMA
 */
public class CRUD implements InterfaceTanah {
    public void insert(Tanah tanah) {
        Connection koneksi = null;
        Statement statement = null;
        String sql ="INSERT INTO `tanah` ( `pemilik`, `lokasi`, `panjang`, `lebar`, `harga`, `hargatotal`)"
                + " VALUES ('"+tanah.getPemilik()+"', '"+tanah.getLokasi()+"', '"+tanah.getPanjang()+"', '"+tanah.getLebar()+"', '"+tanah.getHarga()+"', '"+tanah.getHargatot()+"')";
        try{
            koneksi = Koneksi.getConnection();
            statement = koneksi.createStatement();
            statement.execute(sql);
            System.out.println("INSERT INTO tanah(pemilik,lokasi,panjang,lebar,harga,hargatot),"+"VALUE(?,?)");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(statement!=null){
                try{statement.close();
                }catch(SQLException e){
                e.printStackTrace();
                }
            }
            if(koneksi !=null){
                try{
                    koneksi.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(Tanah tanah,int id) {
    Connection koneksi =null;
    Statement statement =null;
    String sql ="update tanah set pemilik='"+tanah.getPemilik()+"' where id="+tanah.getId();
    try{
        koneksi=Koneksi.getConnection();
        statement=koneksi.createStatement();
        statement.execute(sql);
    }catch (Exception e){
        e.printStackTrace();
    }
            
    }

    @Override
    public void delete( int id) {
         Connection koneksi = null;
        PreparedStatement preparedStatement = null;
        try {
            koneksi = Koneksi.getConnection();
            preparedStatement = koneksi.prepareStatement("DELETE FROM tanah where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM tanah where id = ?");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (koneksi != null) {
                try {
                    koneksi.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Tanah> tampil() {
        List<Tanah> tanahs = new ArrayList<Tanah>();
        Connection koneksi = null;
        Statement statement = null;
        ResultSet resultset = null;
        
        try {
            koneksi = Koneksi.getConnection();
            statement = koneksi.createStatement();
            resultset = statement.executeQuery("SELECT * FROM tanah");
            Tanah tanah = new Tanah();
            System.out.print("id pemilik lokasi panjang lebar harga hargatotal");
            System.out.println("");
            while (resultset.next()) {
              
               
                int id = resultset.getInt("id");
                String pemilik = resultset.getString("pemilik");
                String lokasi = resultset.getString("lokasi");
                float panjang = resultset.getFloat("panjang");
                float lebar = resultset.getFloat("lebar");
                float harga = resultset.getFloat("harga");
                float hargatotal = resultset.getFloat("hargatotal");
                System.out.print(id+" "+pemilik+" "+lokasi+" "+panjang+" "+lebar+" "+harga+" "+hargatotal+" ");
                System.out.println(" ");
                tanahs.add(tanah);
            }
            
        }catch (Exception e){
        e.printStackTrace();
    }   finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (koneksi != null) {
                try {
                    koneksi.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return tanahs;
    
    }
}

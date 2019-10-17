package otopark;

import Login.Login;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import otopark.User;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable{
    private static final long serialVersionUID = 1L;
    private Connection conn;
    static String username="";

    static final String DB_URL = "jdbc:derby://localhost:1527/otopark";
    private String kullanici_adi="admin";
    private String parola="APP";
    PreparedStatement ps=null;

    

    public List<User> getUsers() {
        List<User> list=new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT OTOPARKFATIH.PLAKA, YIKAMA.YIKAMA, YIKAMA.FIYAT FROM OTOPARKFATIH LEFT JOIN YIKAMA  ON YIKAMA.PLAKA=OTOPARKFATIH.PLAKA");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                User usr = new User();
                usr.setPlaka(rs.getString("plaka"));
                usr.setYikama(rs.getBoolean("yikama"));
                usr.setUcret(rs.getInt("fiyat"));

                list.add(usr);
            }
 
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(conn!=null){ //Connection nesnesi belki yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    conn.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    //Datatable bir dizi veya listi alıp işleyebilir bizde bir liste göndereceğiz
        return list;
    }
    
    public List<User> getYikama() {
        List<User> list=new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT YIKAMA.PLAKA, YIKAMA.YIKAMA, YIKAMA.FIYAT FROM YIKAMA INNER JOIN USERS  ON YIKAMA.PLAKA=USERS.PLAKA");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                User usr = new User();
                usr.setPlaka(rs.getString("plaka"));
                usr.setYikama(rs.getBoolean("yikama"));
                usr.setUcretyika(rs.getInt("fiyat"));
                list.add(usr);
            }
 
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(conn!=null){ //Connection nesnesi belki yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    conn.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    //Datatable bir dizi veya listi alıp işleyebilir bizde bir liste göndereceğiz
        return list;
    }
    
    public List<Otopark> ucretlendirmeler() {
         List<Otopark> list=new ArrayList<>();
         username=Login.user;
         System.out.println("******************");
                  System.out.println(username);
         System.out.println("******************");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT * FROM OTOPARKATASEHIR WHERE USERNAME='"+username+"'");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                
                Otopark otoparka = new Otopark();
                otoparka.setPlaka(rs.getString("plaka"));
                otoparka.setSaat(rs.getInt("saat"));
                otoparka.setUcret(rs.getInt("ucret"));
                otoparka.setSube("Ataşehir");
                list.add(otoparka);
 
            }
 
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(conn!=null){ //Connection nesnesi belki yukarıda null kalmıştır.
                    conn.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmıştır.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT * FROM OTOPARKFATIH WHERE USERNAME='"+username+"'");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                
                Otopark otoparka = new Otopark();
                otoparka.setPlaka(rs.getString("plaka"));
                otoparka.setSaat(rs.getInt("saat"));
                otoparka.setUcret(rs.getInt("ucret"));
                otoparka.setSube("Fatih");
                list.add(otoparka);
 
            }
 
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(conn!=null){ //Connection nesnesi belki yukarıda null kalmıştır.
                    conn.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmıştır.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
          try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT * FROM OTOPARKBEYLIKDUZU WHERE USERNAME='"+username+"'");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                
                Otopark otoparka = new Otopark();
                otoparka.setPlaka(rs.getString("plaka"));
                otoparka.setSaat(rs.getInt("saat"));
                otoparka.setUcret(rs.getInt("ucret"));
                otoparka.setSube("Beylikdüzü");
                list.add(otoparka);
 
            }
 
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(conn!=null){ //Connection nesnesi belki yukarıda null kalmıştır.
                    conn.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmıştır.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    //Datatable bir dizi veya listi alıp işleyebilir bizde bir liste göndereceğiz
        return list;
 
    }
    

    
}

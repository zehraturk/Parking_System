package otopark;
import java.io.Serializable;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;



@ManagedBean(name = "admin", eager = true)
@SessionScoped
public class Admin implements Serializable{
    private static final long serialVersionUID = 1L;
    private Connection conn;
 
    static final String DB_URL = "jdbc:derby://localhost:1527/otopark";
    private String kullanici_adi="admin";
    private String parola="APP";
    PreparedStatement ps=null;
    

    public List<Otopark> getOtoparkatasehir() {
         List<Otopark> list=new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT * FROM OTOPARKATASEHIR");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                
                Otopark otoparka = new Otopark();
                otoparka.setPlaka(rs.getString("plaka"));
                otoparka.setSaat(rs.getInt("saat"));
                otoparka.setUcret(rs.getInt("ucret"));
                
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
public void deleteActionatasehir(Otopark otopark) {
	    
	String plaka=otopark.plaka;
         try {
              
              try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }
              
              //STEP 3: Open a connection
              System.out.println("Connecting to a selected database...");
              Connection conn = null;
              try {
                  conn = DriverManager.getConnection(DB_URL,kullanici_adi, parola);
              } catch (SQLException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
              System.out.println("Connected database successfully...");
              
              //STEP 4: Execute a query
              System.out.println("deleting records into the table...");
              Statement stmt = conn.createStatement();
              
              String sql = "DELETE FROM OTOPARKATASEHIR WHERE PLAKA='"+plaka+"'";
              
              
              stmt.executeUpdate(sql);
              
              System.out.println("deleted records into the table...");
              
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "ekleme sikintisi");
          }
}
 public List<Otopark> getOtoparkfatih() {
         List<Otopark> list=new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT * FROM OTOPARKFATIH");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                
                Otopark otoparka = new Otopark();
                otoparka.setPlaka(rs.getString("plaka"));
                otoparka.setSaat(rs.getInt("saat"));
                otoparka.setUcret(rs.getInt("ucret"));
                
                list.add(otoparka);
 
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
public void deleteActionfatih(Otopark otopark) {
	    
	String plaka=otopark.plaka;
         try {
              
              try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }
              
              //STEP 3: Open a connection
              System.out.println("Connecting to a selected database...");
              Connection conn = null;
              try {
                  conn = DriverManager.getConnection(DB_URL,kullanici_adi, parola);
              } catch (SQLException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
              System.out.println("Connected database successfully...");
              
              //STEP 4: Execute a query
              System.out.println("deleting records into the table...");
              Statement stmt = conn.createStatement();
              
              String sql = "DELETE FROM OTOPARKFATIH WHERE PLAKA='"+plaka+"'";
              
              
              stmt.executeUpdate(sql);
              
              System.out.println("deleted records into the table...");
              
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "ekleme sikintisi");
          }
 
}
public List<Otopark> getOtoparkBeylikduzu() {
         List<Otopark> list=new ArrayList<>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn =DriverManager.getConnection(DB_URL,kullanici_adi,parola);
            ps=conn.prepareStatement("SELECT * FROM OTOPARKBEYLIKDUZU");
            ResultSet rs=ps.executeQuery();
            
            //Sonuçlar içerisinde dönerek verileri listeye ekliyoruz
            while (rs.next()) {
                
                Otopark otoparka = new Otopark();
                otoparka.setPlaka(rs.getString("plaka"));
                otoparka.setSaat(rs.getInt("saat"));
                otoparka.setUcret(rs.getInt("ucret"));
                
                list.add(otoparka);
 
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
public void deleteActionbeylikduzu(Otopark otopark) {
	    
	String plaka=otopark.plaka;
         try {
              
              try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }
              
              //STEP 3: Open a connection
              System.out.println("Connecting to a selected database...");
              Connection conn = null;
              try {
                  conn = DriverManager.getConnection(DB_URL,kullanici_adi, parola);
              } catch (SQLException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
              System.out.println("Connected database successfully...");
              
              //STEP 4: Execute a query
              System.out.println("deleting records into the table...");
              Statement stmt = conn.createStatement();
              
              String sql = "DELETE FROM OTOPARKBEYLIKDUZU WHERE PLAKA='"+plaka+"'";
              
              
              stmt.executeUpdate(sql);
              
              System.out.println("deleted records into the table...");
              
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "ekleme sikintisi");
          }
 
}
public String toplamarac()
{
      int aracsayisi=0; 
      try {
              
              try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }   
               System.out.println("Connect records into the table...");
              Connection conn = null;
              try {
                  conn = DriverManager.getConnection(DB_URL,kullanici_adi, parola);
              } catch (SQLException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }              
              //STEP 4: Execute a query
           //   Statement stmt = conn.createStatement();
             ps=conn.prepareStatement("SELECT * FROM OTOPARKBEYLIKDUZU LEFT JOIN USERS ON OTOPARKBEYLIKDUZU.PLAKA =USERS.PLAKA");
             
            ResultSet rs=ps.executeQuery();
              while (rs.next()) {
                  aracsayisi++;
              }
              
                ps=conn.prepareStatement("SELECT * FROM OTOPARKFATIH LEFT JOIN USERS ON OTOPARKFATIH.PLAKA =USERS.PLAKA");
             
            ResultSet rsr=ps.executeQuery();
              while (rsr.next()) {
                
                aracsayisi++;
              }
                ps=conn.prepareStatement("SELECT * FROM OTOPARKATASEHIR LEFT JOIN USERS ON OTOPARKATASEHIR.PLAKA =USERS.PLAKA");
             
            ResultSet rsT=ps.executeQuery();
              while (rsT.next()) {
                
                aracsayisi++;
              }
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "ekleme sikintisi");
          }
     return  "TOPLAM ARAÇ SAYISI: "+aracsayisi; 
}


}
package otopark;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nurpabuccu
 */
public class DBConnection {
    private Connection conn;
    String dburl="jdbc:derby://localhost:1527/otopark";
    String user="admin";
    String pass="APP";
    Scanner input=new Scanner(System.in);
    public Connection baglan(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //System.out.println("Bağlantı başarılı");
            conn=DriverManager.getConnection(dburl, user, pass);
        }
        catch(Exception e){
            System.out.println("Bağlantı sağlanamadı");
        }
        return conn;
    }
    
    public void uyeOl(String parola,String email) {
        if(conn==null){
            baglan();
        }
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into users values("+"'"+email+"','"+parola+"')");
        }catch(Exception e){e.printStackTrace();}
    }
    
    public boolean GirisKontrol(String email,String parola){
        if(conn==null){
            baglan();
        }
        try{
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select password from uyeler where username='"+email+"' and password='"+parola+"'");
            if(res.next() && parola.equals(res.getString(1))){
                System.out.println("Girişiniz yapıldı");
            return true;}
            else
                System.out.println("Yanlış şifre veya kullanıcı adı. Lütfen tekrar deneyiniz");            
        }catch(Exception e){
            e.printStackTrace();  
        }
        return false;
    }
}

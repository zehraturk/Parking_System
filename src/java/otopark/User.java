package otopark;

import Login.Login;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name ="User", eager=true)
@RequestScoped
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
    static final String DB_URL = "jdbc:derby://localhost:1527/otopark";
    private String kullanici_adi="admin";
    private String parola="APP";
    private String db_ismi="jdbc:derby://localhost:1527/otopark";
    private String host="localhost";
    private int port=1527;
    private Connection con=null;
    private Statement statement=null;
    private PreparedStatement ps = null;
    public static String username="";
    public static String plakaa="";

    public  String  first_name,last_name,user_name,password,phone_number,gender;
    String plaka,car_type,sube;
    boolean yikama;
    int saat,ucret,ucretyika=30;
    
     public int getUcretyika() {
        return ucretyika;
    }

    public void setUcretyika(int ucretyika) {
        this.ucretyika = ucretyika;
    }
    public boolean isYikama() {
        return yikama;
    }

    public void setYikama(boolean yikama) {
        this.yikama = yikama;
    }

    public String getSube() {
        return sube;
    }

    public void setSube(String sube) {
        this.sube = sube;
    }


    public String getGender() {
        return gender;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public int getUcret() {
        return ucret;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }
    
     public void calisanEkle()  {
        System.out.println("kullanıcı ekleniyor....");
        
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
                  conn = DriverManager.getConnection(DB_URL, kullanici_adi, parola);
              } catch (SQLException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
              System.out.println("Connected database successfully...");
              
              //STEP 4: Execute a query
              System.out.println("Inserting records into the table...");
              Statement stmt = conn.createStatement();
              
             String sql = "INSERT INTO REGISTER (FIRSTNAME, LASTNAME, USERNAME,PASSWORD,PLAKA,CARTYPE,PHONENUM) VALUES('"+getFirst_name()+"','"+getLast_name()+"','"+getUser_name()+"','"+getPassword()+"','"+getPlaka()+"','"+getCar_type()+"','"+getPhone_number()+"')";
              String sql2 = "INSERT INTO USERS (USERNAME,PASSWORD,PLAKA) VALUES('"+getUser_name()+"','"+getPassword()+"','"+getPlaka()+"')";
             stmt.executeUpdate(sql);
              stmt.executeUpdate(sql2);
              System.out.println(sql);
             
              
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "ekleme sikintisi");
          }

   }
  
public void rezervasyonYap(){
    
       try {
              
              try {
                  Class.forName("org.apache.derby.jdbc.ClientDriver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }
              
              //STEP 3: Open a connection
              System.out.println("Connecting to a selected database...");
              Connection conn = null;
              PreparedStatement preparedStatement=null;
              PreparedStatement preparedStatement1=null;
              PreparedStatement preparedStatement2=null;
              PreparedStatement preparedStatement3=null;
              PreparedStatement preparedStatement4=null;
              PreparedStatement preparedStatement5=null;
              try {
                  conn = DriverManager.getConnection(DB_URL, kullanici_adi  , parola);
              } catch (SQLException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
              System.out.println("Connected database successfully...");
              
              //STEP 4: Execute a query
              System.out.println("Inserting records into the table...");
              //Statement stmt = conn.createStatement();
              username=Login.user;
              preparedStatement=conn.prepareStatement("insert into RESERVATION (PLAKA,SUBE,SAAT,FIYAT)VALUES(?,?,?,?)");
              preparedStatement1=conn.prepareStatement("insert into YIKAMA (PLAKA,YIKAMA,FIYAT)VALUES(?,?,?)");
              preparedStatement2=conn.prepareStatement("insert into UCRETLER (PLAKA,SAAT,FIYAT)VALUES(?,?,?)");
              preparedStatement3=conn.prepareStatement("insert into OTOPARKBEYLIKDUZU (PLAKA,SAAT,UCRET,USERNAME)VALUES(?,?,?,?)");
              preparedStatement4=conn.prepareStatement("insert into OTOPARKATASEHIR (PLAKA,SAAT,UCRET,USERNAME)VALUES(?,?,?,?)");
              preparedStatement5=conn.prepareStatement("insert into OTOPARKFATIH (PLAKA,SAAT,UCRET,USERNAME)VALUES(?,?,?,?)");
              
              preparedStatement.setString(1,getPlaka());
              preparedStatement.setString(2,getSube());
              preparedStatement.setInt(3,getSaat());
              preparedStatement.setInt(4,getUcret());
              
              preparedStatement1.setString(1,getPlaka());
              preparedStatement1.setBoolean(2, isYikama());
              preparedStatement1.setInt(3,getUcretyika());
              
              preparedStatement2.setString(1,getPlaka());
              preparedStatement2.setInt(2, getSaat());
              preparedStatement2.setInt(3,toplamUcret());
              
              preparedStatement.executeUpdate();
              preparedStatement1.executeUpdate();
              preparedStatement2.executeUpdate();
              
              if(getSube().equals("OTOPARKBEYLIKDUZU")){
                  preparedStatement3.setString(1,getPlaka());
                  preparedStatement3.setInt(2,getSaat());
                  preparedStatement3.setInt(3,toplamUcret());
                  preparedStatement3.setString(4,username);
                  preparedStatement3.executeUpdate();
              }
              else if(getSube().equals("OTOPARKFATIH")){
                  preparedStatement5.setString(1,getPlaka());
                  preparedStatement5.setInt(2,getSaat());
                  preparedStatement5.setInt(3,toplamUcret());
                  preparedStatement5.setString(4,username);
                  preparedStatement5.executeUpdate();
              }
              else{
                  preparedStatement4.setString(1,getPlaka());
                  preparedStatement4.setInt(2,getSaat());
                  preparedStatement4.setInt(3,toplamUcret());
                  preparedStatement4.setString(4,username);
                  preparedStatement4.executeUpdate();
              }
             
              System.out.println("Inserted records into the table...");
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "ekleme sikintisi");
          }
    
       
      
  }
  public void rezervasyon2(){
          try {
              
              try {
                  Class.forName("org.apache.derby.jdbc.ClientDriver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }
              
              //STEP 3: Open a connection
              System.out.println("Connecting to a selected database...");
              Connection conn = null;
              PreparedStatement preparedStatement=null;
              PreparedStatement preparedStatement1=null;
              PreparedStatement preparedStatement2=null;
              PreparedStatement preparedStatement3=null;
              PreparedStatement preparedStatement4=null;
              PreparedStatement preparedStatement5=null;
              PreparedStatement preparedStatement6=null;
              try {
                  conn = DriverManager.getConnection(DB_URL, kullanici_adi, parola);
              } catch (SQLException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
              System.out.println("Connected database successfully...");
              
              //STEP 4: Execute a query
              System.out.println("Inserting records into the table...");
              Statement stmt = conn.createStatement();
              
              
                    username=Login.user;
                    System.out.println("**************"+username);
                    ps=conn.prepareStatement("SELECT * FROM REGISTER WHERE USERNAME='"+username+"'");
                    ResultSet rs=ps.executeQuery();
                    while (rs.next()) {
                         plakaa=rs.getString("PLAKA");
                    System.out.println("**************"+plaka);
 
                    }
                    
             
              preparedStatement=conn.prepareStatement("INSERT INTO RESERVATION (PLAKA,SUBE,SAAT,FIYAT) VALUES (?,?,?,?)");
              preparedStatement1=conn.prepareStatement("INSERT INTO YIKAMA (PLAKA,YIKAMA,FIYAT)VALUES(?,?,?)");
              preparedStatement2=conn.prepareStatement("INSERT INTO UCRETLER2(USERNAME,PLAKA,SAAT,FIYAT)VALUES(?,?,?,?)");
              preparedStatement3=conn.prepareStatement("INSERT INTO OTOPARKBEYLIKDUZU (PLAKA,SAAT,FIYAT)VALUES(?,?,?)");
              preparedStatement4=conn.prepareStatement("INSERT INTO OTOPARKATASEHIR (PLAKA,SAAT,FIYAT)VALUES(?,?,?)");
              preparedStatement5=conn.prepareStatement("INSERT INTO OTOPARKFATIH (PLAKA,SAAT,FIYAT)VALUES(?,?,?)");
              preparedStatement6=conn.prepareStatement("SELECT PLAKA FROM UCRETLER2 WHERE USERNAME='"+username+"'");
              
              ResultSet rs2=stmt.executeQuery("SELECT PLAKA FROM UCRETLER2 WHERE USERNAME='"+username+"'");
              String plakaaa=rs2.getString("PLAKA");
              boolean val=rs2.next();
              
              if(val==false){
              
              
              preparedStatement.setString(1,plakaa);
              preparedStatement.setString(2,getSube());
              preparedStatement.setInt(3,getSaat());
              preparedStatement.setInt(4,getUcret());
              
              preparedStatement1.setString(1,plakaa);
              preparedStatement1.setBoolean(2, isYikama());
              preparedStatement1.setInt(3,getUcret());
              
              preparedStatement2.setString(1,username);
              preparedStatement2.setString(2,plakaa);
              preparedStatement2.setInt(3, getSaat());
              preparedStatement2.setInt(4,toplamUcret());
              
              preparedStatement.executeUpdate();
              preparedStatement1.executeUpdate();
              preparedStatement2.executeUpdate();
              
              if(getSube().equals("OTOPARKBEYLIKDUZU")){
                  preparedStatement3.setString(1,plakaa);
                  preparedStatement3.setInt(2,getSaat());
                  preparedStatement3.setInt(3,toplamUcret());
                  preparedStatement3.executeUpdate();
              }
              else if(getSube().equals("OTOPARKFATIH")){
                  preparedStatement5.setString(1,plakaa);
                  preparedStatement5.setInt(2,getSaat());
                  preparedStatement5.setInt(3,toplamUcret());
                  preparedStatement5.executeUpdate();
              }
              else{
                  preparedStatement4.setString(1,plakaa);
                  preparedStatement4.setInt(2,getSaat());
                  preparedStatement4.setInt(3,toplamUcret());
                  preparedStatement4.executeUpdate();
              }
             
              }
              
            else
                  System.out.println("Bu plaka zaten rezervasyon yapmış durumda....");
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, "ekleme sikintisi");
          }
      
       
 }
  
        public int toplamUcret(){
            if(isYikama()==true){
                return getUcret()+getUcretyika();
            }
            else
                return getUcret();
        } 
        
        
}
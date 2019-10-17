/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDao {
  static final String DB_URL = "jdbc:derby://localhost:1527/otopark";
    private static String kullanici_adı="admin";
    private static  String parola="APP";
    public static boolean adminmi;
	public static boolean validate(String user, String password) {
		         
            try {         
		  try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, "baglantı sikintisi");
              }
              
    
              Connection conn = null;
              try {
                  conn = DriverManager.getConnection(DB_URL, kullanici_adı, parola);
              } catch (SQLException ex) {
                  Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, "baglanti sikintisi");
              }
                   
                     System.out.println("DB DB DB DB");
                  
                PreparedStatement  ps =conn.prepareStatement("SELECT USERNAME ,PASSWORD FROM USERS WHERE USERNAME ='"+user+"' and password='"+password+"'");
                    System.out.println("STATEMENT ALDIII");
                 
			ResultSet rs = ps.executeQuery();
                     System.out.println("ResulSet ALDIII");
                     System.out.println("ResulSet ALDIII");
                      System.out.println("ResulSet ALDIII");
			if (rs.next()) {
				//result found, means valid inputs
				adminmi=false;
                                return true;
			}
                 PreparedStatement  pss =conn.prepareStatement("SELECT USERNAME ,PASSWORD FROM YONETICI WHERE USERNAME ='"+user+"' and password='"+password+"'");
                    System.out.println("STATEMENT ALDIII");
                 
			ResultSet rrs = pss.executeQuery();
                     System.out.println("ResulSet ALDIII");
                     System.out.println("ResulSet ALDIII");
                      System.out.println("ResulSet ALDIII");
			if (rrs.next()) {
				//result found, means valid inputs
				adminmi=true;
                                return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			//DBConnection.close(con);
		}
		return false;
	}
      
}

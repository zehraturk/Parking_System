package Login;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
@ManagedBean(name ="login", eager=true)
@RequestScoped
public class Login implements Serializable {
     
	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg="";
	public static    String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDao.validate(user, pwd);
                boolean adminmii=LoginDao.adminmi;
		if (valid) {
		 if(adminmii==true)
                 {
                     HttpSession session = SessionUtils.getSession();
			session.setAttribute("USERNAME", user);
			return "admin";
                 }
                  HttpSession session = SessionUtils.getSession();
			session.setAttribute("USERNAME", user);
			return "userindex";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
                        msg="Hatalı giriş Linke tıklayıp kayda ulaşabilirsiniz";
			return "login";
		}
                
	}
 
	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}

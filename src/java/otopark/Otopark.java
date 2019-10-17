package otopark;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
@ManagedBean(name ="Otopark", eager=true)
@RequestScoped
public class Otopark {

    private int saat;
    private int ucret;
    String sube;

    public String getSube() {
        return sube;
    }

    public void setSube(String sube) {
        this.sube = sube;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }


    String plaka,car_type;

 
    public void setSaat(int saat) {
        this.saat = saat;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }

    public int getSaat() {
        return saat;
    }

    public int getUcret() {
        return ucret;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }


}
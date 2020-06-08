/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prikaz;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author gaga__m
 */
public class KorisnikPrikaz implements Serializable{
    private int idkorisnika;  
    private String jmbg;  
    private String imeprezime;  
    private Date datumrodj; 
    private String brpasosa;    
    private String brtelefona;
    private String adresa;

    public KorisnikPrikaz() {
    }

    public int getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(int idkorisnika) {
        this.idkorisnika = idkorisnika;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImeprezime() {
        return imeprezime;
    }

    public void setImeprezime(String imeprezime) {
        this.imeprezime = imeprezime;
    }

    public Date getDatumrodj() {
        return datumrodj;
    }

    public void setDatumrodj(Date datumrodj) {
        this.datumrodj = datumrodj;
    }

    public String getBrpasosa() {
        return brpasosa;
    }

    public void setBrpasosa(String brpasosa) {
        this.brpasosa = brpasosa;
    }

    public String getBrtelefona() {
        return brtelefona;
    }

    public void setBrtelefona(String brtelefona) {
        this.brtelefona = brtelefona;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    
}

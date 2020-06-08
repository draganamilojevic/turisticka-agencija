/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prikaz;

import java.io.Serializable;

/**
 *
 * @author gaga__m
 */
public class PotvrdaRezervacijePrikaz implements Serializable{
    private int idpotvrde;
    private String opis;
    private String imeRadnika;

    public PotvrdaRezervacijePrikaz() {
    }
    
    public int getIdpotvrde() {
        return idpotvrde;
    }

    public void setIdpotvrde(int idpotvrde) {
        this.idpotvrde = idpotvrde;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getImeRadnika() {
        return imeRadnika;
    }

    public void setImeRadnika(String imeRadnika) {
        this.imeRadnika = imeRadnika;
    }
    
    
}

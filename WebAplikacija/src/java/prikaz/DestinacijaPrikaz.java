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
public class DestinacijaPrikaz implements Serializable{
    private int iddestinacije;
    private String nazivdestinacije;

    public int getIddestinacije() {
        return iddestinacije;
    }

    public void setIddestinacije(int iddestinacije) {
        this.iddestinacije = iddestinacije;
    }

    public String getNazivdestinacije() {
        return nazivdestinacije;
    }

    public void setNazivdestinacije(String nazivdestinacije) {
        this.nazivdestinacije = nazivdestinacije;
    }
    
    
}

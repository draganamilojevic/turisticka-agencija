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
public class TipSmestajaPrikaz implements Serializable{
    private int idtipasmestaja;
    private String nazivtipasmestaja;

    public int getIdtipasmestaja() {
        return idtipasmestaja;
    }

    public void setIdtipasmestaja(int idtipasmestaja) {
        this.idtipasmestaja = idtipasmestaja;
    }

    public String getNazivtipasmestaja() {
        return nazivtipasmestaja;
    }

    public void setNazivtipasmestaja(String nazivtipasmestaja) {
        this.nazivtipasmestaja = nazivtipasmestaja;
    }
    
    
}

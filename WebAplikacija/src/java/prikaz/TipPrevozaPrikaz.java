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
public class TipPrevozaPrikaz implements Serializable{
    private int idtipaprevoza;
    private String nazivtipaprevoza;

    public int getIdtipaprevoza() {
        return idtipaprevoza;
    }

    public void setIdtipaprevoza(int idtipaprevoza) {
        this.idtipaprevoza = idtipaprevoza;
    }

    public String getNazivtipaprevoza() {
        return nazivtipaprevoza;
    }

    public void setNazivtipaprevoza(String nazivtipaprevoza) {
        this.nazivtipaprevoza = nazivtipaprevoza;
    }
    
    
}

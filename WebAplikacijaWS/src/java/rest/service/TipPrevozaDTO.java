/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigDecimal;
import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import model.Zahtevkorisnika;

/**
 *
 * @author gaga__m
 */
public class TipPrevozaDTO {
    @XmlElement
    private BigDecimal idtipaprevoza;
    @XmlElement
    private String nazivtipaprevoza;

    public BigDecimal getIdtipaprevoza() {
        return idtipaprevoza;
    }

    public void setIdtipaprevoza(BigDecimal idtipaprevoza) {
        this.idtipaprevoza = idtipaprevoza;
    }

    public String getNazivtipaprevoza() {
        return nazivtipaprevoza;
    }

    public void setNazivtipaprevoza(String nazivtipaprevoza) {
        this.nazivtipaprevoza = nazivtipaprevoza;
    }
    
    
}

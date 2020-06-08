/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author gaga__m
 */
public class DestinacijaDTO {
    @XmlElement
    private BigDecimal iddestinacije;
    @XmlElement
    private String nazivdestinacije;

    public BigDecimal getIddestinacije() {
        return iddestinacije;
    }

    public void setIddestinacije(BigDecimal iddestinacije) {
        this.iddestinacije = iddestinacije;
    }

    public String getNazivdestinacije() {
        return nazivdestinacije;
    }

    public void setNazivdestinacije(String nazivdestinacije) {
        this.nazivdestinacije = nazivdestinacije;
    }
    
    
}

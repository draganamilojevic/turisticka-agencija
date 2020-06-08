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
public class TipSmestajaDTO {
    @XmlElement
    private BigDecimal idtipasmestaja;
    @XmlElement
    private String nazivtipasmestaja;

    public BigDecimal getIdtipasmestaja() {
        return idtipasmestaja;
    }

    public void setIdtipasmestaja(BigDecimal idtipasmestaja) {
        this.idtipasmestaja = idtipasmestaja;
    }

    public String getNazivtipasmestaja() {
        return nazivtipasmestaja;
    }

    public void setNazivtipasmestaja(String nazivtipasmestaja) {
        this.nazivtipasmestaja = nazivtipasmestaja;
    }

    
    
}

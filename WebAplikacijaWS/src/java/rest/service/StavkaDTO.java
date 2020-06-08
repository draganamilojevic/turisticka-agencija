/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigInteger;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import model.Mestoobilaska;
import model.Programputovanja;

/**
 *
 * @author gaga__m
 */
public class StavkaDTO {
    @XmlElement
    private BigInteger iddana;
    @XmlElement
    private BigInteger sifraprograma;
    @XmlElement
    private String opisdana;
    @XmlElement
    private Date datum;
    @XmlElement
    private Mestoobilaska idmesta;
    @XmlElement
    private Programputovanja programputovanja;
    @XmlElement
    private String status;

    public BigInteger getIddana() {
        return iddana;
    }

    public void setIddana(BigInteger iddana) {
        this.iddana = iddana;
    }

    public BigInteger getSifraprograma() {
        return sifraprograma;
    }

    public void setSifraprograma(BigInteger sifraprograma) {
        this.sifraprograma = sifraprograma;
    }

    public String getOpisdana() {
        return opisdana;
    }

    public void setOpisdana(String opisdana) {
        this.opisdana = opisdana;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Mestoobilaska getIdmesta() {
        return idmesta;
    }

    public void setIdmesta(Mestoobilaska idmesta) {
        this.idmesta = idmesta;
    }

    public Programputovanja getProgramputovanja() {
        return programputovanja;
    }

    public void setProgramputovanja(Programputovanja programputovanja) {
        this.programputovanja = programputovanja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

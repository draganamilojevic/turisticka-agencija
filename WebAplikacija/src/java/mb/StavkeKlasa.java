/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author gaga__m
 */
@ManagedBean
@RequestScoped
public class StavkeKlasa implements Serializable{

    private BigInteger iddana;
    private BigInteger sifraprograma;
    private String status;
    private String opisdana;
    private Date datum;
    private BigInteger idmesta;
    private BigInteger programputovanja;
    
    
    public StavkeKlasa() {
    }

    public StavkeKlasa(BigInteger iddana, BigInteger sifraprograma, String status, String opisdana, Date datum, BigInteger idmesta, BigInteger programputovanja) {
        this.iddana = iddana;
        this.sifraprograma = sifraprograma;
        this.status = status;
        this.opisdana = opisdana;
        this.datum = datum;
        this.idmesta = idmesta;
        this.programputovanja = programputovanja;
    }
    
    

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public BigInteger getIdmesta() {
        return idmesta;
    }

    public void setIdmesta(BigInteger idmesta) {
        this.idmesta = idmesta;
    }

    public BigInteger getProgramputovanja() {
        return programputovanja;
    }

    public void setProgramputovanja(BigInteger programputovanja) {
        this.programputovanja = programputovanja;
    }
    
    
    
}

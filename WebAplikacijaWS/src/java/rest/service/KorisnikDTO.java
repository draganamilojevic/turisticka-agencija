/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author gaga__m
 */
public class KorisnikDTO {
    @XmlElement
    private BigDecimal idkorisnika;
    @XmlElement
    private String jmbg;
    @XmlElement
    private String imeprezime;
    @XmlElement
    private Date datumrodj;
    @XmlElement
    private String brpasosa;
    @XmlElement
    private String brtelefona;
    @XmlElement
    private String adresa;

    public BigDecimal getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(BigDecimal idkorisnika) {
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

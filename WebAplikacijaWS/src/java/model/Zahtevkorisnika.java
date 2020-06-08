/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "ZAHTEVKORISNIKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zahtevkorisnika.findAll", query = "SELECT z FROM Zahtevkorisnika z"),
    @NamedQuery(name = "Zahtevkorisnika.findBySifrazahteva", query = "SELECT z FROM Zahtevkorisnika z WHERE z.sifrazahteva = :sifrazahteva"),
    @NamedQuery(name = "Zahtevkorisnika.findByVremeboravka", query = "SELECT z FROM Zahtevkorisnika z WHERE z.vremeboravka = :vremeboravka")})
public class Zahtevkorisnika implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIFRAZAHTEVA")
    private BigDecimal sifrazahteva;
    @Column(name = "VREMEBORAVKA")
    private BigInteger vremeboravka;
    @JoinColumn(name = "IDDESTINACIJE", referencedColumnName = "IDDESTINACIJE")
    @ManyToOne
    private Destinacija iddestinacije;
    @JoinColumn(name = "IDKORISNIKA", referencedColumnName = "IDKORISNIKA")
    @ManyToOne
    private Korisnik idkorisnika;
    @JoinColumn(name = "IDTIPAPREVOZA", referencedColumnName = "IDTIPAPREVOZA")
    @ManyToOne
    private Tipprevoza idtipaprevoza;
    @JoinColumn(name = "IDTIPASMESTAJA", referencedColumnName = "IDTIPASMESTAJA")
    @ManyToOne
    private Tipsmestaja idtipasmestaja;
    
    
    public Zahtevkorisnika() {
    }

    public Zahtevkorisnika(BigDecimal sifrazahteva) {
        this.sifrazahteva = sifrazahteva;
    }

    public BigDecimal getSifrazahteva() {
        return sifrazahteva;
    }

    public void setSifrazahteva(BigDecimal sifrazahteva) {
        this.sifrazahteva = sifrazahteva;
    }

    public BigInteger getVremeboravka() {
        return vremeboravka;
    }

    public void setVremeboravka(BigInteger vremeboravka) {
        this.vremeboravka = vremeboravka;
    }

    public Destinacija getIddestinacije() {
        return iddestinacije;
    }

    public void setIddestinacije(Destinacija iddestinacije) {
        this.iddestinacije = iddestinacije;
    }

    public Korisnik getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(Korisnik idkorisnika) {
        this.idkorisnika = idkorisnika;
    }

    public Tipprevoza getIdtipaprevoza() {
        return idtipaprevoza;
    }

    public void setIdtipaprevoza(Tipprevoza idtipaprevoza) {
        this.idtipaprevoza = idtipaprevoza;
    }

    public Tipsmestaja getIdtipasmestaja() {
        return idtipasmestaja;
    }

    public void setIdtipasmestaja(Tipsmestaja idtipasmestaja) {
        this.idtipasmestaja = idtipasmestaja;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifrazahteva != null ? sifrazahteva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zahtevkorisnika)) {
            return false;
        }
        Zahtevkorisnika other = (Zahtevkorisnika) object;
        if ((this.sifrazahteva == null && other.sifrazahteva != null) || (this.sifrazahteva != null && !this.sifrazahteva.equals(other.sifrazahteva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Zahtevkorisnika[ sifrazahteva=" + sifrazahteva + " ]";
    }
    
}

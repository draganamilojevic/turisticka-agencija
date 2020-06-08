/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "ADRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a"),
    @NamedQuery(name = "Adresa.findByIddrzave", query = "SELECT a FROM Adresa a WHERE a.adresaPK.iddrzave = :iddrzave"),
    @NamedQuery(name = "Adresa.findByIdgrada", query = "SELECT a FROM Adresa a WHERE a.adresaPK.idgrada = :idgrada"),
    @NamedQuery(name = "Adresa.findByIdadrese", query = "SELECT a FROM Adresa a WHERE a.adresaPK.idadrese = :idadrese"),
    @NamedQuery(name = "Adresa.findByUlica", query = "SELECT a FROM Adresa a WHERE a.ulica = :ulica"),
    @NamedQuery(name = "Adresa.findByBroj", query = "SELECT a FROM Adresa a WHERE a.broj = :broj")})
public class Adresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdresaPK adresaPK;
    @Size(max = 20)
    @Column(name = "ULICA")
    private String ulica;
    @Column(name = "BROJ")
    private BigInteger broj;
    @OneToMany(mappedBy = "adresa")
    private Collection<Korisnik> korisnikCollection;
    @JoinColumns({
        @JoinColumn(name = "IDDRZAVE", referencedColumnName = "IDDRZAVE", insertable = false, updatable = false),
        @JoinColumn(name = "IDGRADA", referencedColumnName = "IDGRADA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Grad grad;

    public Adresa() {
    }

    public Adresa(AdresaPK adresaPK) {
        this.adresaPK = adresaPK;
    }

    public Adresa(BigInteger iddrzave, BigInteger idgrada, BigInteger idadrese) {
        this.adresaPK = new AdresaPK(iddrzave, idgrada, idadrese);
    }

    public AdresaPK getAdresaPK() {
        return adresaPK;
    }

    public void setAdresaPK(AdresaPK adresaPK) {
        this.adresaPK = adresaPK;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public BigInteger getBroj() {
        return broj;
    }

    public void setBroj(BigInteger broj) {
        this.broj = broj;
    }

    @XmlTransient
    public Collection<Korisnik> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(Collection<Korisnik> korisnikCollection) {
        this.korisnikCollection = korisnikCollection;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adresaPK != null ? adresaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.adresaPK == null && other.adresaPK != null) || (this.adresaPK != null && !this.adresaPK.equals(other.adresaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Adresa[ adresaPK=" + adresaPK + " ]";
    }
    
}

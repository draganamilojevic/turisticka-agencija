/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "KORISNIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k"),
    @NamedQuery(name = "Korisnik.findByIdkorisnika", query = "SELECT k FROM Korisnik k WHERE k.idkorisnika = :idkorisnika"),
    @NamedQuery(name = "Korisnik.findByJmbg", query = "SELECT k FROM Korisnik k WHERE k.jmbg = :jmbg"),
    @NamedQuery(name = "Korisnik.findByImeprezime", query = "SELECT k FROM Korisnik k WHERE k.imeprezime = :imeprezime"),
    @NamedQuery(name = "Korisnik.findByDatumrodj", query = "SELECT k FROM Korisnik k WHERE k.datumrodj = :datumrodj"),
    @NamedQuery(name = "Korisnik.findByBrpasosa", query = "SELECT k FROM Korisnik k WHERE k.brpasosa = :brpasosa"),
    @NamedQuery(name = "Korisnik.findByBrtelefona", query = "SELECT k FROM Korisnik k WHERE k.brtelefona = :brtelefona")})
public class Korisnik implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKORISNIKA")
    private BigDecimal idkorisnika;
    @Size(max = 20)
    @Column(name = "JMBG")
    private String jmbg;
    @Size(max = 40)
    @Column(name = "IMEPREZIME")
    private String imeprezime;
    @Column(name = "DATUMRODJ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumrodj;
    @Size(max = 20)
    @Column(name = "BRPASOSA")
    private String brpasosa;
    @Size(max = 20)
    @Column(name = "BRTELEFONA")
    private String brtelefona;
    @JoinColumns({
        @JoinColumn(name = "IDDRZAVE", referencedColumnName = "IDDRZAVE"),
        @JoinColumn(name = "IDGRADA", referencedColumnName = "IDGRADA"),
        @JoinColumn(name = "IDADRESE", referencedColumnName = "IDADRESE")})
    @ManyToOne
    private Adresa adresa;
    @OneToMany(mappedBy = "idkorisnika")
    private Collection<Potvrdarezervacije> potvrdarezervacijeCollection;
    @OneToMany(mappedBy = "idkorisnika")
    private Collection<Zahtevkorisnika> zahtevkorisnikaCollection;

    public Korisnik() {
    }

    public Korisnik(BigDecimal idkorisnika) {
        this.idkorisnika = idkorisnika;
    }

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

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @XmlTransient
    public Collection<Potvrdarezervacije> getPotvrdarezervacijeCollection() {
        return potvrdarezervacijeCollection;
    }

    public void setPotvrdarezervacijeCollection(Collection<Potvrdarezervacije> potvrdarezervacijeCollection) {
        this.potvrdarezervacijeCollection = potvrdarezervacijeCollection;
    }

    @XmlTransient
    public Collection<Zahtevkorisnika> getZahtevkorisnikaCollection() {
        return zahtevkorisnikaCollection;
    }

    public void setZahtevkorisnikaCollection(Collection<Zahtevkorisnika> zahtevkorisnikaCollection) {
        this.zahtevkorisnikaCollection = zahtevkorisnikaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkorisnika != null ? idkorisnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.idkorisnika == null && other.idkorisnika != null) || (this.idkorisnika != null && !this.idkorisnika.equals(other.idkorisnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Korisnik[ idkorisnika=" + idkorisnika + " ]";
    }
    
}

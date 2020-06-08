/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "RADNIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radnik.findAll", query = "SELECT r FROM Radnik r"),
    @NamedQuery(name = "Radnik.findBySifraradnika", query = "SELECT r FROM Radnik r WHERE r.sifraradnika = :sifraradnika"),
    @NamedQuery(name = "Radnik.findByImeprezime", query = "SELECT r FROM Radnik r WHERE r.imeprezime = :imeprezime")})
public class Radnik implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIFRARADNIKA")
    private BigDecimal sifraradnika;
    @Size(max = 30)
    @Column(name = "IMEPREZIME")
    private String imeprezime;
    @OneToMany(mappedBy = "sifraradnika")
    private Collection<Potvrdarezervacije> potvrdarezervacijeCollection;

    public Radnik() {
    }

    public Radnik(BigDecimal sifraradnika) {
        this.sifraradnika = sifraradnika;
    }

    public BigDecimal getSifraradnika() {
        return sifraradnika;
    }

    public void setSifraradnika(BigDecimal sifraradnika) {
        this.sifraradnika = sifraradnika;
    }

    public String getImeprezime() {
        return imeprezime;
    }

    public void setImeprezime(String imeprezime) {
        this.imeprezime = imeprezime;
    }

    @XmlTransient
    public Collection<Potvrdarezervacije> getPotvrdarezervacijeCollection() {
        return potvrdarezervacijeCollection;
    }

    public void setPotvrdarezervacijeCollection(Collection<Potvrdarezervacije> potvrdarezervacijeCollection) {
        this.potvrdarezervacijeCollection = potvrdarezervacijeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraradnika != null ? sifraradnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radnik)) {
            return false;
        }
        Radnik other = (Radnik) object;
        if ((this.sifraradnika == null && other.sifraradnika != null) || (this.sifraradnika != null && !this.sifraradnika.equals(other.sifraradnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Radnik[ sifraradnika=" + sifraradnika + " ]";
    }
    
}

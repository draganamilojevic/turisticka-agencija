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
@Table(name = "DESTINACIJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinacija_1.findAll", query = "SELECT d FROM Destinacija_1 d"),
    @NamedQuery(name = "Destinacija_1.findByIddestinacije", query = "SELECT d FROM Destinacija_1 d WHERE d.iddestinacije = :iddestinacije"),
    @NamedQuery(name = "Destinacija_1.findByNazivdestinacije", query = "SELECT d FROM Destinacija_1 d WHERE d.nazivdestinacije = :nazivdestinacije")})
public class Destinacija_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDESTINACIJE")
    private BigDecimal iddestinacije;
    @Size(max = 20)
    @Column(name = "NAZIVDESTINACIJE")
    private String nazivdestinacije;
    @OneToMany(mappedBy = "iddestinacije")
    private Collection<Zahtevkorisnika> zahtevkorisnikaCollection;

    public Destinacija_1() {
    }

    public Destinacija_1(BigDecimal iddestinacije) {
        this.iddestinacije = iddestinacije;
    }

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
        hash += (iddestinacije != null ? iddestinacije.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinacija_1)) {
            return false;
        }
        Destinacija_1 other = (Destinacija_1) object;
        if ((this.iddestinacije == null && other.iddestinacije != null) || (this.iddestinacije != null && !this.iddestinacije.equals(other.iddestinacije))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Destinacija_1[ iddestinacije=" + iddestinacije + " ]";
    }
    
}

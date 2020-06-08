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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "TIPSMESTAJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipsmestaja.findAll", query = "SELECT t FROM Tipsmestaja t"),
    @NamedQuery(name = "Tipsmestaja.findByIdtipasmestaja", query = "SELECT t FROM Tipsmestaja t WHERE t.idtipasmestaja = :idtipasmestaja"),
    @NamedQuery(name = "Tipsmestaja.findByNazivtipasmestaja", query = "SELECT t FROM Tipsmestaja t WHERE t.nazivtipasmestaja = :nazivtipasmestaja")})
public class Tipsmestaja implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPASMESTAJA")
    private BigDecimal idtipasmestaja;
    @Column(name = "NAZIVTIPASMESTAJA")
    private String nazivtipasmestaja;
    @OneToMany(mappedBy = "idtipasmestaja")
    private Collection<Zahtevkorisnika> zahtevkorisnikaCollection;

    public Tipsmestaja() {
    }

    public Tipsmestaja(BigDecimal idtipasmestaja) {
        this.idtipasmestaja = idtipasmestaja;
    }

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
        hash += (idtipasmestaja != null ? idtipasmestaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipsmestaja)) {
            return false;
        }
        Tipsmestaja other = (Tipsmestaja) object;
        if ((this.idtipasmestaja == null && other.idtipasmestaja != null) || (this.idtipasmestaja != null && !this.idtipasmestaja.equals(other.idtipasmestaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipsmestaja[ idtipasmestaja=" + idtipasmestaja + " ]";
    }
    
}

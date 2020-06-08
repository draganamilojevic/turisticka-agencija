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
@Table(name = "TIPPREVOZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipprevoza.findAll", query = "SELECT t FROM Tipprevoza t"),
    @NamedQuery(name = "Tipprevoza.findByIdtipaprevoza", query = "SELECT t FROM Tipprevoza t WHERE t.idtipaprevoza = :idtipaprevoza"),
    @NamedQuery(name = "Tipprevoza.findByNazivtipaprevoza", query = "SELECT t FROM Tipprevoza t WHERE t.nazivtipaprevoza = :nazivtipaprevoza")})
public class Tipprevoza implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPAPREVOZA")
    private BigDecimal idtipaprevoza;
    @Column(name = "NAZIVTIPAPREVOZA")
    private String nazivtipaprevoza;
    @OneToMany(mappedBy = "idtipaprevoza")
    private Collection<Zahtevkorisnika> zahtevkorisnikaCollection;

    public Tipprevoza() {
    }

    public Tipprevoza(BigDecimal idtipaprevoza) {
        this.idtipaprevoza = idtipaprevoza;
    }

    public BigDecimal getIdtipaprevoza() {
        return idtipaprevoza;
    }

    public void setIdtipaprevoza(BigDecimal idtipaprevoza) {
        this.idtipaprevoza = idtipaprevoza;
    }

    public String getNazivtipaprevoza() {
        return nazivtipaprevoza;
    }

    public void setNazivtipaprevoza(String nazivtipaprevoza) {
        this.nazivtipaprevoza = nazivtipaprevoza;
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
        hash += (idtipaprevoza != null ? idtipaprevoza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipprevoza)) {
            return false;
        }
        Tipprevoza other = (Tipprevoza) object;
        if ((this.idtipaprevoza == null && other.idtipaprevoza != null) || (this.idtipaprevoza != null && !this.idtipaprevoza.equals(other.idtipaprevoza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipprevoza[ idtipaprevoza=" + idtipaprevoza + " ]";
    }
    
}

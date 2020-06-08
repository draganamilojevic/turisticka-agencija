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
import javax.persistence.CascadeType;
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
@Table(name = "DRZAVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d"),
    @NamedQuery(name = "Drzava.findByIddrzave", query = "SELECT d FROM Drzava d WHERE d.iddrzave = :iddrzave"),
    @NamedQuery(name = "Drzava.findByNazivdrzave", query = "SELECT d FROM Drzava d WHERE d.nazivdrzave = :nazivdrzave")})
public class Drzava implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDDRZAVE")
    private BigDecimal iddrzave;
    @Column(name = "NAZIVDRZAVE")
    private String nazivdrzave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drzava")
    private Collection<Grad> gradCollection;

    public Drzava() {
    }

    public Drzava(BigDecimal iddrzave) {
        this.iddrzave = iddrzave;
    }

    public BigDecimal getIddrzave() {
        return iddrzave;
    }

    public void setIddrzave(BigDecimal iddrzave) {
        this.iddrzave = iddrzave;
    }

    public String getNazivdrzave() {
        return nazivdrzave;
    }

    public void setNazivdrzave(String nazivdrzave) {
        this.nazivdrzave = nazivdrzave;
    }

    @XmlTransient
    public Collection<Grad> getGradCollection() {
        return gradCollection;
    }

    public void setGradCollection(Collection<Grad> gradCollection) {
        this.gradCollection = gradCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddrzave != null ? iddrzave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.iddrzave == null && other.iddrzave != null) || (this.iddrzave != null && !this.iddrzave.equals(other.iddrzave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Drzava[ iddrzave=" + iddrzave + " ]";
    }
    
}

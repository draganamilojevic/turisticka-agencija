/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GRAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g"),
    @NamedQuery(name = "Grad.findByIddrzave", query = "SELECT g FROM Grad g WHERE g.gradPK.iddrzave = :iddrzave"),
    @NamedQuery(name = "Grad.findByIdgrada", query = "SELECT g FROM Grad g WHERE g.gradPK.idgrada = :idgrada"),
    @NamedQuery(name = "Grad.findByNazivgrada", query = "SELECT g FROM Grad g WHERE g.nazivgrada = :nazivgrada")})
public class Grad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GradPK gradPK;
    @Column(name = "NAZIVGRADA")
    private String nazivgrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grad")
    private Collection<Adresa> adresaCollection;
    @JoinColumn(name = "IDDRZAVE", referencedColumnName = "IDDRZAVE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Drzava drzava;

    public Grad() {
    }

    public Grad(GradPK gradPK) {
        this.gradPK = gradPK;
    }

    public Grad(BigInteger iddrzave, BigInteger idgrada) {
        this.gradPK = new GradPK(iddrzave, idgrada);
    }

    public GradPK getGradPK() {
        return gradPK;
    }

    public void setGradPK(GradPK gradPK) {
        this.gradPK = gradPK;
    }

    public String getNazivgrada() {
        return nazivgrada;
    }

    public void setNazivgrada(String nazivgrada) {
        this.nazivgrada = nazivgrada;
    }

    @XmlTransient
    public Collection<Adresa> getAdresaCollection() {
        return adresaCollection;
    }

    public void setAdresaCollection(Collection<Adresa> adresaCollection) {
        this.adresaCollection = adresaCollection;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gradPK != null ? gradPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grad)) {
            return false;
        }
        Grad other = (Grad) object;
        if ((this.gradPK == null && other.gradPK != null) || (this.gradPK != null && !this.gradPK.equals(other.gradPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Grad[ gradPK=" + gradPK + " ]";
    }
    
}

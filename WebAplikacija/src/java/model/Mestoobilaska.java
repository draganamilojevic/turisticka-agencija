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
@Table(name = "MESTOOBILASKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mestoobilaska.findAll", query = "SELECT m FROM Mestoobilaska m"),
    @NamedQuery(name = "Mestoobilaska.findByIdmesta", query = "SELECT m FROM Mestoobilaska m WHERE m.idmesta = :idmesta"),
    @NamedQuery(name = "Mestoobilaska.findByNazivmesta", query = "SELECT m FROM Mestoobilaska m WHERE m.nazivmesta = :nazivmesta")})
public class Mestoobilaska implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDMESTA")
    private BigDecimal idmesta;
    @Column(name = "NAZIVMESTA")
    private String nazivmesta;
    @OneToMany(mappedBy = "idmesta")
    private Collection<Stavkaprograma> stavkaprogramaCollection;

    public Mestoobilaska() {
    }

    public Mestoobilaska(BigDecimal idmesta) {
        this.idmesta = idmesta;
    }

    public BigDecimal getIdmesta() {
        return idmesta;
    }

    public void setIdmesta(BigDecimal idmesta) {
        this.idmesta = idmesta;
    }

    public String getNazivmesta() {
        return nazivmesta;
    }

    public void setNazivmesta(String nazivmesta) {
        this.nazivmesta = nazivmesta;
    }

    @XmlTransient
    public Collection<Stavkaprograma> getStavkaprogramaCollection() {
        return stavkaprogramaCollection;
    }

    public void setStavkaprogramaCollection(Collection<Stavkaprograma> stavkaprogramaCollection) {
        this.stavkaprogramaCollection = stavkaprogramaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmesta != null ? idmesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mestoobilaska)) {
            return false;
        }
        Mestoobilaska other = (Mestoobilaska) object;
        if ((this.idmesta == null && other.idmesta != null) || (this.idmesta != null && !this.idmesta.equals(other.idmesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mestoobilaska[ idmesta=" + idmesta + " ]";
    }
    
}

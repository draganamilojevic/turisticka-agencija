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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "PROGRAMIPUTOVANJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programiputovanja.findAll", query = "SELECT p FROM Programiputovanja p"),
    @NamedQuery(name = "Programiputovanja.findByRednibrojprograma", query = "SELECT p FROM Programiputovanja p WHERE p.rednibrojprograma = :rednibrojprograma"),
    @NamedQuery(name = "Programiputovanja.findByDatumkreiranja", query = "SELECT p FROM Programiputovanja p WHERE p.datumkreiranja = :datumkreiranja"),
    @NamedQuery(name = "Programiputovanja.findBySablonprograma", query = "SELECT p FROM Programiputovanja p WHERE p.sablonprograma = :sablonprograma")})
public class Programiputovanja implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "REDNIBROJPROGRAMA")
    private BigDecimal rednibrojprograma;
    @Column(name = "DATUMKREIRANJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumkreiranja;
    @Column(name = "SABLONPROGRAMA")
    private String sablonprograma;
    @OneToMany(mappedBy = "rednibrojprograma")
    private Collection<Programputovanja> programputovanjaCollection;

    public Programiputovanja() {
    }

    public Programiputovanja(BigDecimal rednibrojprograma) {
        this.rednibrojprograma = rednibrojprograma;
    }

    public BigDecimal getRednibrojprograma() {
        return rednibrojprograma;
    }

    public void setRednibrojprograma(BigDecimal rednibrojprograma) {
        this.rednibrojprograma = rednibrojprograma;
    }

    public Date getDatumkreiranja() {
        return datumkreiranja;
    }

    public void setDatumkreiranja(Date datumkreiranja) {
        this.datumkreiranja = datumkreiranja;
    }

    public String getSablonprograma() {
        return sablonprograma;
    }

    public void setSablonprograma(String sablonprograma) {
        this.sablonprograma = sablonprograma;
    }

    @XmlTransient
    public Collection<Programputovanja> getProgramputovanjaCollection() {
        return programputovanjaCollection;
    }

    public void setProgramputovanjaCollection(Collection<Programputovanja> programputovanjaCollection) {
        this.programputovanjaCollection = programputovanjaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rednibrojprograma != null ? rednibrojprograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programiputovanja)) {
            return false;
        }
        Programiputovanja other = (Programiputovanja) object;
        if ((this.rednibrojprograma == null && other.rednibrojprograma != null) || (this.rednibrojprograma != null && !this.rednibrojprograma.equals(other.rednibrojprograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Programiputovanja[ rednibrojprograma=" + rednibrojprograma + " ]";
    }
    
}

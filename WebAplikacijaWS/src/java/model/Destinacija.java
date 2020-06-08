/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "DESTINACIJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinacija.findAll", query = "SELECT d FROM Destinacija d"),
    @NamedQuery(name = "Destinacija.findByIddestinacije", query = "SELECT d FROM Destinacija d WHERE d.iddestinacije = :iddestinacije"),
    @NamedQuery(name = "Destinacija.findByNazivdestinacije", query = "SELECT d FROM Destinacija d WHERE d.nazivdestinacije = :nazivdestinacije")})
public class Destinacija implements Serializable {
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

    public Destinacija() {
    }

    public Destinacija(BigDecimal iddestinacije) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddestinacije != null ? iddestinacije.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinacija)) {
            return false;
        }
        Destinacija other = (Destinacija) object;
        if ((this.iddestinacije == null && other.iddestinacije != null) || (this.iddestinacije != null && !this.iddestinacije.equals(other.iddestinacije))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Destinacija[ iddestinacije=" + iddestinacije + " ]";
    }
    
}

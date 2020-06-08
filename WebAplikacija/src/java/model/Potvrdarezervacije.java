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
@Table(name = "POTVRDAREZERVACIJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Potvrdarezervacije.findAll", query = "SELECT p FROM Potvrdarezervacije p"),
    @NamedQuery(name = "Potvrdarezervacije.findByIdpotvrde", query = "SELECT p FROM Potvrdarezervacije p WHERE p.idpotvrde = :idpotvrde"),
    @NamedQuery(name = "Potvrdarezervacije.findByOpis", query = "SELECT p FROM Potvrdarezervacije p WHERE p.opis = :opis")})
public class Potvrdarezervacije implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPOTVRDE")
    private BigDecimal idpotvrde;
    @Column(name = "OPIS")
    private String opis;
    @OneToMany(mappedBy = "idpotvrde")
    private Collection<Programputovanja> programputovanjaCollection;
    @JoinColumn(name = "SIFRARADNIKA", referencedColumnName = "SIFRARADNIKA")
    @ManyToOne
    private Radnik sifraradnika;

    public Potvrdarezervacije() {
    }

    public Potvrdarezervacije(BigDecimal idpotvrde) {
        this.idpotvrde = idpotvrde;
    }

    public BigDecimal getIdpotvrde() {
        return idpotvrde;
    }

    public void setIdpotvrde(BigDecimal idpotvrde) {
        this.idpotvrde = idpotvrde;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @XmlTransient
    public Collection<Programputovanja> getProgramputovanjaCollection() {
        return programputovanjaCollection;
    }

    public void setProgramputovanjaCollection(Collection<Programputovanja> programputovanjaCollection) {
        this.programputovanjaCollection = programputovanjaCollection;
    }

    public Radnik getSifraradnika() {
        return sifraradnika;
    }

    public void setSifraradnika(Radnik sifraradnika) {
        this.sifraradnika = sifraradnika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpotvrde != null ? idpotvrde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Potvrdarezervacije)) {
            return false;
        }
        Potvrdarezervacije other = (Potvrdarezervacije) object;
        if ((this.idpotvrde == null && other.idpotvrde != null) || (this.idpotvrde != null && !this.idpotvrde.equals(other.idpotvrde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Potvrdarezervacije[ idpotvrde=" + idpotvrde + " ]";
    }
    
}

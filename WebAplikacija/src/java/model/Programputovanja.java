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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "PROGRAMPUTOVANJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programputovanja.findAll", query = "SELECT p FROM Programputovanja p"),
    @NamedQuery(name = "Programputovanja.findBySifraprograma", query = "SELECT p FROM Programputovanja p WHERE p.sifraprograma = :sifraprograma"),
    @NamedQuery(name = "Programputovanja.findByUkljucenoucenu", query = "SELECT p FROM Programputovanja p WHERE p.ukljucenoucenu = :ukljucenoucenu"),
    @NamedQuery(name = "Programputovanja.findByNijeukljucenoucenu", query = "SELECT p FROM Programputovanja p WHERE p.nijeukljucenoucenu = :nijeukljucenoucenu"),
    @NamedQuery(name = "Programputovanja.findByIznos", query = "SELECT p FROM Programputovanja p WHERE p.iznos = :iznos")})
public class Programputovanja implements Serializable {
    @Column(name = "STATUS")
    private String status;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Basic(optional = false)
    @Column(name = "SIFRAPROGRAMA")
    private BigDecimal sifraprograma;
    @Column(name = "UKLJUCENOUCENU")
    private String ukljucenoucenu;
    @Column(name = "NIJEUKLJUCENOUCENU")
    private String nijeukljucenoucenu;
    @Column(name = "IZNOS")
    private BigDecimal iznos;
    @JoinColumn(name = "IDPOTVRDE", referencedColumnName = "IDPOTVRDE")
    @ManyToOne
    private Potvrdarezervacije idpotvrde;
    @JoinColumn(name = "REDNIBROJPROGRAMA", referencedColumnName = "REDNIBROJPROGRAMA")
    @ManyToOne
    private Programiputovanja rednibrojprograma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programputovanja")
    private Collection<Stavkaprograma> stavkaprogramaCollection;

    public Programputovanja() {
    }

    public Programputovanja(BigDecimal sifraprograma) {
        this.sifraprograma = sifraprograma;
    }

    public BigDecimal getSifraprograma() {
        return sifraprograma;
    }

    public void setSifraprograma(BigDecimal sifraprograma) {
        this.sifraprograma = sifraprograma;
    }

    public String getUkljucenoucenu() {
        return ukljucenoucenu;
    }

    public void setUkljucenoucenu(String ukljucenoucenu) {
        this.ukljucenoucenu = ukljucenoucenu;
    }

    public String getNijeukljucenoucenu() {
        return nijeukljucenoucenu;
    }

    public void setNijeukljucenoucenu(String nijeukljucenoucenu) {
        this.nijeukljucenoucenu = nijeukljucenoucenu;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public Potvrdarezervacije getIdpotvrde() {
        return idpotvrde;
    }

    public void setIdpotvrde(Potvrdarezervacije idpotvrde) {
        this.idpotvrde = idpotvrde;
    }

    public Programiputovanja getRednibrojprograma() {
        return rednibrojprograma;
    }

    public void setRednibrojprograma(Programiputovanja rednibrojprograma) {
        this.rednibrojprograma = rednibrojprograma;
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
        hash += (sifraprograma != null ? sifraprograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programputovanja)) {
            return false;
        }
        Programputovanja other = (Programputovanja) object;
        if ((this.sifraprograma == null && other.sifraprograma != null) || (this.sifraprograma != null && !this.sifraprograma.equals(other.sifraprograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Programputovanja[ sifraprograma=" + sifraprograma + " ]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

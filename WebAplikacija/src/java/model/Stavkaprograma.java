/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gaga__m
 */
@Entity
@Table(name = "STAVKAPROGRAMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavkaprograma.findAll", query = "SELECT s FROM Stavkaprograma s"),
    @NamedQuery(name = "Stavkaprograma.findByIddana", query = "SELECT s FROM Stavkaprograma s WHERE s.stavkaprogramaPK.iddana = :iddana"),
    @NamedQuery(name = "Stavkaprograma.findBySifraprograma", query = "SELECT s FROM Stavkaprograma s WHERE s.stavkaprogramaPK.sifraprograma = :sifraprograma"),
    @NamedQuery(name = "Stavkaprograma.findByOpisdana", query = "SELECT s FROM Stavkaprograma s WHERE s.opisdana = :opisdana"),
    @NamedQuery(name = "Stavkaprograma.findByDatum", query = "SELECT s FROM Stavkaprograma s WHERE s.datum = :datum")})
public class Stavkaprograma implements Serializable {
    @Column(name = "STATUS")
    private String status;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkaprogramaPK stavkaprogramaPK;
    @Column(name = "OPISDANA")
    private String opisdana;
    @Column(name = "DATUM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @JoinColumn(name = "IDMESTA", referencedColumnName = "IDMESTA")
    @ManyToOne
    private Mestoobilaska idmesta;
    @JoinColumn(name = "SIFRAPROGRAMA", referencedColumnName = "SIFRAPROGRAMA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Programputovanja programputovanja;

    public Stavkaprograma() {
    }

    public Stavkaprograma(StavkaprogramaPK stavkaprogramaPK) {
        this.stavkaprogramaPK = stavkaprogramaPK;
    }

    public Stavkaprograma(BigInteger iddana, BigInteger sifraprograma) {
        this.stavkaprogramaPK = new StavkaprogramaPK(iddana, sifraprograma);
    }

    public StavkaprogramaPK getStavkaprogramaPK() {
        return stavkaprogramaPK;
    }

    public void setStavkaprogramaPK(StavkaprogramaPK stavkaprogramaPK) {
        this.stavkaprogramaPK = stavkaprogramaPK;
    }
    
    public String getOpisdana() {
        return opisdana;
    }

    public void setOpisdana(String opisdana) {
        this.opisdana = opisdana;
    }

    

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Mestoobilaska getIdmesta() {
        return idmesta;
    }

    public void setIdmesta(Mestoobilaska idmesta) {
        this.idmesta = idmesta;
    }

    public Programputovanja getProgramputovanja() {
        return programputovanja;
    }

    public void setProgramputovanja(Programputovanja programputovanja) {
        this.programputovanja = programputovanja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkaprogramaPK != null ? stavkaprogramaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavkaprograma)) {
            return false;
        }
        Stavkaprograma other = (Stavkaprograma) object;
        if ((this.stavkaprogramaPK == null && other.stavkaprogramaPK != null) || (this.stavkaprogramaPK != null && !this.stavkaprogramaPK.equals(other.stavkaprogramaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Stavkaprograma[ stavkaprogramaPK=" + stavkaprogramaPK + " ]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

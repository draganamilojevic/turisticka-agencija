/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gaga__m
 */
@Embeddable
public class AdresaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDRZAVE")
    private BigInteger iddrzave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGRADA")
    private BigInteger idgrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDADRESE")
    private BigInteger idadrese;

    public AdresaPK() {
    }

    public AdresaPK(BigInteger iddrzave, BigInteger idgrada, BigInteger idadrese) {
        this.iddrzave = iddrzave;
        this.idgrada = idgrada;
        this.idadrese = idadrese;
    }

    public BigInteger getIddrzave() {
        return iddrzave;
    }

    public void setIddrzave(BigInteger iddrzave) {
        this.iddrzave = iddrzave;
    }

    public BigInteger getIdgrada() {
        return idgrada;
    }

    public void setIdgrada(BigInteger idgrada) {
        this.idgrada = idgrada;
    }

    public BigInteger getIdadrese() {
        return idadrese;
    }

    public void setIdadrese(BigInteger idadrese) {
        this.idadrese = idadrese;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddrzave != null ? iddrzave.hashCode() : 0);
        hash += (idgrada != null ? idgrada.hashCode() : 0);
        hash += (idadrese != null ? idadrese.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresaPK)) {
            return false;
        }
        AdresaPK other = (AdresaPK) object;
        if ((this.iddrzave == null && other.iddrzave != null) || (this.iddrzave != null && !this.iddrzave.equals(other.iddrzave))) {
            return false;
        }
        if ((this.idgrada == null && other.idgrada != null) || (this.idgrada != null && !this.idgrada.equals(other.idgrada))) {
            return false;
        }
        if ((this.idadrese == null && other.idadrese != null) || (this.idadrese != null && !this.idadrese.equals(other.idadrese))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.AdresaPK[ iddrzave=" + iddrzave + ", idgrada=" + idgrada + ", idadrese=" + idadrese + " ]";
    }
    
}

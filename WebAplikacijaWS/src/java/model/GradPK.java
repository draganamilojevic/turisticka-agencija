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
public class GradPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDRZAVE")
    private BigInteger iddrzave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGRADA")
    private BigInteger idgrada;

    public GradPK() {
    }

    public GradPK(BigInteger iddrzave, BigInteger idgrada) {
        this.iddrzave = iddrzave;
        this.idgrada = idgrada;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddrzave != null ? iddrzave.hashCode() : 0);
        hash += (idgrada != null ? idgrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradPK)) {
            return false;
        }
        GradPK other = (GradPK) object;
        if ((this.iddrzave == null && other.iddrzave != null) || (this.iddrzave != null && !this.iddrzave.equals(other.iddrzave))) {
            return false;
        }
        if ((this.idgrada == null && other.idgrada != null) || (this.idgrada != null && !this.idgrada.equals(other.idgrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.GradPK[ iddrzave=" + iddrzave + ", idgrada=" + idgrada + " ]";
    }
    
}

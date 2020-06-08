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
public class StavkaprogramaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDANA")
    private BigInteger iddana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIFRAPROGRAMA")
    private BigInteger sifraprograma;

    public StavkaprogramaPK() {
    }

    public StavkaprogramaPK(BigInteger iddana, BigInteger sifraprograma) {
        this.iddana = iddana;
        this.sifraprograma = sifraprograma;
    }

    public BigInteger getIddana() {
        return iddana;
    }

    public void setIddana(BigInteger iddana) {
        this.iddana = iddana;
    }

    public BigInteger getSifraprograma() {
        return sifraprograma;
    }

    public void setSifraprograma(BigInteger sifraprograma) {
        this.sifraprograma = sifraprograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddana != null ? iddana.hashCode() : 0);
        hash += (sifraprograma != null ? sifraprograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaprogramaPK)) {
            return false;
        }
        StavkaprogramaPK other = (StavkaprogramaPK) object;
        if ((this.iddana == null && other.iddana != null) || (this.iddana != null && !this.iddana.equals(other.iddana))) {
            return false;
        }
        if ((this.sifraprograma == null && other.sifraprograma != null) || (this.sifraprograma != null && !this.sifraprograma.equals(other.sifraprograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.StavkaprogramaPK[ iddana=" + iddana + ", sifraprograma=" + sifraprograma + " ]";
    }
    
}

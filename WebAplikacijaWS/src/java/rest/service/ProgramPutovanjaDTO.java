/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import model.Potvrdarezervacije;
import model.Programiputovanja;
import model.Stavkaprograma;

/**
 *
 * @author gaga__m
 */
public class ProgramPutovanjaDTO {
    @XmlElement
    private BigDecimal sifraprograma;
    @XmlElement
    private String ukljucenoucenu;
    @XmlElement
    private String nijeukljucenoucenu;
    @XmlElement
    private BigDecimal iznos;
    @XmlElement
    private String status;
    @XmlElement
    private Potvrdarezervacije idpotvrde;
    @XmlElement
    private Programiputovanja rednibrojprograma;
    @XmlElement
    private List<StavkaDTO> listaStavki;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<StavkaDTO> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaDTO> listaStavki) {
        this.listaStavki = listaStavki;
    }
    
    
    
    
}

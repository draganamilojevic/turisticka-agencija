/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlElement;


/**
 *
 * @author gaga__m
 */
public class ZahtevKorisnikaDTO {
    @XmlElement
    private BigDecimal sifraZahteva;
    @XmlElement
    private BigInteger vremeboravka;
    @XmlElement
    private KorisnikDTO idkorisnika;
    @XmlElement
    private TipPrevozaDTO idtipaprevoza;
    @XmlElement
    private TipSmestajaDTO idtipasmestaja;
    @XmlElement
    private DestinacijaDTO iddestinacije;

    public BigDecimal getSifraZahteva() {
        return sifraZahteva;
    }

    public void setSifraZahteva(BigDecimal sifraZahteva) {
        this.sifraZahteva = sifraZahteva;
    }

    public BigInteger getVremeboravka() {
        return vremeboravka;
    }

    public void setVremeboravka(BigInteger vremeboravka) {
        this.vremeboravka = vremeboravka;
    }

    public KorisnikDTO getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(KorisnikDTO idkorisnika) {
        this.idkorisnika = idkorisnika;
    }

    public TipPrevozaDTO getIdtipaprevoza() {
        return idtipaprevoza;
    }

    public void setIdtipaprevoza(TipPrevozaDTO idtipaprevoza) {
        this.idtipaprevoza = idtipaprevoza;
    }

    public TipSmestajaDTO getIdtipasmestaja() {
        return idtipasmestaja;
    }

    public void setIdtipasmestaja(TipSmestajaDTO idtipasmestaja) {
        this.idtipasmestaja = idtipasmestaja;
    }

    public DestinacijaDTO getIddestinacije() {
        return iddestinacije;
    }

    public void setIddestinacije(DestinacijaDTO iddestinacije) {
        this.iddestinacije = iddestinacije;
    }

    
}

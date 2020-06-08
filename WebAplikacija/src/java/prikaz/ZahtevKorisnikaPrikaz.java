/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prikaz;

import java.io.Serializable;


/**
 *
 * @author gaga__m
 */
public class ZahtevKorisnikaPrikaz implements Serializable{
    private int sifrazahteva;
    private int vremeboravka;
    private KorisnikPrikaz idkorisnika;
    private TipPrevozaPrikaz idtipaprevoza;
    private TipSmestajaPrikaz idtipasmestaja;
    private DestinacijaPrikaz iddestinacije;
    
    public int getSifrazahteva() {
        return sifrazahteva;
    }

    public void setSifrazahteva(int sifrazahteva) {
        this.sifrazahteva = sifrazahteva;
    }

    public int getVremeboravka() {
        return vremeboravka;
    }

    public void setVremeboravka(int vremeboravka) {
        this.vremeboravka = vremeboravka;
    }

    public KorisnikPrikaz getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(KorisnikPrikaz idkorisnika) {
        this.idkorisnika = idkorisnika;
    }

    public TipPrevozaPrikaz getIdtipaprevoza() {
        return idtipaprevoza;
    }

    public void setIdtipaprevoza(TipPrevozaPrikaz idtipaprevoza) {
        this.idtipaprevoza = idtipaprevoza;
    }

    public TipSmestajaPrikaz getIdtipasmestaja() {
        return idtipasmestaja;
    }

    public void setIdtipasmestaja(TipSmestajaPrikaz idtipasmestaja) {
        this.idtipasmestaja = idtipasmestaja;
    }

    public DestinacijaPrikaz getIddestinacije() {
        return iddestinacije;
    }

    public void setIddestinacije(DestinacijaPrikaz iddestinacije) {
        this.iddestinacije = iddestinacije;
    }

    
    
}

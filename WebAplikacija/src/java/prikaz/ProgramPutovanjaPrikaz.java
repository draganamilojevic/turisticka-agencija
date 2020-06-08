/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prikaz;

import java.io.Serializable;
import java.util.List;
import mb.StavkeKlasa;

/**
 *
 * @author gaga__m
 */
public class ProgramPutovanjaPrikaz implements Serializable{
    private int sifraprograma;
    private String ukljucenoucenu;
    private String nijeukljucenoucenu;
    private double iznos;
    private PotvrdaRezervacijePrikaz idpotvrde;
    private int rednibrojprograma;
    private String status;
    private List<StavkeKlasa> stavke;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public int getSifraprograma() {
        return sifraprograma;
    }

    public void setSifraprograma(int sifraprograma) {
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

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public PotvrdaRezervacijePrikaz getIdpotvrde() {
        return idpotvrde;
    }

    public void setIdpotvrde(PotvrdaRezervacijePrikaz idpotvrde) {
        this.idpotvrde = idpotvrde;
    }

    public int getRednibrojprograma() {
        return rednibrojprograma;
    }

    public void setRednibrojprograma(int rednibrojprograma) {
        this.rednibrojprograma = rednibrojprograma;
    }

    public List<StavkeKlasa> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkeKlasa> stavke) {
        this.stavke = stavke;
    }
    
    
    
}

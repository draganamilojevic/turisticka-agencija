/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;

import dbb.DBBroker;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Response;
import model.Destinacija;
import model.Korisnik;
import model.Tipprevoza;
import model.Tipsmestaja;
import model.Zahtevkorisnika;
import org.json.simple.JSONObject;
import prikaz.DestinacijaPrikaz;
import prikaz.KorisnikPrikaz;
import prikaz.TipPrevozaPrikaz;
import prikaz.TipSmestajaPrikaz;
import prikaz.ZahtevKorisnikaPrikaz;

import rest.RESTKontrolerZahtevKorisnika;

/**
 *
 * @author gaga__m
 */
public class KontrolerZahtevaKorisnika implements Serializable {

    private DBBroker dbb;
    RESTKontrolerZahtevKorisnika restKontroler;

    public KontrolerZahtevaKorisnika() {
        dbb = new DBBroker();
        restKontroler = new RESTKontrolerZahtevKorisnika();
    }

    public Zahtevkorisnika kreirajZahtev(int vremeboravka, Korisnik korisnik, Destinacija destinacija, Tipprevoza tipprevoza, Tipsmestaja tipsmestaja) {
        Zahtevkorisnika zk = new Zahtevkorisnika();
        zk.setIdtipaprevoza(tipprevoza);
        zk.setIdtipasmestaja(tipsmestaja);
        long vremeboravka1 = vremeboravka;
        zk.setVremeboravka(BigInteger.valueOf(vremeboravka1));
        zk.setIddestinacije(destinacija);
        zk.setIdkorisnika(korisnik);
        return zk;
    }

    public HashMap<String, Integer> ucitajTipovePrevoza() {
        HashMap<String, Integer> tipoviPrevozaMapa = new HashMap<>();
        List<Tipprevoza> tipoviPrevozaLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            tipoviPrevozaLista = dbb.ucitajTipovePrevoza();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Tipprevoza tp : tipoviPrevozaLista) {
            tipoviPrevozaMapa.put(tp.getNazivtipaprevoza(), tp.getIdtipaprevoza().intValue());

        }

        return tipoviPrevozaMapa;
    }

    public HashMap<String, Integer> ucitajTipoveSmestaja() {
        HashMap<String, Integer> tipoviSmestajaMapa = new HashMap<>();
        List<Tipsmestaja> listaTipovaSmestaja = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listaTipovaSmestaja = dbb.ucitajTipoveSmestaja();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Tipsmestaja ts : listaTipovaSmestaja) {
            tipoviSmestajaMapa.put(ts.getNazivtipasmestaja(), ts.getIdtipasmestaja().intValue());
        }
        return tipoviSmestajaMapa;
    }

    public HashMap<String, Integer> ucitajDestinacije() {
        HashMap<String, Integer> destinacijeMapa = new HashMap<>();
        List<Destinacija> destinacijeLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            destinacijeLista = dbb.ucitajDestinacije();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Destinacija d : destinacijeLista) {
            destinacijeMapa.put(d.getNazivdestinacije(), d.getIddestinacije().intValue());

        }

        return destinacijeMapa;
    }

    public List<Korisnik> ucitajKorisnike() {
        //HashMap<String, Integer> korisniciMapa = new HashMap<>();
        List<Korisnik> korisniciLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            korisniciLista = dbb.ucitajKorisnike();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //for (Korisnik k : korisniciLista) {
        //korisniciMapa.put(k.getImeprezime(), k.getIdkorisnika().intValue());
        //}
        return korisniciLista;
    }

    public Tipprevoza pronadjiTipPrevoza(int IDTipaPrevoza) {
        List<Tipprevoza> listaPrevoza = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listaPrevoza = dbb.ucitajTipovePrevoza();
            if (listaPrevoza.isEmpty()) {
                System.out.println("Lista prevoza prazna");
            }
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Tipprevoza tp : listaPrevoza) {
            if (tp.getIdtipaprevoza().intValue() == IDTipaPrevoza) {
                return tp;
            }
        }
        System.out.println("Nikad u if ne udje");
        return null;
    }

    public Tipsmestaja pronadjiTipSmestaja(int IDTipaSmestaja) {
        List<Tipsmestaja> listasmestaja = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listasmestaja = dbb.ucitajTipoveSmestaja();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Tipsmestaja ts : listasmestaja) {
            if (ts.getIdtipasmestaja().intValue() == IDTipaSmestaja) {
                return ts;
            }
        }
        return null;
    }

    private Korisnik pronadjiKorisnika(int korisnikid) {
        List<Korisnik> listakorisnika = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listakorisnika = dbb.ucitajKorisnike();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Korisnik k : listakorisnika) {
            if (k.getIdkorisnika().intValue() == korisnikid) {
                return k;
            }
        }
        return null;
    }

    public boolean sacuvajZahtev(int vremeBoravka, int korisnikid, int IDDestinacije, int IDTipaPrevoza, int IDTipaSmestaja) {
        boolean uspesno = false;

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();
            Zahtevkorisnika novi = kreirajZahtev(vremeBoravka, pronadjiKorisnika(korisnikid), pronadjiDestinaciju(IDDestinacije), pronadjiTipPrevoza(IDTipaPrevoza), pronadjiTipSmestaja(IDTipaSmestaja));
            System.out.println("Zahtev kreiran");
            System.out.println("Zahtev tip prevoza: " + novi.getIdtipaprevoza().getNazivtipaprevoza());
            System.out.println("Zahtev tip smestaja: " + novi.getIdtipasmestaja().getNazivtipasmestaja());
            System.out.println("Zahtev vreme boravka: " + novi.getVremeboravka());
            System.out.println("Zahtev korisnik: " + novi.getIdkorisnika().getImeprezime());
            System.out.println("Zahtev destinacija: " + novi.getIddestinacije().getNazivdestinacije());
            
            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();
            BigDecimal sifraZahteva = dbb.vratiMaxIDZahteva();

            novi.setSifrazahteva(sifraZahteva);
            uspesno = dbb.sacuvajZahtev(novi);

            
            if (uspesno) {
                dbb.potvrdiTransakciju();
                dbb.zatvoriKonekciju();
                return true;
            } else {
                dbb.ponistiTransakciju();
                dbb.zatvoriKonekciju();
                System.out.println("Else");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }
        return false;

    }

    public boolean sacuvajZahtevRest(int sifraZahteva, int vremeBoravka, int korisnikid, int IDDestinacije, int IDTipaPrevoza, int IDTipaSmestaja) {
        JSONObject json = new JSONObject();

        json.put("sifrazahteva", sifraZahteva);
        json.put("vremeboravka", vremeBoravka);
        json.put("idkorisnika", korisnikid);

        json.put("idtipaprevoza", IDTipaPrevoza + "");
        json.put("idtipasmestaja", IDTipaSmestaja + "");
        json.put("iddestinacije", IDDestinacije + "");

        System.out.println(json.toJSONString());

        Response res = restKontroler.sacuvajZahtev(json.toJSONString());
        return res.getStatus() == Response.Status.OK.getStatusCode();
    }

    public List<Destinacija> ucitajDestinacijeMany() {
        List<Destinacija> destinacijeLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            destinacijeLista = dbb.ucitajDestinacije();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destinacijeLista;
    }

    public Zahtevkorisnika pronadjiZahtev(int sifraZahteva) {
        List<Zahtevkorisnika> listazahteva = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listazahteva = dbb.ucitajZahteve();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Zahtevkorisnika zk : listazahteva) {
            if (zk.getSifrazahteva().intValue() == sifraZahteva) {
                return zk;
            }
        }
        return null;
    }

    public List<Zahtevkorisnika> ucitajZahteve() {
        List<Zahtevkorisnika> listazahteva = new ArrayList<>();

        try {
            dbb.otvoriKonekciju();
            listazahteva = dbb.ucitajZahteve();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listazahteva;
    }
    
    public Destinacija pronadjiDestinaciju(int IDDestinacije) {
        List<Destinacija> listaD = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listaD = dbb.ucitajDestinacije();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Destinacija d : listaD) {
            if (d.getIddestinacije().intValue() == IDDestinacije) {
                return d;
            }
        }
        return null;
    }

    public boolean izmeniZahtev(int sifraZahteva, int vremeBoravka, int korisnikid, int IDDestinacije, int IDTipaPrevoza, int IDTipaSmestaja) {
        boolean uspesno = false;

        try {

            Zahtevkorisnika novi = kreirajZahtev(sifraZahteva, vremeBoravka, pronadjiKorisnika(korisnikid), pronadjiDestinaciju(IDDestinacije), pronadjiTipPrevoza(IDTipaPrevoza), pronadjiTipSmestaja(IDTipaSmestaja));
            System.out.println("Zahtev kreiran");
            System.out.println("Zahtev tip prevoza: " + novi.getIdtipaprevoza().getNazivtipaprevoza());
            System.out.println("Zahtev tip smestaja: " + novi.getIdtipasmestaja().getNazivtipasmestaja());
            System.out.println("Zahtev vreme boravka: " + novi.getVremeboravka());
            System.out.println("Zahtev korisnik: " + novi.getIdkorisnika().getImeprezime());
            System.out.println("Zahtev destinacija: "+novi.getIddestinacije().getNazivdestinacije());
            
            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();
            uspesno = dbb.izmeniZahtev(novi);

            
            if (uspesno) {
                dbb.potvrdiTransakciju();
                dbb.zatvoriKonekciju();
                return true;
            } else {
                dbb.ponistiTransakciju();
                dbb.zatvoriKonekciju();
                System.out.println("Else");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            dbb.zatvoriKonekciju();
        }
        return false;
    }

    public boolean izmeniZahtevRest(int sifraZahteva, int vremeBoravka, int korisnikid, int IDDestinacije, int IDTipaPrevoza, int IDTipaSmestaja) {
        JSONObject json = new JSONObject();

        json.put("vremeboravka", vremeBoravka);
        json.put("idkorisnika", korisnikid);

        json.put("idtipaprevoza", IDTipaPrevoza + "");
        json.put("idtipasmestaja", IDTipaSmestaja + "");
        json.put("iddestinacije", IDDestinacije + "");

        System.out.println(json.toJSONString());

        Response res = restKontroler.izmeniZahtev(json.toJSONString(), String.valueOf(sifraZahteva));
        return res.getStatus() == Response.Status.OK.getStatusCode();
    }

    private Zahtevkorisnika kreirajZahtev(int sifraZahteva, int vremeBoravka, Korisnik korisnikid, Destinacija destinacija, Tipprevoza tipPrevoza, Tipsmestaja tipSmestaja) {
        Zahtevkorisnika zk = new Zahtevkorisnika();
        double sifra = sifraZahteva;
        zk.setSifrazahteva(BigDecimal.valueOf(sifra));
        zk.setIdtipaprevoza(tipPrevoza);
        zk.setIdtipasmestaja(tipSmestaja);
        long vremeboravka1 = vremeBoravka;
        zk.setVremeboravka(BigInteger.valueOf(vremeboravka1));
        zk.setIddestinacije(destinacija);
        zk.setIdkorisnika(korisnikid);
        return zk;
    }

    public List<Destinacija> pronadjiDestinacije(String[] izabraneD) {
        List<Destinacija> listadestinacija = new ArrayList<>();
        List<Destinacija> filtrirana = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listadestinacija = dbb.ucitajDestinacije();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Destinacija d : listadestinacija) {
            for (String s : izabraneD) {
                if (d.getIddestinacije().intValue() == Integer.valueOf(s)) {
                    filtrirana.add(d);
                }
            }
        }
        return filtrirana;
    }

    public boolean obrisiZahtev(BigDecimal sifra) {
        boolean uspesno = false;

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();
            uspesno = dbb.obrisiZahtev(sifra);
            dbb.potvrdiTransakciju();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            dbb.ponistiTransakciju();
            dbb.zatvoriKonekciju();
            e.printStackTrace();
        }

        return uspesno;
    }

    public boolean obrisiZahtevRest(BigDecimal sifra) {
        JSONObject json = new JSONObject();
        json.put("sifraZahteva", sifra + "");

        Response res = restKontroler.obrisiZahtev(sifra.toString());

        return res.getStatus() == Response.Status.OK.getStatusCode();
    }

    public List<KorisnikPrikaz> ucitajKorisnikePrikaz() {
        List<Korisnik> listaKorisnika = new ArrayList<>();
        List<KorisnikPrikaz> listaKorisnikaP = new ArrayList<>();
        dbb.otvoriKonekciju();
        dbb.pokreniTransakciju();
        listaKorisnika = dbb.ucitajKorisnike();
        dbb.zatvoriKonekciju();

        for (Korisnik k : listaKorisnika) {
            KorisnikPrikaz kp = new KorisnikPrikaz();
            kp.setIdkorisnika(k.getIdkorisnika().intValue());
            kp.setImeprezime(k.getImeprezime());
            kp.setJmbg(k.getJmbg());
            kp.setBrpasosa(k.getBrpasosa());
            kp.setBrtelefona(k.getBrtelefona());
            kp.setDatumrodj(k.getDatumrodj());
            kp.setAdresa(k.getAdresa().toString());
            listaKorisnikaP.add(kp);
        }
        
        return listaKorisnikaP;

    }

    public List<ZahtevKorisnikaPrikaz> ucitajZahtevePrikaz() {
        List<Zahtevkorisnika> listaZahteva = new ArrayList<>();
        List<ZahtevKorisnikaPrikaz> listaZahtevaP = new ArrayList<>();
        dbb.otvoriKonekciju();
        dbb.pokreniTransakciju();
        listaZahteva = dbb.ucitajZahteve();
        dbb.zatvoriKonekciju();

        for (Zahtevkorisnika zk : listaZahteva) {
            ZahtevKorisnikaPrikaz zkp = new ZahtevKorisnikaPrikaz();
            zkp.setSifrazahteva(zk.getSifrazahteva().intValue());
            zkp.setVremeboravka(zk.getVremeboravka().intValue());
            
            KorisnikPrikaz kor = new KorisnikPrikaz();
            kor.setIdkorisnika(zk.getIdkorisnika().getIdkorisnika().intValue());
            kor.setJmbg(zk.getIdkorisnika().getJmbg());
            kor.setImeprezime(zk.getIdkorisnika().getImeprezime());
            kor.setDatumrodj(zk.getIdkorisnika().getDatumrodj());
            kor.setBrtelefona(zk.getIdkorisnika().getBrtelefona());
            kor.setBrpasosa(zk.getIdkorisnika().getBrpasosa());
            kor.setAdresa(zk.getIdkorisnika().getAdresa().toString());
            zkp.setIdkorisnika(kor);
            
            TipPrevozaPrikaz tpp = new TipPrevozaPrikaz();
            tpp.setIdtipaprevoza(zk.getIdtipaprevoza().getIdtipaprevoza().intValue());
            tpp.setNazivtipaprevoza(zk.getIdtipaprevoza().getNazivtipaprevoza());
            zkp.setIdtipaprevoza(tpp);
            
            TipSmestajaPrikaz tsp = new TipSmestajaPrikaz();
            tsp.setIdtipasmestaja(zk.getIdtipasmestaja().getIdtipasmestaja().intValue());
            tsp.setNazivtipasmestaja(zk.getIdtipasmestaja().getNazivtipasmestaja());
            zkp.setIdtipasmestaja(tsp);
            
            DestinacijaPrikaz dp = new DestinacijaPrikaz();
            dp.setIddestinacije(zk.getIddestinacije().getIddestinacije().intValue());
            dp.setNazivdestinacije(zk.getIddestinacije().getNazivdestinacije());
            zkp.setIddestinacije(dp);
            
            listaZahtevaP.add(zkp);
        }
        
        return listaZahtevaP;
    }

    public int vratiSifruZahteva() {
        dbb.otvoriKonekciju();
        dbb.pokreniTransakciju();
        BigDecimal sifraZahteva = dbb.vratiMaxIDZahteva();
        dbb.zatvoriKonekciju();
        return sifraZahteva.intValue();
    }

}

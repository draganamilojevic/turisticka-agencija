/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Destinacija;
import model.Korisnik;
import model.Tipprevoza;
import model.Tipsmestaja;
import model.Zahtevkorisnika;

/**
 *
 * @author gaga__m
 */
public class KontrolerZahtevaKorisnika implements Serializable {

    private DBBroker dbb;

    public KontrolerZahtevaKorisnika() {
        dbb = new DBBroker();
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

    public List<Tipprevoza> ucitajTipovePrevoza() {

        List<Tipprevoza> tipoviPrevozaLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            tipoviPrevozaLista = dbb.ucitajTipovePrevoza();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tipoviPrevozaLista;
    }

    public List<Tipsmestaja> ucitajTipoveSmestaja() {

        List<Tipsmestaja> listaTipovaSmestaja = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            listaTipovaSmestaja = dbb.ucitajTipoveSmestaja();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaTipovaSmestaja;
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

        List<Korisnik> korisniciLista = new ArrayList<>();
        try {
            dbb.otvoriKonekciju();
            korisniciLista = dbb.ucitajKorisnike();
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public Korisnik pronadjiKorisnika(int korisnikid) {
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

    //sa sifrom
    public boolean sacuvajZahtev(int sifraZahteva, int vremeBoravka, int korisnikid, int IDDestinacije, int IDTipaPrevoza, int IDTipaSmestaja) {
        boolean uspesno = false;

        try {

            Zahtevkorisnika novi = kreirajZahtev(sifraZahteva, vremeBoravka, pronadjiKorisnika(korisnikid), pronadjiDestinaciju(IDDestinacije), pronadjiTipPrevoza(IDTipaPrevoza), pronadjiTipSmestaja(IDTipaSmestaja));
            System.out.println("Zahtev kreiran");
            System.out.println("Zahtev tip prevoza: " + novi.getIdtipaprevoza().getNazivtipaprevoza());
            System.out.println("Zahtev tip smestaja: " + novi.getIdtipasmestaja().getNazivtipasmestaja());
            System.out.println("Zahtev vreme boravka: " + novi.getVremeboravka());
            System.out.println("Zahtev korisnik: " + novi.getIdkorisnika().getImeprezime());
            System.out.println("Zahtev destinacija: " + novi.getIddestinacije().getNazivdestinacije());

            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();

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

    //bez sifre zahteva

    public boolean sacuvajZahtev(int vremeBoravka, int korisnikid, int IDDestinacije, int IDTipaPrevoza, int IDTipaSmestaja) {
        boolean uspesno = false;

        try {

            Zahtevkorisnika novi = kreirajZahtev(vremeBoravka, pronadjiKorisnika(korisnikid), pronadjiDestinaciju(IDDestinacije), pronadjiTipPrevoza(IDTipaPrevoza), pronadjiTipSmestaja(IDTipaSmestaja));
            System.out.println("Zahtev kreiran");
            System.out.println("Zahtev tip prevoza: " + novi.getIdtipaprevoza().getNazivtipaprevoza());
            System.out.println("Zahtev tip smestaja: " + novi.getIdtipasmestaja().getNazivtipasmestaja());
            System.out.println("Zahtev vreme boravka: " + novi.getVremeboravka());
            System.out.println("Zahtev korisnik: " + novi.getIdkorisnika().getImeprezime());
            System.out.println("Zahtev destinacija: " + novi.getIddestinacije().getNazivdestinacije());

            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();

            BigDecimal sifraZ = dbb.vratiMaxIDZahteva();
            novi.setSifrazahteva(sifraZ);
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

    public boolean izmeniZahtev(int sifraZahteva, int vremeBoravka, int korisnikid, int IDDestinacije, int IDTipaPrevoza, int IDTipaSmestaja) {
        boolean uspesno = false;

        try {

            Zahtevkorisnika novi = kreirajZahtev(sifraZahteva, vremeBoravka, pronadjiKorisnika(korisnikid), pronadjiDestinaciju(IDDestinacije), pronadjiTipPrevoza(IDTipaPrevoza), pronadjiTipSmestaja(IDTipaSmestaja));
            System.out.println("Zahtev kreiran");
            System.out.println("Zahtev tip prevoza: " + novi.getIdtipaprevoza().getNazivtipaprevoza());
            System.out.println("Zahtev tip smestaja: " + novi.getIdtipasmestaja().getNazivtipasmestaja());
            System.out.println("Zahtev vreme boravka: " + novi.getVremeboravka());
            System.out.println("Zahtev korisnik: " + novi.getIdkorisnika().getImeprezime());
            System.out.println("Zahtev destinacija: " + novi.getIddestinacije().getNazivdestinacije());

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
        return listadestinacija;
    }

    public boolean obrisiZahtev(BigDecimal sifra) {
        boolean uspesno = false;

        try {
            dbb.otvoriKonekciju();
            dbb.pokreniTransakciju();
            System.out.println("Pokrenuta transakcija");
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

    public int vratiMaxID() {
        int sifra = 0;
        try {
            dbb.otvoriKonekciju();
            sifra = dbb.vratiMaxIDZahteva().intValue()-1;
            dbb.zatvoriKonekciju();
        } catch (Exception e) {
            dbb.zatvoriKonekciju();
            e.printStackTrace();
        }
        return sifra;
    }

}

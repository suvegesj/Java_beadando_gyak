package com.beadando.eaw2hg;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "labdarugo")
public class labdarugo {

        @Id
        private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMezszám() {
        return mezszám;
    }

    public void setMezszám(String mezszám) {
        this.mezszám = mezszám;
    }

    public String getKlubid() {
        return klubid;
    }

    public void setKlubid(String klubid) {
        this.klubid = klubid;
    }

    public int getPosztid() {
        return posztid;
    }

    public void setPosztid(int posztid) {
        this.posztid = posztid;
    }

    public int getUtónév() {
        return utónév;
    }

    public void setUtónév(int utónév) {
        this.utónév = utónév;
    }

    public int getVezetéknév() {
        return vezetéknév;
    }

    public void setVezetéknév(int vezetéknév) {
        this.vezetéknév = vezetéknév;
    }

    public int getSzületési_idő() {
        return születési_idő;
    }

    public void setSzületési_idő(int születési_idő) {
        this.születési_idő = születési_idő;
    }

    public int getMagyar() {
        return magyar;
    }

    public void setMagyar(int magyar) {
        this.magyar = magyar;
    }

    public int getKülföldi() {
        return külföldi;
    }

    public void setKülföldi(int külföldi) {
        this.külföldi = külföldi;
    }

    @Column(name = "mezszam")
        private String mezszám;
        @Column(name = "klubid")
        private String klubid;
        @Column(name = "posztid")
        private int posztid;
        @Column(name = "utonev")
        private int utónév;
        @Column(name = "vezeteknev")
        private int vezetéknév;
        @Column(name = "szulido")
        private int születési_idő;
        @Column(name = "magyar")
        private int magyar;
        @Column(name = "kulfoldi")
        private int külföldi;

    @Column(name = "ertek")
    private int érték;

    public int getÉrték() {
        return érték;
    }

    public void setÉrték(int érték) {
        this.érték = érték;

    }
        @OneToMany(mappedBy = "labdarugoid")
        private List<poszt> posztok;

    public List<com.example.nb1.poszt> getPosztok() {
        return posztok;
    }

    public void setPosztok(List<com.example.nb1.poszt> posztok) {
        this.posztok = posztok;
    }

    public com.example.nb1.poszt getPoszt() {
        return poszt;
    }

    public void setPoszt(com.example.nb1.poszt poszt) {
        this.poszt = poszt;
    }

    @OneToOne
        @JoinColumn(name = "vezeteknev", referencedColumnName = "mezszam", insertable=false,
                updatable=false)
        private poszt poszt;


}

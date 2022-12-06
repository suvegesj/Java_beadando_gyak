package com.beadando.eaw2hg;

import jakarta.persistence.*;

@Entity
@Table(name = "poszt")

public class poszt {
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }

    @Id
    private String Id;
    @Column(name = "nev")
    private String név;

    public com.example.nb1.labdarugo getLabdarugo() {
        return labdarugo;
    }

    public void setLabdarugo(com.example.nb1.labdarugo labdarugo) {
        this.labdarugo = labdarugo;
    }

    @ManyToOne
    @JoinColumn(name = "labdarugoid", referencedColumnName = "id", insertable=false, updatable=false)
    private labdarugo labdarugo;
}

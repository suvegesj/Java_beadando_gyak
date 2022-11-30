package com.beadando.eaw2hg;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "klub")

public class klub {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCsapatnév() {
        return csapatnév;
    }

    public void setCsapatnév(String csapatnév) {
        this.csapatnév = csapatnév;
    }

    @Id
    private int id;
    @Column(name = "csapatnev")
    private String csapatnév;


}

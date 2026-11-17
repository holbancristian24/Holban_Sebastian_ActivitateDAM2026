package com.example.examentablete;

import java.io.Serializable;

public class Tableta implements Serializable {

    private int idTableta;
    private String model;
    private int spatiuMemorie;
    private boolean garantie;

    public Tableta(int idTableta, String model,
                   int spatiuMemorie, boolean garantie) {
        this.idTableta = idTableta;
        this.model = model;
        this.spatiuMemorie = spatiuMemorie;
        this.garantie = garantie;
    }

    public int getIdTableta() {
        return idTableta;
    }

    public String getModel() {
        return model;
    }

    public int getSpatiuMemorie() {
        return spatiuMemorie;
    }

    public boolean isGarantie() {
        return garantie;
    }
}

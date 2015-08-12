package com.example.user.triquirapido;

/**
 * Created by user on 11/08/2015.
 */
public class Jugador {

    private boolean esAndroid;
    private String id;
    private boolean tieneTurno;


    public Jugador(boolean esAndroid, String id, boolean tieneTurno){
        this.esAndroid =esAndroid;
        this.id = id;
        this.tieneTurno=tieneTurno;
    }

    public boolean isEsAndroid() {
        return esAndroid;
    }

    public void setEsAndroid(boolean esAndroid) {
        this.esAndroid = esAndroid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTieneTurno() {
        return tieneTurno;
    }

    public void setTieneTurno(boolean tieneTurno) {
        this.tieneTurno = tieneTurno;
    }
}

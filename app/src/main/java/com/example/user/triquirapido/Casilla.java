package com.example.user.triquirapido;

import android.widget.Button;

/**
 * Created by user on 11/08/2015.
 */
public class Casilla {

    public static final int VACIO = 1;
    public static final int EQUIS = 2;
    public static final int CIRCULO = 3;

    private Button btn;
    private int estado;

    public Casilla(){
        //this.btn = btn;
        estado = VACIO;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}


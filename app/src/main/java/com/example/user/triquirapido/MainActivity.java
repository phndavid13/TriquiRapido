package com.example.user.triquirapido;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    public static final int TAMANIO = 3;
    public  static final int CIRCLE = R.drawable.minion_1;
    public static  final  int ESQUIS = R.drawable.minion_2;

    private Jugador jugador1;
    private Jugador jugador2;
    private boolean termino;
    private Casilla[][] malla;
    private boolean turno;
    private int numeroTurnos;
    private TextView txtGanador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void inicio(){
        jugador1 = new Jugador(false,"primerJugador",true);
        jugador2 = new Jugador(false,"segundoJugador",false);
        termino = false;
        turno = true;
        txtGanador = (TextView) findViewById(R.id.txtGanador);
        malla = new Casilla[TAMANIO][TAMANIO];
        numeroTurnos = 0;
        inicializarMalla();
    }
    public void inicializarMalla(){
        for (int i=0;i<TAMANIO;i++){
            for (int j=0;j<TAMANIO;j++){
                malla[i][j] = new Casilla();
            }
        }
    }
    public void  cambiarEstado(ImageButton btn, int fila, int columna) {
        if(!termino) {
            if (malla[fila][columna].getEstado() == Casilla.VACIO) {
                numeroTurnos++;
                if (turno) {
                    malla[fila][columna].setEstado(Casilla.EQUIS);
                    btn.setImageResource(ESQUIS);
                    turno = false;
                    verificarTurno(fila, columna, Casilla.EQUIS);
                } else {
                    malla[fila][columna].setEstado(Casilla.CIRCULO);
                    btn.setImageResource(CIRCLE);
                    turno = true;
                    verificarTurno(fila, columna, Casilla.CIRCULO);
                }
            }
        }
    }
    public void btn00(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn00);
        cambiarEstado(btn,0,0);
    }
    public void btn01(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn01);
        cambiarEstado(btn, 0,1);
    }
    public void btn02(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn02);
        cambiarEstado(btn,0,2);
    }
    public void btn10(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn10);
        cambiarEstado(btn,1,0);
    }
    public void btn11(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn11);
        cambiarEstado(btn,1,1);
    }
    public void btn12(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn12);
        cambiarEstado(btn,1,2);
    }
    public void btn20(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn20);
        cambiarEstado(btn,2,0);
    }
    public void btn21(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn21);
       cambiarEstado(btn,2,1);
    }
    public void btn22(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn22);
        cambiarEstado(btn,2,2);
    }
    public void verificarTurno(int fila, int columna,int estado){
        boolean ganoPorFila=true;
        boolean ganoPorColumna=true;
        boolean ganoPorDiagonal=true;
        boolean ganoDiagonalPrincipal=true;
        boolean ganoDiagonalSecundaria=true;
        for(int i=0;i<TAMANIO;i++){
            if(malla[fila][i].getEstado()!=estado){
                ganoPorFila=false;
            }
            if(malla[i][columna].getEstado()!=estado){
                ganoPorColumna=false;
            }
            if(malla[i][i].getEstado()!=estado){
                ganoDiagonalPrincipal=false;
            }
            if(malla[i][(TAMANIO-1)-i].getEstado()!=estado){
                ganoDiagonalSecundaria=false;
            }
        }
        if(!ganoDiagonalPrincipal && !ganoDiagonalSecundaria){
            ganoPorDiagonal=false;
        }
        if(ganoPorColumna || ganoPorFila || ganoPorDiagonal){
            txtGanador.setText("Ganador");
            termino = true;
        }
        if(numeroTurnos==9 && !termino){
            txtGanador.setText("Empate");
            termino=true;
        }
    }
}

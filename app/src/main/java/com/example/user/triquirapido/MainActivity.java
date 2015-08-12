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
    public void btn00(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn00);
        if(malla[0][0].getEstado()==Casilla.VACIO){
            if (turno){
                malla[0][0].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(0,0,Casilla.EQUIS);
            }else{
                malla[0][0].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(0,0,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }

    }
    public void btn01(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn01);
        if(malla[0][1].getEstado()==Casilla.VACIO){
            if (turno){
                malla[0][1].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(0,1,Casilla.EQUIS);
            }else{
                malla[0][1].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(0,1,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void btn02(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn02);
        if(malla[0][2].getEstado()==Casilla.VACIO){
            if (turno){
                malla[0][2].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(0,2,Casilla.EQUIS);
            }else{
                malla[0][2].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(0,2,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void btn10(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn10);
        if(malla[1][0].getEstado()==Casilla.VACIO){
            if (turno){
                malla[1][0].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(1,0,Casilla.EQUIS);
            }else{
                malla[1][0].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(1,0,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void btn11(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn11);
        if(malla[1][1].getEstado()==Casilla.VACIO){
            if (turno){
                malla[1][1].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(1,1,Casilla.EQUIS);
            }else{
                malla[1][1].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(1,1,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void btn12(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn12);
        if(malla[1][2].getEstado()==Casilla.VACIO){
            if (turno){
                malla[1][2].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(1,2,Casilla.EQUIS);
            }else{
                malla[1][2].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(1,2,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void btn20(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn20);
        if(malla[2][0].getEstado()==Casilla.VACIO){
            if (turno){
                malla[2][0].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(2,0,Casilla.EQUIS);
            }else{
                malla[2][0].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(2,0,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void btn21(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn21);
        if(malla[2][1].getEstado()==Casilla.VACIO){
            if (turno){
                malla[2][1].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(2,1,Casilla.EQUIS);
            }else{
                malla[2][1].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(2,1,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void btn22(View view){
        ImageButton btn = (ImageButton) findViewById(R.id.btn22);
        if(malla[2][2].getEstado()==Casilla.VACIO){
            if (turno){
                malla[2][2].setEstado(Casilla.EQUIS);
                btn.setImageResource(R.drawable.square256);
                turno = false;
                verificarTurno(2,2,Casilla.EQUIS);
            }else{
                malla[2][2].setEstado(Casilla.CIRCULO);
                btn.setImageResource(R.drawable.circles27);
                turno = true;
                verificarTurno(2,2,Casilla.CIRCULO);
            }
            numeroTurnos++;
        }
    }
    public void verificarTurno(int fila, int columna,int estado){
        boolean vaGanando=true;
        boolean ganoPorFila=true;
        boolean ganoPorColumna=true;
        boolean ganoPorDiagonal=true;
        //logica fila 0
        for(int i=0;i<TAMANIO;i++){
            if(malla[fila][i].getEstado()!=estado){
                ganoPorFila=false;
            }
            if(malla[i][columna].getEstado()!=estado){
                ganoPorColumna=false;
            }
        }

        
        if(ganoPorColumna || ganoPorFila){
            txtGanador.setText("Ganador");
        }else{
        }
    }
}

package com.example.user.triquirapido;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    public static final int TAMANIO = 3;
    public  static final int CIRCLE = R.drawable.minion_1;
    public static  final  int ESQUIS = R.drawable.minion_2;
    public static final int PLY1 = R.drawable.eye1111;
    public static final int PLY2 = R.drawable.eye2222;

    private Jugador jugador1;
    private Jugador jugador2;
    private boolean termino;
    private boolean empate;
    private Casilla[][] malla;
    private ImageButton[][] btnesJuegoRandom;
    private boolean turno;
    private int numeroTurnos;
    private TextView txtJugador2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        boolean player = intent.getBooleanExtra(PlayerActivity.ANDROID,true);
        setContentView(R.layout.activity_main);
        inicio(player);
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
    public void inicio(boolean player){
        jugador1 = new Jugador(false,"Stuart",true);
        txtJugador2 = (TextView) findViewById(R.id.textView2);
        if(player) {
            jugador2 = new Jugador(true, "Android", false);
            txtJugador2.setText(": Android");
        }
        else
            jugador2 = new Jugador(false,"Kevin",false);
        termino = false;
        empate=false;
        turno = true;
        malla = new Casilla[TAMANIO][TAMANIO];
        numeroTurnos = 0;
        inicializarMalla();
        //inicializo matriz btones
        btnesJuegoRandom = new ImageButton[TAMANIO][TAMANIO];

        btnesJuegoRandom[0][0] = (ImageButton) findViewById(R.id.btn00);
        btnesJuegoRandom[0][1] = (ImageButton) findViewById(R.id.btn01);
        btnesJuegoRandom[0][2] = (ImageButton) findViewById(R.id.btn02);

        btnesJuegoRandom[1][0] = (ImageButton) findViewById(R.id.btn10);
        btnesJuegoRandom[1][1] = (ImageButton) findViewById(R.id.btn11);
        btnesJuegoRandom[1][2] = (ImageButton) findViewById(R.id.btn12);

        btnesJuegoRandom[2][0] = (ImageButton) findViewById(R.id.btn20);
        btnesJuegoRandom[2][1] = (ImageButton) findViewById(R.id.btn21);
        btnesJuegoRandom[2][2] = (ImageButton) findViewById(R.id.btn22);
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
                    btn.setImageResource(PLY1);
                    turno = false;
                    verificarTurno(fila, columna, Casilla.EQUIS);
                    if(jugador2.isEsAndroid() && !termino){
                        System.out.println(numeroTurnos);
                        turno = false;
                        int [] posiciones = jugadaRandom();
                        malla[posiciones[0]][posiciones[1]].setEstado(Casilla.CIRCULO);
                        btnesJuegoRandom[posiciones[0]][posiciones[1]].setImageResource(PLY2);
                        turno=true;
                        verificarTurno(posiciones[0],posiciones[1],Casilla.CIRCULO);
                        numeroTurnos++;
                    }
                } else if(!jugador2.isEsAndroid()) {
                    malla[fila][columna].setEstado(Casilla.CIRCULO);
                    btn.setImageResource(PLY2);
                    turno = true;
                    verificarTurno(fila, columna, Casilla.CIRCULO);
                }
            }
        }
    }
    public int[] jugadaRandom(){
        int pos1 =  (int)Math.floor(Math.random()*3);
        int pos2 =  (int)Math.floor(Math.random()*3);
        int[] posiciones = new int[2];
        if(malla[pos1][pos2].getEstado()!=Casilla.VACIO){
            return jugadaRandom();
        }else{
            posiciones[0] = pos1;
            posiciones[1] = pos2;
            return posiciones;
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
          //  txtGanador.setText("Ganador");
            termino = true;
        }
        if(numeroTurnos==9 && !termino){
           // txtGanador.setText("Empate");
            termino=true;
            empate=true;
        }
        String ganador = "";
        if(estado==Casilla.EQUIS){
            ganador=jugador1.getId();
        }else{
            ganador=jugador2.getId();
        }
        if(termino){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String mensaje = "";
            if(!empate)
                mensaje="El Ganador es: " + ganador+"!";
            else
                mensaje="Ha habido un empate!";
            builder.setMessage(mensaje)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent theIntent = new Intent(MainActivity.this,PlayerActivity.class);
                            startActivity(theIntent);
                        }
                    });
            // Create the AlertDialog object and return it
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}

package com.example.user.triquirapido;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class PlayerActivity extends ActionBarActivity {

    public final static String ANDROID = "com.example.user.triquirapido.MESSAGE";

    private ImageButton btnPlayerAndroid;
    private ImageButton btnPlayerManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        btnPlayerAndroid = (ImageButton) findViewById(R.id.btna);
        btnPlayerManual = (ImageButton) findViewById(R.id.btnm);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
    public void btnAndroid(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(ANDROID,true);
        startActivity(intent);
    }
    public void btnManual(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(ANDROID,false);
        startActivity(intent);
    }
}

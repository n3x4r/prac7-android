package com.example.carlosergio.navegadorcorreos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.example.carlosergio.navegadorcorreos.FragmentListado.CorreosListener;



public class MainActivity extends FragmentActivity implements CorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        frgListado.setCorreosListener(this);//se pasa el la referencia a esta activity
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onCorreoSeleccionado(Correo c) {
        FragmentDetalle fgdet = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
        boolean hayDetalle = (fgdet != null && fgdet.isInLayout());

        if (hayDetalle) {
            FragmentDetalle fdetail = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
            fdetail.mostrarDetalle(c.getTexto());
        }
        else {
            Intent newIntet= new Intent(this, DetalleActivity.class);
            newIntet.putExtra(DetalleActivity.EXTRA_TEXTO, c.getTexto());
            startActivity(newIntet);
        }
    }
}


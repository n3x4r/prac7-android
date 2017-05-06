package com.example.carlosergio.navegadorcorreos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by CarloSergio on 03/05/2017.
 */

public class DetalleActivity extends FragmentActivity {

    public static final String EXTRA_TEXTO =
            "cat.udl.eps.fragments.ejmoreflexible.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle detail = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
        detail.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));

    }
}


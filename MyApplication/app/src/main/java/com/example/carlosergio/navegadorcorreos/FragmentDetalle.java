package com.example.carlosergio.navegadorcorreos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by CarloSergio on 03/05/2017.
 */

public class FragmentDetalle extends Fragment {
    TextView txtDetalle;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    public void mostrarDetalle(String texto) {
        txtDetalle = (TextView) getView().findViewById(R.id.TxtDetalle);
        txtDetalle.setText(texto);
    }
}

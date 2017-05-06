package com.example.carlosergio.hello;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by CarloSergio on 03/05/2017.
 */

public class DetailFrag extends Fragment {//fragment

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {//si llega a este metodo sabemos que el onCreate se a realizado sin problemas para acceder a los elelmentos de la activity o el fragment
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        return view;
    }

    public void showText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.captain);
        view.setText(item);
    }
}


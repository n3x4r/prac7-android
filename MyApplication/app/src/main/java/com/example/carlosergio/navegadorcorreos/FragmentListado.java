package com.example.carlosergio.navegadorcorreos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by CarloSergio on 03/05/2017.
 */

public class FragmentListado extends Fragment {// liberar a este fragment de que sepa la existencia del otro fragment

    private Correo[] datos =
            new Correo[]{
                    new Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"),
                    new Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"),
                    new Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"),
                    new Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"),
                    new Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5")};

    private ListView lstListado;

    private CorreosListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        lstListado = (ListView)getView().findViewById(R.id.LstListado);

        lstListado.setAdapter(new AdaptadorCorreos(this));

        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
                if(listener!=null){
                    listener.onCorreoSeleccionado((Correo)lstListado.getAdapter().getItem(pos));//se le pasa item
                }
            }

        });
    }


    @Override //primero metodo de ciclo de vida de un fragment es on Attach
    public void onAttach(Context context) {//sirve para comprobar que la activity este implementando tu listener para poder usar el fragment
        super.onAttach(context);
        try {
            listener = (CorreosListener) context;//el context es la hostactivity que usa el fragment esta en el xml
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnCorreosListener");
        }
    }

    public interface CorreosListener {
        void onCorreoSeleccionado(Correo c);
    }

    public void setCorreosListener(CorreosListener listener) {
        this.listener = listener;

    }

    class AdaptadorCorreos extends ArrayAdapter<Correo> {

        Activity context;

        AdaptadorCorreos(FragmentListado fragmentListado) {
            
            super(fragmentListado.getActivity(), R.layout.listitem_correo, datos);
            this.context = fragmentListado.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_correo, null);

            TextView lblDe = (TextView)item.findViewById(R.id.LblDe);
            lblDe.setText(datos[position].getDe());

            TextView lblAsunto = (TextView)item.findViewById(R.id.LblAsunto);
            lblAsunto.setText(datos[position].getAsunto());

            return(item);
        }
    }


}


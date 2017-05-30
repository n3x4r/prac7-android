package com.example.carlosergio.navegadorcorreos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private AdaptadorCorreos adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        lstListado = (ListView)getView().findViewById(R.id.LstListado);

        registerForContextMenu(lstListado); // registar el list view

        adapter = new AdaptadorCorreos(this);

        lstListado.setAdapter(adapter);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.main, menu);
    }

    //# all new ========================================================
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch(item.getItemId()){
            case R.id.mc1:
                makeToast(getString(R.string.menu_conceptual1));
                return true;
            case R.id.mc2:
                LinearLayout linearL =(LinearLayout) info.targetView; // get the reference to the linear layout
                TextView texto = (TextView) linearL.findViewById(R.id.LblAsunto); //obten de data
                makeToast(texto.getText().toString());
                return true;
            case R.id.uppercase:
                Correo email = ((Correo)lstListado.getAdapter().getItem(info.position));
                email.setDe(email.getDe().toUpperCase());
                adapter.notifyDataSetChanged();
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void makeToast(String m){
        Toast.makeText(getActivity(), m , Toast.LENGTH_LONG).show();

    }




    //intento de eleiminar


    //List<Correo> list = new ArrayList<Correo>(Arrays.asList(datos));
    //makeToast(list.size()+"");
    //list.remove(1);
    //adapter.notifyDataSetChanged();
    // makeToast(list.size()+"");
    //datos = list.toArray(datos);

    //datos = list.toArray(datos);
    //datos.
    //adapter.remove(o);
    //adapter.remove(adapter.getItem(info.position));

                /*datos =
                        new Correo[]{
                                new Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"),
                                new Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"),
                                new Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"),
                                new Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5")};
                */

}


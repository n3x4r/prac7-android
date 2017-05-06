package com.example.carlosergio.hello;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by CarloSergio on 03/05/2017.
 */

public class ListFrag extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }//no se infla aqui porque todavia no se ha creado la view

    @Override
    public void onActivityCreated(Bundle savedInstanceState) { //listFragment no se necesita redefinir el oncreateView porque extiende de listFragment
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[] { "Enterprise", "Star Trek", "Next Generation", "Deep Space 9", "Voyager"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);//getAcitivty es para obtener el acitivity porque estamso en un fragment
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position); //Get the ListAdapter associated with this fragment's ListView.
        DetailFrag frag = (DetailFrag) getFragmentManager().findFragmentById(R.id.frag_capt);
        if (frag != null && frag.isInLayout()) { // en el caso que sea bipanel que este la de detalle
            frag.showText(getCapt(item));
        }else{
            Intent newIntent= new Intent(getActivity(), DetailActivity.class);
            newIntent.putExtra("name", getCapt(item));//item the position of the item
            startActivity(newIntent);
        }
    }

    private String getCapt(String ship) {
        if (ship.toLowerCase().contains("enterprise")) {
            return "Johnathan Archer";
        }
        if (ship.toLowerCase().contains("star trek")) {
            return "James T. Kirk";
        }
        if (ship.toLowerCase().contains("next generation")) {
            return "Jean-Luc Picard";
        }
        if (ship.toLowerCase().contains("deep space 9")) {
            return "Benjamin Sisko";
        }
        if (ship.toLowerCase().contains("voyager")) {
            return "Kathryn Janeway";
        }
        return "???";
    }
}


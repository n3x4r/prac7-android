package com.example.carlosergio.hello;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by CarloSergio on 03/05/2017.
 */

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String name = getIntent().getStringExtra("name");
        DetailFrag detail = (DetailFrag)getFragmentManager().findFragmentById(R.id.frag_capt);//manejador de fragmentes y se obtine el fragment
        detail.showText(name);

    }
}


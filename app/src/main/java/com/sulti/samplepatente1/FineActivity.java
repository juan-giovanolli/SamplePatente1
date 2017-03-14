package com.sulti.samplepatente1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sulti.samplepatente1.model.Fine;

import java.util.Date;
import java.util.Vector;

public class FineActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine);
        Vector<Fine> list = new Vector();
        if (getIntent().getStringExtra("Plate").equals("XX015GA")) {
            list.add(new Fine(new Date(), 1000l, "Exceso de velocidad"));
            list.add(new Fine(new Date(), 500l, "Luces bajas apagadas"));
        }
        setListAdapter(new FineAdapter(list, this));
    }
}

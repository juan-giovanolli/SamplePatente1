package com.sulti.samplepatente1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sulti.samplepatente1.model.Tax;

import java.util.Date;
import java.util.Vector;

public class TaxActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);
        Vector<Tax> list = new Vector();
        if (getIntent().getStringExtra("Plate").equals("XX000YB")) {
            list.add(new Tax(new Date(), 1000l, "MAR2015"));
            list.add(new Tax(new Date(), 2000l, "ENE2015"));
        }


        setListAdapter(new TaxAdapter(list, this));
    }
}

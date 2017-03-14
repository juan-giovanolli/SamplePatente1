package com.sulti.samplepatente1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sulti.samplepatente1.model.Tax;

import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Created by juanj on 19/2/2017.
 */

public class TaxAdapter extends BaseAdapter {
    private Vector list;
    private Activity activity;

    public TaxAdapter(Vector list, Activity activity) {
        super();
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.elementAt(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tax elem = (Tax) list.elementAt(position);
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_tax_item, null, true);
        TextView date_lbl =(TextView)view.findViewById(R.id.date_lbl);
        date_lbl.setText(new SimpleDateFormat("dd/MMM/yyyy").format(elem.getDate()));
        TextView amount_lbl =(TextView)view.findViewById(R.id.amount_lbl);
        amount_lbl.setText(elem.getAmount().toString());
        TextView description_lbl =(TextView)view.findViewById(R.id.description_lbl);
        description_lbl.setText(elem.getDescription());

        return view;
    }
}

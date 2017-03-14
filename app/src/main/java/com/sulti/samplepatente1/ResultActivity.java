package com.sulti.samplepatente1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ResultActivity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        FloatingActionButton sendBtn = (FloatingActionButton) findViewById(R.id.send_btn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Notificacion enviada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fineBtn = (FloatingActionButton) findViewById(R.id.fine_btn);
        fineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fineActivity = new Intent(context, FineActivity.class);
                fineActivity.putExtra("Plate", getIntent().getStringExtra("Plate"));
                startActivity(fineActivity);
            }
        });

        FloatingActionButton taxBtn = (FloatingActionButton) findViewById(R.id.tax_btn);
        taxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taxActivity = new Intent(context, TaxActivity.class);
                taxActivity.putExtra("Plate", getIntent().getStringExtra("Plate"));
                startActivity(taxActivity);
            }
        });

        Intent intent = getIntent();
        String plate = intent.getStringExtra("Plate");
        TextView carData = (TextView) findViewById(R.id.car_data);
        TextView ownerData = (TextView) findViewById(R.id.owner_data);
        String fnev = plate;
        int pos = plate.indexOf(";");
        if (pos > -1)
        {
            fnev = plate.substring(0, pos);
        }
        String name = "/sdcard/sdk/example/images/" + fnev + ".jpg";	// photo file on the SD card
        Bitmap bitmap = BitmapFactory.decodeFile(name);
        if (bitmap != null)
        {
            ImageView imageView = (ImageView)findViewById(R.id.car_picture);
            imageView.setImageBitmap(bitmap);
        }
        switch(plate) {
            case "XX056MJ": {
                carData.setText(getString(R.string.car_data_XX056MJ));
                ownerData.setText(getString(R.string.owner_data_XX056MJ));
                toolbarLayout.setBackgroundColor(Color.GREEN);
                this.setTitle(getString(R.string.title_activity_result_ok));
                break;
            }
            case "XX000YB": {
                carData.setText(getString(R.string.car_data_XX000YB));
                ownerData.setText(getString(R.string.owner_data_XX000YB));
                toolbarLayout.setBackgroundColor(Color.RED);
                this.setTitle(getString(R.string.title_activity_result_fail_rentas));
                break;
            }
            case "XX015GA": {
                carData.setText(getString(R.string.car_data_XX015GA));
                ownerData.setText(getString(R.string.owner_data_XX015GA));
                toolbarLayout.setBackgroundColor(Color.RED);
                this.setTitle(getString(R.string.title_activity_result_fail_multas));
                break;
            }
            default: {
                toolbarLayout.setBackgroundColor(Color.GRAY);
                this.setTitle(getString(R.string.title_activity_result_fail_no_data));
            }
        }
    }
}

package com.sulti.samplepatente1;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static int ANPR_REQUEST = 1;	// Identifier of our calling

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Inspector Digital");

        Button button = (Button) findViewById(R.id.Button_Main_StartAnpr);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.Button_Main_StartAnpr)
        {


            Intent intent = new Intent("android.intent.action.SEND");	// set intent to call ANPR SDK
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setComponent(new ComponentName("com.birdorg.anpr.sdk.simple.camera", "com.birdorg.anpr.sdk.simple.camera.ANPRSimpleCameraSDK"));



            ///////////////////////////////////////////////// setup the parameters //////////////////

            intent.putExtra("Orientation", "portrait");	// portrait orientation

            intent.putExtra("FullScreen", false);	// not fullscreen (with titlebar)

            intent.putExtra("TitleText", "Scanner de Patentes");	// text on titlebar

            intent.putExtra("IndicatorVisible", true);	// ANPR indicator (litle cirle) will shown

            intent.putExtra("MaxRecognizeNumber", 1);	// infinite recogzing

            intent.putExtra("DelayAfterRecognize", 3000);	// recognized string will displayed until 3 secundum

            intent.putExtra("SoundEnable", true);	// sound will be hearing when recognized

            intent.putExtra("ResolutionSettingByUserEnable", true);	// allows user to change camera resolution

            intent.putExtra("ResolutionSettingDialogText", "Camera resolution:");	// title of the resolution setting dialog

//		    intent.putExtra("ResolutionWidth", 640);	// camera resolution x
//		    intent.putExtra("ResolutionHeight", 480);	// camera resolution y

            intent.putExtra("ResultTextColor", Color.GREEN); // color of the display of recognized string

            intent.putExtra("ListEnable", true);	// recognized strings displayed in list

            intent.putExtra("ListMaxItems", 5);	// max 5 items in list

            intent.putExtra("ListTextColor", 0xff7070f0);	// color of the list

            intent.putExtra("ListTitle", "Lasts:");	// title of the list

            intent.putExtra("ListDeletable", true);	// allow to delete string from list

            intent.putExtra("ListDeleteDialogMessage", "Are you sure to delete: ");	// message in delete dialog

            intent.putExtra("ListDeleteDialogYesButtonText", "Yes");	// text of yes button

            intent.putExtra("ListDeleteDialogNoButtonText", "No");	// text of no button

            intent.putExtra("ImageSaveDirectory", "/sdcard/sdk/example/images/");	// pictures will be saved in this directory

            intent.putExtra("CheckServiceClass", "com.birdorg.anpr.sdk.simple.camera.example.AnprSdkExampleCheckingService");	// every NumberPlate will be checked in this service


            try
            {
                startActivityForResult(intent, ANPR_REQUEST);	// call ANPR app with intent
            }
            catch (ActivityNotFoundException e)		// if ANPR intent not found (not installed)
            {
                Toast toast = Toast.makeText(context, "The ANPR not installed!", Toast.LENGTH_LONG);
                toast.show();
            }

        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)	// this called when ANPR app finished
    {
        if (requestCode == ANPR_REQUEST)	// ANPR app id
        {
            if (resultCode == RESULT_OK)	// if ANPR app terminated normally
            {
                Bundle b = data.getExtras();	// result of ANPR app  (a Bundle var)
                if (b != null)
                {
                    String error = b.getString("Errors");	// in bundle the recognized string
                    String s = b.getString("PlateNums");	// in bundle the error string
                    if (s != null)
                    {
                        Intent resultActivity = new Intent(this, ResultActivity.class);
                        resultActivity.putExtra("Plate", s);
                        startActivity(resultActivity);
                    }
                }
            }
            else
            {
                TextView text = (TextView) findViewById(R.id.Text_Main_Result);
                text.setText("---");
            }
        }
    }
}

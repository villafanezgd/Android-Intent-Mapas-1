package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String longitude = "-58.599049";
        String latitude = "-34.739775";
        String url = "waze://?ll=" + latitude + ", " + longitude + "&navigate=yes";
        Intent intentWaze = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        String uriGoogle = "google.navigation:q=" + latitude + "," + longitude;
        Intent intentGoogleNav = new Intent(Intent.ACTION_VIEW, Uri.parse(uriGoogle));

        intentGoogleNav.setPackage("com.google.android.apps.maps");
        Intent chooserIntent = Intent.createChooser(intentGoogleNav, "Seleccione Aplicacion");
        Intent[] arr = new Intent[1];
        arr[0] = intentWaze;
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arr);
        startActivity(chooserIntent);




    }
}

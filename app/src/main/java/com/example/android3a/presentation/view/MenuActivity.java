package com.example.android3a.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

import com.example.android3a.R;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button_global;
    Button button_ListOfCountries;
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);


        Spinner spin = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        button_global = findViewById(R.id.button_global);
        button_global.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), globalFigures.class);

                startActivity(intent);
            }
        });

        button_ListOfCountries = findViewById(R.id.button_listOfCountries);
        button_ListOfCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), covidActivity2.class);
                startActivity(intent);
            }
        });

        videoView = findViewById(R.id.videoView);

        String videoPath = "android.resource://"+getPackageName()+"/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        if (parent.getItemAtPosition(position).equals("Global")) {
            intent = new Intent(getApplicationContext(), globalFigures.class);
            startActivity(intent);
            finish();
        } else if (parent.getItemAtPosition(position).equals("Countries")) {
            intent = new Intent(getApplicationContext(), covidActivity2.class);
            startActivity(intent);
            finish();
        } else if (parent.getItemAtPosition(position).equals("Useful links")) {
            intent = new Intent(getApplicationContext(), LinksActivity.class);
            startActivity(intent);
            finish();
        } else if (parent.getItemAtPosition(position).equals("About the app")) {
            intent = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(intent);
            finish();
        } else if (parent.getItemAtPosition(position).equals("Memes")) {
            intent = new Intent(getApplicationContext(), MemeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

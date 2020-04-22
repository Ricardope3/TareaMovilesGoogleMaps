package com.example.googlemapstarea;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText lat1 = findViewById(R.id.lat1);
                EditText lng1 = findViewById(R.id.lng1);
                Ubicacion ubi1 = new Ubicacion(Double.parseDouble(lat1.getText().toString()),Double.parseDouble(lng1.getText().toString()));
                EditText lat2 = findViewById(R.id.lat2);
                EditText lng2 = findViewById(R.id.lng2);
                Ubicacion ubi2 = new Ubicacion(Double.parseDouble(lat2.getText().toString()),Double.parseDouble(lng2.getText().toString()));

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("ubicacion1",ubi1);
                intent.putExtra("ubicacion2",ubi2);
                startActivity(intent);
            }
        });
    }

}

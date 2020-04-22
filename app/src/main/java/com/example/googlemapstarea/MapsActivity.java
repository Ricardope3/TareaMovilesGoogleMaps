package com.example.googlemapstarea;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.Serializable;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Ubicacion ubi1;
    Ubicacion ubi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent intent = getIntent();
        ubi1 = (Ubicacion) intent.getSerializableExtra("ubicacion1");
        ubi2 = (Ubicacion) intent.getSerializableExtra("ubicacion2");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng latLng1 = new LatLng(ubi1.lat, ubi1.lng);
        LatLng latLng2 = new LatLng(ubi2.lat, ubi2.lng);

        mMap.addMarker(new MarkerOptions().position(latLng1).title("Ubicacion 1"));
        mMap.addMarker(new MarkerOptions().position(latLng2).title("Ubicacion 2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng1));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng1, 7);
        googleMap.animateCamera(cameraUpdate);
        googleMap.addPolyline(new PolylineOptions().add(latLng1, latLng2).width(10).color(Color.BLUE).geodesic(true));
    }
}

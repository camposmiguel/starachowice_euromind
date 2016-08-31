package com.miguelcr.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng starachowice, sevilla;

    // Starachowice: 51.054469,21.063144
    // Sevilla: 37.380331,-6.006904

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        starachowice = new LatLng(51.054469,21.063144);
        sevilla = new LatLng(37.380331,-6.006904);

        // Starachowice's marker
        mMap.addMarker(new MarkerOptions()
                .position(starachowice)
                .title("Marker in Zespoł Skzoł, Starchowice, Poland")
                .snippet("Lat: 51.054698, Lon: 21.063251"));

        // Sevilla's marker
        mMap.addMarker(new MarkerOptions()
                .position(sevilla)
                .title("Marker in Sevilla, Spain")
                .snippet("Lat: 37.380331, Lon: -6.006904"));


        // Instantiates a new Polyline object and adds points to define a rectangle
        PolylineOptions rectOptions = new PolylineOptions()
                .add(sevilla)
                .add(starachowice)
                .width(10)
                .color(ContextCompat.getColor(this,android.R.color.holo_blue_light));

        // Get back the mutable Polyline
        Polyline polyline = mMap.addPolyline(rectOptions);


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(starachowice,4));


        
    }
}

package com.miguelcr.maps;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;

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

        // Add a marker in Sydney and move the camera
        LatLng starachowice = new LatLng(51.054698,21.063251);
        mMap.addMarker(new MarkerOptions()
                .position(starachowice)
                .title("Marker in Zespoł Skzoł, Starchowice, Poland")
                .snippet("Lat: 51.054698, Lon: 21.063251"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(starachowice,15));

        mMap.setOnMapClickListener(this);
        
    }

    @Override
    public void onMapClick(LatLng latLng) {
        Marker newMarker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Marker in position clicked")
                .snippet("Lat: "+latLng.latitude+" Lon: "+latLng.longitude)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flag)));

        newMarker.showInfoWindow();

    }


}

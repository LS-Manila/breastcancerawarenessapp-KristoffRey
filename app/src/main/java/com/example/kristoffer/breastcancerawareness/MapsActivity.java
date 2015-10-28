package com.example.kristoffer.breastcancerawareness;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
        mMap.setMyLocationEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng Breast_Clinic = new LatLng(14.589315, 121.069306);
        LatLng SLHM = new LatLng(14.248636, 121.067274);
        LatLng SHM = new LatLng(14.287002, 121.095532);
        mMap.addMarker(new MarkerOptions().position(Breast_Clinic).title("The Medical City - Breast Clinic").snippet("Contact: 0917 327 2004"));
        mMap.addMarker(new MarkerOptions().position(SLHM).title("Southern Luzon Hospital and Medical Center").snippet("Contact: (032) 584 4105"));
        mMap.addMarker(new MarkerOptions().position(SHM).title("Sta. Rosa Hospital and Medical Center").snippet("Contact: (049) 520 8421"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SLHM));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
    }
}

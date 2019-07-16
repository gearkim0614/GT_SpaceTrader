package com.example.gttrader.View;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.util.Log;

import android.os.Bundle;
import android.widget.Toast;

import com.example.gttrader.Entity.Building;
import com.example.gttrader.Entity.Universe;
import com.example.gttrader.Entity.Player;
import com.example.gttrader.R;
import com.example.gttrader.ViewModel.TravelViewModel;
import com.example.gttrader.ViewModel.ConfigurationViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Marker;

//API Key: AIzaSyDCe70F3e0YF1HxZsh3LbV1WHhdbEicxpw

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private Universe universe = Universe.getUniverse();

    private GoogleMap mMap;

    private TravelViewModel travelViewModel = new TravelViewModel();

    private ConfigurationViewModel configurationViewModel = new ConfigurationViewModel();

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
        LatLng CoC = new LatLng(33.7774, -84.3973);
        //mMap.addMarker(new MarkerOptions().position(CoC).title("Marker in CoC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CoC, 15));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(CoC));


        for (Building location: Building.values()) {


            Log.i("TAG", "WATCHME");
            Log.i("TAG!!", location.getName());
            LatLng marker = new LatLng(location.getLatitude(), location.getLongitude());
            Marker marker1 = mMap.addMarker(new MarkerOptions().position(marker).title(location.getName()));
//            mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title(location.getName())).showInfoWindow();
            marker1.setTag(location.getName());
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
//                universe.getPlayer().setNextLocation();
                if (travelViewModel.isHappening()) {

                    Intent intent = new Intent(getApplicationContext(), TravelActivity.class);
                    intent.putExtra("nameOfPlace", marker.getTag().toString());
                    startActivity(intent);
//                    Toast.makeText(getApplicationContext(), "You trigger " + travelViewModel.randomEventGetter()
//                            + " event! Your lost some credits and your current credit is + "
//                            + configurationViewModel.robbed() + " credits.", Toast.LENGTH_LONG).show();
                    if (travelViewModel.randomEventGetter().equals("ROBBERY")) {//robbery event is triggered
                        Toast.makeText(getApplicationContext(), "You trigger " + travelViewModel.randomEventGetter()
                                + " event! Your lost some credits and your current credit is + "
                                + configurationViewModel.robbed() + " credits.", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "You trigger " + travelViewModel.randomEventGetter()
                                + " event! Your lost some credits and your current credit is + "
                                + configurationViewModel.robbed() + " credits.", Toast.LENGTH_LONG).show();
                    }
//                    else if (travelViewModel.randomEventGetter().euqlas("RAIN")) {
//                        System.out.println();
//                    }
                  //  configurationViewModel.robbed();
                }
                    //Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_LONG).show();//////***********
                    Intent intent = new Intent(getApplicationContext(), TravelActivity.class);
                    intent.putExtra("nameOfPlace", marker.getTag().toString());
                    startActivity(intent);

                return false;
            }
        });

    }
}

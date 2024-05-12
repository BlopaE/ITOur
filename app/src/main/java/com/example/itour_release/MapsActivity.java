package com.example.itour_release;

import static com.example.itour_release.MainActivity.PERMISSIONS_FINE_LOCATION;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.itour_release.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.search.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private View mapView;
    private final float DEFAULT_ZOOM = 15;
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    String nDestino;
    LatLng savedLocation;
    FusedLocationProviderClient fusedLocationProviderClient, mFusedLocationProviderClient;
    Location currentLocation, mLastKnownLocation;

    SearchView searchView;
    LocationCallback locationCallback;
    FloatingActionButton fAB;
    MyApplication aplicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fAB = findViewById(R.id.btn_ito);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        aplicacion = (MyApplication) getApplicationContext();

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
    private void updateGPS() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MapsActivity.this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    currentLocation = location;
                }
            });
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_FINE_LOCATION);
            }
        }
    }
    public void Buscar(View view){
        Intent intent = new Intent(getApplicationContext(),Resultados.class);
        startActivity(intent);
    }

    //Metodo para abrir activity de eventos
    public void Eventos(View view){
        Intent intent = new Intent(getApplicationContext(), Eventos.class);
        startActivity(intent);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng EA = new LatLng(17.078413,-96.745638);
        LatLng EB = new LatLng(17.078253,-96.744824);
        LatLng EC = new LatLng(17.0780357,-96.744878);
        LatLng ED= new LatLng(17.077242, -96.743530);
        LatLng EE = new LatLng(17.076978, -96.744072);
        LatLng EElec = new LatLng(17.078679,-96.743775);
        LatLng EF = new LatLng(17.076693, -96.744116);
        LatLng EG = new LatLng(17.076471, -96.744178);
        LatLng EI=new LatLng(17.0760628,-96.7447535);
        LatLng EJ = new LatLng(17.0762137,-96.74452380);
        LatLng EL = new LatLng(17.078134,-96.744110);
        LatLng Gym =new LatLng(17.077692,-96.743639);
        LatLng Bib = new LatLng(17.077711,-96.744199);
        LatLng LabE1= new LatLng(17.079001, -96.744982);
        LatLng LabS2 = new LatLng(17.079258, -96.744811);
        LatLng LabQ3= new LatLng(17.078576,-96.744589);
        LatLng LabM4= new LatLng(17.078721,-96.744533);
        LatLng LabQ5 = new LatLng(17.077990,-96.744427);
        LatLng LabC6 = new LatLng(17.078653,-96.7443106);
        LatLng Lab7CC= new LatLng(17.079082,-96.744324);
        LatLng LabQ8 = new LatLng(17.079408, -96.743909);
        LatLng LabE9 = new LatLng(17.078784,-96.743807);
        LatLng STitulacion= new LatLng(17.078233,-96.745259);
        LatLng cafe_izq= new LatLng(17.077187, -96.744013);
        LatLng P1= new LatLng(17.077804, -96.746049);
        LatLng P2= new LatLng(17.075941, -96.744244);
        LatLng P3= new LatLng(17.076591, -96.745322);
        LatLng cafe_der= new LatLng(17.077209,-96.7440196);

        mMap = googleMap;
        MarkerOptions mO2 = new MarkerOptions();
        /*
        Marker marker = mMap.addMarker(new MarkerOptions().position(EA).title("Edificio A"));
        marker.setVisible(true);
        marker.showInfoWindow();
        */

        mO2.position(EA);
        mO2.title("Edificio A");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.school));
        mMap.addMarker(mO2);

        mO2.position(EB);
        mO2.title("Edificio B");
        mMap.addMarker(mO2);

        mO2.position(EC);
        mO2.title("Edificio C");
        mMap.addMarker(mO2);

        mO2.position(ED);
        mO2.title("Edificio D");
        mMap.addMarker(mO2);

        mO2.position(EE);
        mO2.title("Edificio E");
        mMap.addMarker(mO2);

        mO2.position(EElec);
        mO2.title("Edificio Electronica");
        mMap.addMarker(mO2);

        mO2.position(EF);
        mO2.title("Edificio F");
        mMap.addMarker(mO2);

        mO2.position(EG);
        mO2.title("Edificio G");
        mMap.addMarker(mO2);

        mO2.position(EI);
        mO2.title("Edificio I");
        mMap.addMarker(mO2);


        mO2.position(EJ);
        mO2.title("Edificio J");
        mMap.addMarker(mO2);

        mO2.position(EL);
        mO2.title("Edificio L");
        mMap.addMarker(mO2);

        //OTROS DEPARTAMENTOS:
        mO2.position(Gym);
        mO2.title("Gimnacio ITO");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.dumbbell));
        mMap.addMarker(mO2);

        mO2.position(Bib);
        mO2.title("Centro de Información - Biblioteca");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.book));
        mMap.addMarker(mO2);

        mO2.position(LabE1);
        mO2.title("Laboratorio 1: Ing.Electronica");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.tube));
        mMap.addMarker(mO2);

        mO2.position(LabS2);
        mO2.title("Laboratorio 2: Simulación");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.pc));
        mMap.addMarker(mO2);

        mO2.position(LabQ3);
        mO2.title("Laboratorio 3: Ing. Quimica");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.tube));
        mMap.addMarker(mO2);

        mO2.position(LabM4);
        mO2.title("Laboratorio 4: Ing. Mecánica");
        mMap.addMarker(mO2);

        mO2.position(LabQ5);
        mO2.title("Laboratorio 5: Ing. Quimica");
        mMap.addMarker(mO2);

        mO2.position(LabC6);
        mO2.title("Laboratorio 6: Ing. Civil");
        mMap.addMarker(mO2);

        mO2.position(Lab7CC);
        mO2.title("Centro de Cómputo: Laboratorio 7");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.pc));
        mMap.addMarker(mO2);

        mO2.position(LabQ8);
        mO2.title("Laboratorio 8: Ing. Química");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.tube));
        mMap.addMarker(mO2);

        mO2.position(LabE9);
        mO2.title("Laboratorio 9: Ing. Electrónica");
        mMap.addMarker(mO2);

        mO2.position(STitulacion);
        mO2.title("Sala de Titulación");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.hat));
        mMap.addMarker(mO2);

        mO2.position(cafe_izq);
        mO2.title("Cafeteria");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.cafe));
        mMap.addMarker(mO2);

        mO2.position(P1);
        mO2.title("Estacionamiento 1");
        mO2.icon(BitmapDescriptorFactory.fromResource(R.drawable.park));
        mMap.addMarker(mO2);

        mO2.position(P2);
        mO2.title("Estacionamiento 2");
        mMap.addMarker(mO2);

        mO2.position(P3);
        mO2.title("Estacionamiento 1");
        mMap.addMarker(mO2);

        if(aplicacion.getMiDestino().longitude==0.0){
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bib, 18.0f));

        }else{
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(aplicacion.getMiDestino(), 19.0f));
            MarkerOptions markerOptions=new MarkerOptions();
            markerOptions.position(aplicacion.getMiDestino());
            markerOptions.title("Marcador Destino");
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador));
            markerOptions.zIndex(0.0f);
            mMap.addMarker(markerOptions).showInfoWindow();
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                aplicacion.setMiDestino(marker.getPosition());
                aplicacion.setnDestino(marker.getTitle());
                Intent intent = new Intent(getApplicationContext(),PopActivity.class);
                startActivity(intent);
                return false;
            }
        });
        fAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Bib, 17.0f));
            }
        });

        //FIN MI CODIGO
        if (mapView != null && mapView.findViewById(Integer.parseInt("1")) != null) {
            View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            layoutParams.setMargins(0, 0, 30, 30);
        }
        //Map Settings
        mMap.setMapType(1); //2 es satelite
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);






        //DARK MODE
        int nightModeFlags =
                this.getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                mMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                this, R.raw.night));
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                mMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                this, R.raw.day));
                break;

            case Configuration.UI_MODE_NIGHT_UNDEFINED:

                break;
        }



    }

    @SuppressLint("MissingPermission")
    private void getDeviceLocation() {
        mFusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if (task.isSuccessful()) {
                            mLastKnownLocation = task.getResult();
                            if (mLastKnownLocation != null) {
                                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                            } else {
                                final LocationRequest locationRequest = LocationRequest.create();
                                locationRequest.setInterval(10000);
                                locationRequest.setFastestInterval(5000);
                                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                                locationCallback = new LocationCallback() {
                                    @Override
                                    public void onLocationResult(LocationResult locationResult) {
                                        super.onLocationResult(locationResult);
                                        if (locationResult == null) {
                                            return;
                                        }
                                        mLastKnownLocation = locationResult.getLastLocation();
                                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
                                        mFusedLocationProviderClient.removeLocationUpdates(locationCallback);
                                    }
                                };
                                mFusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);

                            }
                        } else {
                            Toast.makeText(MapsActivity.this, "unable to get last location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
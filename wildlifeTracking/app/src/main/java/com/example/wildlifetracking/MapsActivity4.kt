package com.example.wildlifetracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.wildlifetracking.databinding.ActivityMaps4Binding

class MapsActivity4 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaps4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val Deer1   = LatLng(27.363408, 84.900864)
        val Deer2   = LatLng(27.351868, 84.898414)
        val Deer3   = LatLng(27.377990, 84.842132)
        val Deer4   = LatLng(27.393578, 84.815210)
        val Deer5   = LatLng(27.288943, 84.917841)
        val Deer6   = LatLng(27.273296, 84.932963)

        mMap.addMarker(MarkerOptions().position(Deer1 ).title("Deer1"))
        mMap.addMarker(MarkerOptions().position(Deer2  ).title("Deer2 "))
        mMap.addMarker(MarkerOptions().position(Deer3  ).title("Deer3 "))
        mMap.addMarker(MarkerOptions().position(Deer4  ).title("Deer4 "))
        mMap.addMarker(MarkerOptions().position(Deer5  ).title("Deer5 "))
        mMap.addMarker(MarkerOptions().position(Deer6  ).title("Deer6 "))


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Deer1, 10.0f))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Deer2 ))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Deer3 ))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Deer4 ))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Deer5 ))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Deer6 ))
    }
}
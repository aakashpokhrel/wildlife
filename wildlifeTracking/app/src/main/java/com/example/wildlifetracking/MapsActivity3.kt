package com.example.wildlifetracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.wildlifetracking.databinding.ActivityMaps3Binding

class MapsActivity3 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaps3Binding.inflate(layoutInflater)
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

        val Tiger1  = LatLng(28.435108, 81.446805)
        val Tiger2  = LatLng(28.441888, 81.446807)
        val Tiger3  = LatLng(28.450195, 81.428302)
        val Tiger4  = LatLng(28.441719, 81.431579)
        val Tiger5  = LatLng(28.456461, 81.469175)
        val Tiger6  = LatLng(28.431548, 81.403245)

        mMap.addMarker(MarkerOptions().position(Tiger1 ).title("Tiger1"))
        mMap.addMarker(MarkerOptions().position(Tiger2 ).title("Tiger2"))
        mMap.addMarker(MarkerOptions().position(Tiger3 ).title("Tiger3"))
        mMap.addMarker(MarkerOptions().position(Tiger4 ).title("Tiger4"))
        mMap.addMarker(MarkerOptions().position(Tiger5 ).title("Tiger5"))
        mMap.addMarker(MarkerOptions().position(Tiger6 ).title("Tiger6"))


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Tiger1, 10.0f))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tiger2))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tiger3))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tiger4))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tiger5))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tiger6))
    }
}
package com.example.wildlifetracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.wildlifetracking.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
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

        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
        val elephant1 = LatLng(26.625457, 86.953231)
        val elephant2 = LatLng(26.622696, 86.939328)
        val elephant3 = LatLng(26.600702, 86.943629)
        val elephant4 = LatLng(26.601194, 86.954383)
        val elephant5 = LatLng(26.597087, 86.939676)
        val elephant6 = LatLng(26.604730, 86.922030)


        mMap.addMarker(MarkerOptions().position(elephant1).title("Elephant1"))
        mMap.addMarker(MarkerOptions().position(elephant2).title("Elephant2"))
        mMap.addMarker(MarkerOptions().position(elephant3).title("Elephant3"))
        mMap.addMarker(MarkerOptions().position(elephant4).title("Elephant4"))
        mMap.addMarker(MarkerOptions().position(elephant5).title("Elephant5"))
        mMap.addMarker(MarkerOptions().position(elephant6).title("Elephant6"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(elephant1, 10.0f))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(elephant2))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(elephant3))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(elephant4))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(elephant5))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(elephant6))
    }
}
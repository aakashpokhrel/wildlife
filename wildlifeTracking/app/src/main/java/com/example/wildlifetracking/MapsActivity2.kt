package com.example.wildlifetracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.wildlifetracking.databinding.ActivityMaps2Binding

class MapsActivity2 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaps2Binding.inflate(layoutInflater)
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

        val Rhino1 = LatLng(27.511757, 84.386941)
        val Rhino2 = LatLng(27.516270, 84.537531)
        val Rhino3 = LatLng(27.507639, 84.538313)
        val Rhino4 = LatLng(27.517992, 84.422744)
        val Rhino5 = LatLng(27.526707, 84.482367)
        val Rhino6 = LatLng(27.526709, 84.499521)


        mMap.addMarker(MarkerOptions().position(Rhino1).title("Rhino1"))
        mMap.addMarker(MarkerOptions().position(Rhino2).title("Rhino2"))
        mMap.addMarker(MarkerOptions().position(Rhino3).title("Rhino3"))
        mMap.addMarker(MarkerOptions().position(Rhino4).title("Rhino4"))
        mMap.addMarker(MarkerOptions().position(Rhino5).title("Rhino5"))
        mMap.addMarker(MarkerOptions().position(Rhino6).title("Rhino6"))


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rhino1, 10.0f))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rhino2))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rhino3))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rhino4))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rhino5))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rhino6))
    }
}
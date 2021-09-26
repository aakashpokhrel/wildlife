package com.example.wildlifetracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.wildlifetracking.databinding.ActivityKoshiTapuBinding

class KoshiTapu : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    val Elephant = LatLng(26.625457, 86.953231)
    val Deer = LatLng(26.622696, 86.939328)
    val WildBuffalo = LatLng(26.600702, 86.943629)
    val Tiger = LatLng(26.601194, 86.954383)


    private var locationArrayList: ArrayList<LatLng>? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koshi_tapu)

        val map = supportFragmentManager
            .findFragmentById(R.id.myMap) as SupportMapFragment
        map.getMapAsync(this)

        locationArrayList = ArrayList()

        locationArrayList!!.add(Elephant)
        locationArrayList!!.add(Deer)
        locationArrayList!!.add(WildBuffalo)
        locationArrayList!!.add(Tiger)
    }

    override fun onMapReady(googleMap: GoogleMap){
        mMap =googleMap

        for(i in locationArrayList!!.indices){
            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker"))
            mMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!!.get(i)))
        }
    }
}
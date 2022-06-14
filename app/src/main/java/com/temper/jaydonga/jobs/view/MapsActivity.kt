package com.temper.jaydonga.jobs.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.temper.jaydonga.R
import com.temper.jaydonga.databinding.ActivityMapsBinding
import com.temper.jaydonga.jobs.model.JobLocation

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private lateinit var jobLocations: List<JobLocation>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        jobLocations = intent.getParcelableArrayListExtra<JobLocation>(KEY_LOCATIONS).orEmpty()

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Netherlands
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(52.1326, 5.2913), 6.0f))
        jobLocations.forEach {
            val location = LatLng(it.latitude, it.longitude)
            mMap.addMarker(MarkerOptions().position(location).title(it.name))
        }
    }

    companion object {
        const val KEY_LOCATIONS = "LOCATIONS"
    }
}
package com.adyen.android.assignment.presentation.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adyen.android.assignment.R
import com.adyen.android.assignment.databinding.ActivityMainBinding
import com.adyen.android.assignment.domain.model.Venue
import com.adyen.android.assignment.presentation.venues.VenuesFragm
import com.adyen.android.assignment.presentation.detail.DetailFragm
import com.adyen.android.assignment.presentation.util.newFragmentInstance

class MainActivity : AppCompatActivity(), OnMainActivityCallback{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(savedInstanceState == null) navigateToVenuesPage()
    }

    private fun navigateToVenuesPage() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_container,
                newFragmentInstance<VenuesFragm>(),
                VenuesFragm.FRAGMENT_NAME
            ).commit()
    }

    override fun navigateToDetail(venue: Venue) {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.main_container,
                newFragmentInstance<DetailFragm>(Pair(Venue::class.java.name, venue)),
                DetailFragm.FRAGMENT_NAME
            )
            .addToBackStack(DetailFragm.FRAGMENT_NAME)
            .commit()
    }

}


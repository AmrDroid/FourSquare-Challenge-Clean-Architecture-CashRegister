package com.adyen.android.assignment.presentation.venues

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.adyen.android.assignment.databinding.HolderVenueItemBinding
import com.adyen.android.assignment.domain.model.Locale
import com.adyen.android.assignment.domain.model.Venue
import org.koin.android.ext.android.inject
import kotlin.properties.Delegates


class VenuesAdapter(val onVenuesItemOnClickListener: OnVenuesItemOnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var venueList: List<Locale> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d(
            "VenuesAdapter",
            "onCreateViewHolder() called with: parent = $parent, viewType = $viewType"
        )
        val holderVenueBinding =
            HolderVenueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VenueViewHolder(holderVenueBinding)
    }

    override fun getItemCount(): Int = venueList.size

    private fun getItem(position: Int) = venueList[position]

    override fun getItemId(position: Int): Long = position.toLong()


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(
            "VenuesAdapter",
            "onBindViewHolder() called with: holder = $holder, position = $position"
        )
        (holder as VenueViewHolder).onBind(getItem(position).venue)
    }

    private inner class VenueViewHolder(private val holderVenueBinding: HolderVenueItemBinding) :
        RecyclerView.ViewHolder(holderVenueBinding.root) {

        fun onBind(venue: Venue?) {
            if (venue == null) return

            with(holderVenueBinding) {
                venueNameTextView.text = venue.name
                venueCategoryTextView.text = venue.getCategoryLabel() + "\n" + venue.getAddress()
                venueDistantTextView.text = venue.getDistanceFormatted()

                venueImageView.load(venue.getIcon()) {
                    diskCachePolicy(CachePolicy.ENABLED)
                }
            }


            itemView.setOnClickListener {
                onVenuesItemOnClickListener.onItemClick(venue)
            }
        }
    }


    /**
     * To make an interaction between [VenuesFragm]
     * and [VenuesAdapter]
     * */
    interface OnVenuesItemOnClickListener {
        fun onItemClick(venue: Venue)
    }
}
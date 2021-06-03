package com.adyen.android.assignment.utils

import com.adyen.android.assignment.domain.model.*

val venue1 = Venue(
    "d2cc14bb47d2c0fd1608594",
    "Barry's Bootcamp",
    listOf(
        Category(
            "4bf58dd8d48988d175941735",
            "Gym",
            Icon("", ""),
            "Gyms or Fitness Centers",
            true,
            "Gym / Fitness"
        )
    ),
    Location(
        "135 W 20th St",
        "New York",
        "United States",
        "NY",
        174,
        "US",
        "btwn 6th & 7th Ave	",
        40.74164734518163,
        -73.99576918937264,
        "10011"
    )
)

internal object Data {
    val locale1 = Locale(
        "e-0-4d2cc14bb47d2c0fd1608594-0",
        venue1
    )
    val locale2 = Locale(
        "e-0-4d2cc14bb47d2c0fd1608594-1",
        venue1
    )

    val meta = Meta(
        200,
        "60b7ab35795c99053017500f"
    )
    val venueDetail = VenueDetail(
        "412d2800f964a520df0c1fe3",
        "Central Park",
        null,
        null,
        0.0f,
        "00B551",
        null
    )
    val venueDetailResponse = VenueDetailResponse(venueDetail)
    val detailsResponse = DetailResponse(meta, venueDetailResponse)

    val exploreResponse = ExploreResponse(meta, Explore(emptyList(), "", "", 0, "", null, 0, null))

}
package com.adyen.android.assignment.data.local

import com.adyen.android.assignment.domain.model.*

val venue1 = Venue(
    "d2cc14bb47d2c0fd1608594",
    "Barry's Bootcamp",
    emptyList(),
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
}
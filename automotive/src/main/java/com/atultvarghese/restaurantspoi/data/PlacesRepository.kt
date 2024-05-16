package com.atultvarghese.restaurantspoi.data

import com.atultvarghese.restaurantspoi.data.model.Place

val PLACES = listOf(

    Place(1, "The Atul's Home", 11.453145365224378, 76.06213077863451, 10.0),
    Place(2, "The Swathi's Home", 12.94853633005073, 77.66702188010312,9.0),
    Place(3, "The Kaushal's Home", 19.047260563277355, 72.8250294382217,19.0),
    Place(4, "The Ajit's Home", 10.770652669338137, 76.68057304682799,12.0),
    Place(5, "The Pawan's Home", 11.461682851298859, 76.0419393661555,17.0),
    Place(6, "The Madhan's Home", 11.473145365224378, 76.06213077863451, 10.0),
    Place(7, "The Ben Joy'sHome", 11.564607505682844, 75.7610222433373,9.0),
    Place(8, "The Aiswary's Home", 11.353145365224378, 76.1621077863451,19.0),
    Place(9, "The Vijay's Home", 10.022786739339093, 76.33396268713216,12.0),
    Place(10, "The Vignesh's Home", 11.353945365224378, 76.00213077863451,17.0)
)

class PlacesRepository {
    fun getPlaces() : List<Place> {
        return PLACES
    }

    fun getPlace(id: Int) : Place? {
        return PLACES.find { it.id == id }
    }
}
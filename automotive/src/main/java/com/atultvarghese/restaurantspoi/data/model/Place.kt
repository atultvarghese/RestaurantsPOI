package com.atultvarghese.restaurantspoi.data.model

import android.content.Intent
import androidx.core.net.toUri


data class Place(val id: Int, val name: String, val latitude: Double,val longitude: Double, val distance :Double){

    fun toIntent(action: String) : Intent{
        return Intent(action).apply {
            data = "geo: ${latitude},${longitude}".toUri()
        }
    }

}

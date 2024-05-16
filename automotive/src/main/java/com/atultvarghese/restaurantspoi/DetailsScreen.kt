package com.atultvarghese.restaurantspoi

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import com.atultvarghese.restaurantspoi.data.PlacesRepository

class DetailsScreen(carContext: CarContext, val placeId: Int) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val place = PlacesRepository().getPlace(placeId) ?:
        return MessageTemplate.Builder("Place Not Found")
            .setHeaderAction(Action.BACK)
            .build()

        val navigateAction = Action.Builder()
            .setTitle("Navigate")
            .setOnClickListener {
                carContext.startCarApp(place.toIntent(CarContext.ACTION_NAVIGATE))
            }
            .build()

        return PaneTemplate.Builder(
            Pane.Builder()
                .addAction(navigateAction)
                .addRow(
                    Row.Builder()
                        .setTitle("Coordinates")
                        .addText("Latitude: ${place.latitude} Longitude: ${place.longitude}")
                        .build()
                )
                .addRow(
                    Row.Builder()
                        .setTitle("Description")
                        .addText(place.name)
                        .build()
                )
                .build()
        )
            .setHeaderAction(Action.BACK)
            .build()
    }
}
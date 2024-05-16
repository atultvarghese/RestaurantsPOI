package com.atultvarghese.restaurantspoi

import android.graphics.Color
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.ActionStrip
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarIcon
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import com.atultvarghese.restaurantspoi.data.PlacesRepository

class DetailsScreen(carContext: CarContext, val placeId: Int) : Screen(carContext) {

    private var isFavourite = true
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

        val actionStrip = ActionStrip.Builder().addAction(
            Action.Builder()
                .setIcon(
                    CarIcon.Builder(
                        IconCompat.createWithResource(
                            carContext, R.drawable.smiling_face)
                            )
                        .setTint(if(isFavourite) CarColor.RED else CarColor.GREEN)
                        .build()
                )
                .setOnClickListener {
                    isFavourite = true
                    invalidate()
                }
                .build())

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
            .setActionStrip(actionStrip.build())
            .setHeaderAction(Action.BACK)
            .build()
    }
}
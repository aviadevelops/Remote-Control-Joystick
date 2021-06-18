package com.example.remotecontroljoystick.view_model

import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import com.example.remotecontroljoystick.model.FGPlayer
import com.example.remotecontroljoystick.views.Joystick
import java.util.*
import kotlin.concurrent.thread

class ViewModel constructor(

) {
    var player: FGPlayer = FGPlayer()
    fun connect(ip: String, port: String){
        player = FGPlayer(ip, port)
        player.connect()
    }


    fun updateAileronAndElevator(a: Float, e: Float): Float {
        player.setAileronAndElevator(a, e)
        return 0.0F
    }

    fun updateThrottle(throttle: Float) {
        player.setThrottle(throttle)
    }

    fun updateRudder(rudder: Float) {
        player.setRudder(rudder)
    }
}
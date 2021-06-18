package com.example.remotecontroljoystick.views

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import com.example.remotecontroljoystick.R
import com.example.remotecontroljoystick.model.FGPlayer
import com.example.remotecontroljoystick.view_model.ViewModel

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var ip: EditText = findViewById(R.id.ip_et)
        var port: EditText = findViewById(R.id.port_et)
        var btn_connect: Button = findViewById(R.id.btn_connect)
        var seekbar_rudder: SeekBar = findViewById(R.id.seekbar_rudder)
        var seekbar_throttle: SeekBar = findViewById(R.id.seekbar_throttle)
        seekbar_rudder.max = 100
        seekbar_rudder.min = -100
        seekbar_throttle.max = 100
        seekbar_throttle.min = 0


        var joystick: Joystick = findViewById(R.id.custom_joystick)


        var vm: ViewModel =
            ViewModel()

        btn_connect.setOnClickListener {
           vm.connect(ip.text.toString(), port.text.toString())
        }

        seekbar_rudder.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                vm.updateRudder(progress.toFloat()/100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekbar_throttle.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                vm.updateThrottle(progress.toFloat()/100)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        joystick.onChange = { a: Float, e: Float -> vm.updateAileronAndElevator(a, e) }
//        joystick.start()

    }
}
package com.example.remotecontroljoystick.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.ForkJoinPool

class FGPlayer constructor(ip: String, port: String) {
    var ip = ip
    var port = port
    var fg: Socket? = null
    var out: PrintWriter? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    val fj = ForkJoinPool(1, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true)


    fun connect() {
        fj.execute {
            fg = Socket(ip, port.toInt())
            out = PrintWriter(fg!!.getOutputStream(), true)
            println("Connected Successfully")
//            for (i in 1..2000) {
//                out?.print("set /controls/engines/current-engine/throttle " + 1 + "\r\n")
//            }

        }
    }

    fun setAileronAndElevator(a: Float, e: Float) {
        fj.execute {
            out?.print("set /controls/flight/aileron " + a + "\r\n")
            out?.flush()
            out?.print("set /controls/flight/elevator " + e + "\r\n")
            out?.flush()
        }

    }

    fun setThrottle(throttle: Float) {
        fj.execute {
            out?.print("set /controls/engines/current-engine/throttle " + throttle + "\r\n")
            out?.flush()
        }
    }

    fun setRudder(rudder: Float) {
        fj.execute {
            out?.print("set /controls/flight/rudder " + rudder + "\r\n")
            out?.flush()
        }
    }

    constructor() : this("", "") {

    }


}
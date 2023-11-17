package com.example.automacorp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.automacorp.service.RoomService

class RoomActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val roomId = intent.getLongExtra(MainActivity.ROOM_ID_PARAM, 0)
        val room = RoomService.ROOMS.firstOrNull {it.id == roomId}

        val roomName = findViewById<TextView>(R.id.txt_room_name)
        roomName.text = room?.name ?: ""

        val roomCurrentTemperature = findViewById<TextView>(R.id.txt_room_current_temperature)
        roomCurrentTemperature.text = room?.currentTemperature?.toString() ?: ""

        val roomTargetTemperature = findViewById<TextView>(R.id.txt_room_target_temperature)
        roomTargetTemperature.text = room?.targetTemperature?.toString() ?: ""
    }
}
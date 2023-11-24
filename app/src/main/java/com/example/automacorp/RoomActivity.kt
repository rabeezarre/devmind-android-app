package com.example.automacorp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.automacorp.service.RoomService

class RoomActivity : BasicActivity(), OnRoomClickListener {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val roomId = intent.getLongExtra(MainActivity.ROOM_ID_PARAM, 0)
        val room = RoomService.ROOMS.firstOrNull {it.id == roomId}

        val roomName = findViewById<TextView>(R.id.txt_room_name)
        roomName.text = room?.name ?: ""

        val roomCurrentTemperature = findViewById<TextView>(R.id.txt_current_temperature)
        roomCurrentTemperature.text = room?.currentTemperature?.toString() ?: ""

        val roomTargetTemperature = findViewById<TextView>(R.id.txt_target_temperature)
        roomTargetTemperature.text = room?.targetTemperature?.toString() ?: ""
    }
    override fun selectRoom(id: Long) {
        val intent = Intent(this, RoomActivity::class.java).putExtra(MainActivity.ROOM_ID_PARAM, id)
        startActivity(intent)
    }
}
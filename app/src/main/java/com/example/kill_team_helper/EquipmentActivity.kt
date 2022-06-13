package com.example.kill_team_helper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kill_team_helper.adapter.EquipmentsAdapter
import com.example.kill_team_helper.adapter.FactionAdapter
import com.example.kill_team_helper.adapter.KillteamAdapter
import com.example.kill_team_helper.database.Basedades
import com.example.kill_team_helper.database.Equipment
import com.example.kill_team_helper.databinding.ActivityKillteamBinding

class EquipmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityKillteamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKillteamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val killteamId = intent.getStringExtra("KILLTEAM_IDs")

        val killTeam = Basedades.listKillTeam.find { it.killteamid == killteamId }
        killTeam?.let {

            binding.killteamList.adapter = EquipmentsAdapter(it.equipment, this)
        }
    }


}


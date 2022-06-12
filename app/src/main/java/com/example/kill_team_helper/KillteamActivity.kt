package com.example.kill_team_helper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kill_team_helper.adapter.FactionAdapter
import com.example.kill_team_helper.adapter.KillteamAdapter
import com.example.kill_team_helper.database.Basedades
import com.example.kill_team_helper.databinding.ActivityKillteamBinding

class KillteamActivity : AppCompatActivity() {
    lateinit var binding: ActivityKillteamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKillteamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val killteamId = intent.getStringExtra("KILLTEAM_EXTRA")
        Basedades[killteamId]?.killteams?.let {
            binding.killteamList.adapter = KillteamAdapter(it, this)
        }

    }

}
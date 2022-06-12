package com.example.kill_team_helper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.kill_team_helper.adapter.KillteamAdapter
import com.example.kill_team_helper.database.Basedades
import com.example.kill_team_helper.databinding.ActivityKillteamInsideBinding

class KillteamInsideActivity() : AppCompatActivity() {
    lateinit var binding: ActivityKillteamInsideBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKillteamInsideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtener el id del objeto a traves del extra
        val killteamInsideId = intent.getStringExtra("KILLTEAM_ID")

        //Inicializar el objeto a traves el id (buscarlo en la lista)

        //Ir seteando todos los campos del layout con la info del objeto
        Basedades[killteamInsideId]?.killteams?.let {
            //binding.killteamList.adapter = KillteamInsideAdapter(it, this)
        }

        val killTeam = Basedades.listKillTeam.find { it.killteamid == killteamInsideId}
        killTeam?.let {
            Toast.makeText(this,it.killteamname, Toast.LENGTH_SHORT).show()
            val image: ImageView = findViewById(R.id.ivKillteamInside)
            image.setImageDrawable(this.getDrawable(R.drawable.ic_launcher_background))
            var name: TextView = findViewById(R.id.tvKillteamName)
            name.text= it.killteamname
            var desc: TextView = findViewById(R.id.tvKillteamDesc)
            desc.text= it.description
            var button :Button = findViewById(R.id.button_equipment)
            button.setOnClickListener{
                val intent = Intent(this, EquipmentActivity::class.java)
                intent.putExtra("KILLTEAM_IDs", killteamInsideId)


                startActivity(intent)
            }
            var button2 :Button = findViewById(R.id.button2)
            button.setOnClickListener{
                val intent = Intent(this, EquipmentActivity::class.java)
                intent.putExtra("KILLTEAM_IDs", killteamInsideId)


                startActivity(intent)
            }

        }





    }


}
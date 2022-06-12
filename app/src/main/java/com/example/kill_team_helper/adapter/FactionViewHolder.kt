package com.example.kill_team_helper.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kill_team_helper.KillteamActivity
import com.example.kill_team_helper.KillteamInsideActivity
import com.example.kill_team_helper.R
import com.example.kill_team_helper.database.Equipment
import com.example.kill_team_helper.database.Faction
import com.example.kill_team_helper.database.Killteam

class FactionViewHolder(val context:Context, val view: View):RecyclerView.ViewHolder(view) {

    private val image: ImageView = view.findViewById(R.id.ivFaction)
    private val name: TextView = view.findViewById(R.id.tvEquipmentName)
    private val description: TextView = view.findViewById(R.id.tvEquipmentDesc)

    fun renderFaction(faction: Faction, id: String){
        image.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background))
        name.text = faction.factionname
        description.text = faction.description

        view.setOnClickListener {
            val intent = Intent(context, KillteamActivity::class.java)
            intent.putExtra("KILLTEAM_EXTRA", id)
            context.startActivity(intent)
        }
    }

    fun renderKillTeam(killteam: Killteam, id: String){
        image.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background))
        name.text = killteam.killteamname
        description.text = killteam.description


        view.setOnClickListener {
            val intent = Intent(context, KillteamInsideActivity::class.java)
            intent.putExtra("KILLTEAM_ID", id)
           context.startActivity(intent)
        }
    }

    fun renderEquipmeent(equip: Equipment, id: String){
        val name: TextView = view.findViewById(R.id.tvEquipmentName)
        val description: TextView = view.findViewById(R.id.tvEquipmentDesc)
        name.text = equip.eqname
        description.text = equip.eqdescription


        view.setOnClickListener {
            //val intent = Intent(context, KillteamInsideActivity::class.java)
            //intent.putExtra("KILLTEAM_ID", id)
            //context.startActivity(intent)
             Toast.makeText(context, "Click on $id", Toast.LENGTH_SHORT).show()
        }
    }


}
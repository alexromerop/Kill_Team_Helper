package com.example.kill_team_helper.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kill_team_helper.KillteamActivity
import com.example.kill_team_helper.R
import com.example.kill_team_helper.database.Faction
import com.example.kill_team_helper.database.Killteam

class FactionViewHolder(val context:Context, val view: View):RecyclerView.ViewHolder(view) {

    private val image: ImageView = view.findViewById(R.id.ivFaction)
    private val name: TextView = view.findViewById(R.id.tvFactionName)
    private val description: TextView = view.findViewById(R.id.tvFactionDesc)

    fun render(faction: Faction, id: String){
        image.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background))
        name.text = faction.factionname
        description.text = faction.description

        view.setOnClickListener {
            val intent = Intent(context, KillteamActivity::class.java)
            intent.putExtra("KILLTEAM_EXTRA", id)
            context.startActivity(intent)
        }
    }

    fun render(killteam: Killteam, id: String){
        image.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background))
        name.text = killteam.killteamname
        description.text = killteam.description

        view.setOnClickListener {
//            val intent = Intent(context, KillteamActivity::class.java)
//            intent.putExtra("KILLTEAM_EXTRA", id)
//            context.startActivity(intent)
            Toast.makeText(context, "Click on $id", Toast.LENGTH_SHORT).show()
        }
    }

}
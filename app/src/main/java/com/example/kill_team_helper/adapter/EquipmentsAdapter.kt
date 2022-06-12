package com.example.kill_team_helper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kill_team_helper.R
import com.example.kill_team_helper.database.Equipment
import com.example.kill_team_helper.database.Killteam

class EquipmentsAdapter(killteamSet: HashMap<String, Equipment>, val context: Context) :
    RecyclerView.Adapter<FactionViewHolder>() {

    val killteamList = killteamSet.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FactionViewHolder(
            context,
            layoutInflater.inflate(R.layout.item_faction, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FactionViewHolder, position: Int) {
        holder.renderEquipmeent(killteamList[position].second, killteamList[position].first)
    }

    override fun getItemCount(): Int {
        return killteamList.size
    }
}
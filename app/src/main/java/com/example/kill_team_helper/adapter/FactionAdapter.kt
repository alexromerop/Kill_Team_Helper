package com.example.kill_team_helper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kill_team_helper.R
import com.example.kill_team_helper.FactionProvider
import com.example.kill_team_helper.database.Faction

class FactionAdapter(factionSet: HashMap<String, Faction>, val context: Context) :
    RecyclerView.Adapter<FactionViewHolder>() {

    val factionList = factionSet.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FactionViewHolder(
            context,
            layoutInflater.inflate(R.layout.item_faction, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FactionViewHolder, position: Int) {
        holder.render(factionList[position].second, factionList[position].first)
    }

    override fun getItemCount(): Int {
        return factionList.size
    }
}
package com.example.kill_team_helper.database

class Killteam (
                       val factionid: String,
                       val killteamid: String,
                       val killteamname: String,
                       val description: String,
                       val killteamcomp: String,
                       val equipment: HashMap<String,Equipment>,
                       val ploys: Pair<Any,Any>,
                       val fireteam: HashMap<String,Fireteam>,
){





}
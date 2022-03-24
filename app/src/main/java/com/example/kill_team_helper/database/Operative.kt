package com.example.kill_team_helper.database

class Operative (
                       val factionid: String,
                       val killteamid: String,
                       val fireteamid: String,
                       val opid: String,
                       val opname: String,
                       val description: String,
                       val M: String,
                       val APL: String,
                       val GA: String,
                       val DF: String,
                       val SV: String,
                       val W: String,
                       val keywords: String,
                       val weapons: HashMap<String,Weapon>,
                       val fireteammax: String,


                       )
{




}
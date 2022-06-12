package com.example.kill_team_helper

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kill_team_helper.adapter.FactionAdapter
import com.example.kill_team_helper.database.*
import com.example.kill_team_helper.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private fun loadJSONFromAsset(context: Context): JSONObject? {

        //Read database json
        var json: String?
        json = try {
            val stream: InputStream = context.assets.open("Database.json")
            val size: Int = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }


        val Json = JSONObject(json ?: return null)
        val basededatos_ = Json.getJSONArray("root")

        for (i in 0 until basededatos_.length()) {
            val faction_list = HashMap<String, Faction>()
            val killteams_list = HashMap<String, Killteam>()
            val strats_list = HashMap<String, Strat>()
            val tacs_list = HashMap<String, Tac>()
            val equipments_list = HashMap<String, Equipment>()
            val fireteams_list = HashMap<String, Fireteam>()
            val operatives_list = HashMap<String, Operative>()
            val weapons_list = HashMap<String, Weapon>()
            val weaponprofiles_list = HashMap<String,Weaponprofile>()
            //bucle get all dates
            val basededatos = Json.getJSONArray("root").getJSONObject(i)
            val factionid = basededatos.getString("factionid")
            val factionname = basededatos.getString("factionname")
            val description = basededatos.getString("description")
            val killteamss = basededatos.getJSONArray("killteams")

            for (it in 0 until killteamss.length()) {
                val Killteam_Object = basededatos.getJSONArray("killteams").getJSONObject(it)
                val killteamid = Killteam_Object.getString("killteamid")
                val killteamname = Killteam_Object.getString("killteamname")
                val description = Killteam_Object.getString("description")
                val ploys_ = Killteam_Object.getJSONObject("ploys")
                val equipment_ = Killteam_Object.getJSONArray("equipments")
                val killteamcomp = Killteam_Object.getString("killteamcomp")
                val fireteams_ = Killteam_Object.getJSONArray("fireteams")


                //bucle ploys

                val strats_ = ploys_.getJSONArray("strat")
                for (k in 0 until strats_.length()) {
                    val Strats_Object = strats_.getJSONObject(k)
                    val ployid = Strats_Object.getString("ployid")
                    val ployname = Strats_Object.getString("ployname")
                    val ploytype = Strats_Object.getString("ploytype")
                    val CP = Strats_Object.getString("CP")
                    val description = Strats_Object.getString("description")
                    strats_list[ployid]= Strat(factionid,killteamid,ploytype,ployid,ployname,CP,description)
                }

                val tac_ = ploys_.getJSONArray("tac")
                for (k in 0 until tac_.length()) {
                    val Tac_Object = tac_.getJSONObject(k)
                    val ployid = Tac_Object.getString("ployid")
                    val ployname = Tac_Object.getString("ployname")
                    val ploytype = Tac_Object.getString("ploytype")
                    val CP = Tac_Object.getString("CP")
                    val description = Tac_Object.getString("description")
                    tacs_list[ployid]= Tac(factionid,killteamid,ploytype,ployid,ployname,CP,description)

                }

                val ploys_list = Pair(strats_list,  tacs_list)



                // bucle equipment
                for (j in 0 until equipment_.length()) {
                    val Equipment_Object = equipment_.getJSONObject(j)
                    val eqid = Equipment_Object.getString("eqid")
                    val eqname = Equipment_Object.getString("eqname")
                    val eqdescrition = Equipment_Object.getString("eqdescription")
                    val eqpts = Equipment_Object.getString("eqpts")

                    equipments_list[eqid] = Equipment(factionid,killteamid,eqid,eqpts,eqname,eqdescrition)

                }


                //bucle firetaams
                for (j in 0 until fireteams_.length()) {
                    val Fireteam_Object = fireteams_.getJSONObject(j)
                    val fireteamid = Fireteam_Object.getString("fireteamid")
                    val fireteamname = Fireteam_Object.getString("fireteamname")
                    val archetype = Fireteam_Object.getString("archetype")
                    val description = Fireteam_Object.getString("description")
                    val killteammax = Fireteam_Object.getString("killteammax")
                    val operatives = Fireteam_Object.getJSONArray("operatives")

                    for (k in 0 until operatives.length()) {
                        val Operative_Object = operatives.getJSONObject(k)
                        val opid = Operative_Object.getString("opid")
                        val opname = Operative_Object.getString("opname")
                        val description = Operative_Object.getString("description")
                        val M = Operative_Object.getString("M")
                        val APL = Operative_Object.getString("APL")
                        val GA = Operative_Object.getString("GA")
                        val DF = Operative_Object.getString("DF")
                        val SV = Operative_Object.getString("SV")
                        val W = Operative_Object.getString("W")
                        val keywords = Operative_Object.getString("keywords")
                        val weapons = Operative_Object.getJSONArray("weapons")
                        for (l in 0 until weapons.length()) {
                            val Weapon_Object = weapons.getJSONObject(l)
                            val wepid = Weapon_Object.getString("wepid")
                            val wepname = Weapon_Object.getString("wepname")
                            val weptype = Weapon_Object.getString("weptype")
                            val profiles = Weapon_Object.getJSONArray("profiles")

                            for (z in 0 until profiles.length()) {
                                val Profile_Object = profiles.getJSONObject(z)
                                val profileid = Profile_Object.getString("profileid")
                                val name = Profile_Object.getString("name")
                                val A = Profile_Object.getString("A")
                                val BS = Profile_Object.getString("BS")
                                val D = Profile_Object.getString("D")
                                val SR = Profile_Object.getString("SR")

                                weaponprofiles_list[profileid] = Weaponprofile(factionid,killteamid,fireteamid,opid,wepid,profileid,name,A,BS,D,SR)
                            }

                            weapons_list[wepid]= Weapon(factionid,killteamid,fireteamid,opid,wepid,wepname,weptype,weaponprofiles_list)
                        }
                        val uniqueactions = Operative_Object.getJSONArray("uniqueactions")
                        val abilities = Operative_Object.getJSONArray("abilities")
                        val fireteammax = Operative_Object.getString("fireteammax")

                        operatives_list[opid] = Operative(factionid,killteamid,fireteamid,opid,opname,description,M,APL,GA,DF,SV,W,keywords,weapons_list,fireteammax)
                    }
                    val fireteamcomp = Fireteam_Object.getString("fireteamcomp")

                    fireteams_list[fireteamid]= Fireteam(factionid,killteamid,fireteamid,description,fireteamname,archetype,fireteamcomp,killteammax,operatives_list)
                }

                killteams_list[killteamid]= Killteam(factionid,killteamid,killteamname,description,killteamcomp,equipments_list,ploys_list,fireteams_list)
                Basedades.listKillTeam.add(Killteam(factionid,killteamid,killteamname,description,killteamcomp,equipments_list,ploys_list,fireteams_list))
            }

            faction_list[factionid]= Faction(factionid,factionname,description,killteams_list)


            Basedades[factionid]=Faction(factionid,factionname,description,killteams_list)

        }

        return null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadJSONFromAsset(this)

        binding.factionList.adapter = FactionAdapter(Basedades, this)


    }




}
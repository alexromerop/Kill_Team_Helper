package com.example.kill_team_helper

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {


    private lateinit var communicator: Communicator

    override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        communicator = activity as Communicator



        view.sendbtn.setOnClickListener(){
            communicator.passDataCom(view.stats_ally_Atk_id.text.toString(),view.Dmg_ally_stat_id.text.toString(),view.stats_ally_BS_id.text.toString(),view.stats_ally_Critic_id.text.toString(),view.textView_Defense_id.text.toString())




        }
        return view


    }




}


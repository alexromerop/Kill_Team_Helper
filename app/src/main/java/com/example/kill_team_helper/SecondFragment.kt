package com.example.kill_team_helper

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.flow.callbackFlow

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {


    var Res1: String? = ""
    var Res2: String? = ""
    var Res3: String? = ""
    var Res4: String? = ""
    var Res5: String? = ""
    var Res6: String? = ""
    var Res7: String? = ""
    var Res8: String? = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        return view

    }


    fun Calc_hits(Atacks: String?, Bs: String?, Defense: String?): Array<Int> {
        var atk = Atacks?.toInt()
        var bs = Bs?.toInt()
        var a = Defense?.toInt()

        val Hits = arrayOf<Int>(
            0, 0,
        )
        if (atk != null || bs != null) {


            for (it in 1..atk!!) {

                val randomNumber = (1..6).random()
                var a = randomNumber.toString()
                if (randomNumber == 6) {
                    //Ma 1 en criticos

                    Log.d(tag, a)
                    Hits[1]++
                } else if (randomNumber >= bs!!) {
                    Log.d(tag, a)

                    Hits[0]++
                }


            }


        }
        return Hits
    }


}
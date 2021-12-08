package com.example.kill_team_helper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), Communicator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentA).commit()

    }


    override fun passDataCom(
        editTextInput: String,
        edit1: String,
        edit2: String,
        edit3: String,
        edit4: String
    ) {
        val bundle = Bundle()
            bundle.putString("res1", editTextInput)
            bundle.putString("res2", edit1)
            bundle.putString("res3", edit2)



        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = SecondFragment()
        fragmentB.arguments = bundle

        //esto envia los valores
        transaction.replace(R.id.fragment_container, fragmentB)
        transaction.commit()
    }


}
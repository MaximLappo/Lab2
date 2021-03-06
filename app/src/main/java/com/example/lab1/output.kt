package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class output : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_output, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = arguments?.getString("message", "" )
        val color = arguments?.getInt("color", 0)

        val gett: TextView = view.findViewById(R.id.result)
        gett.text = text
        gett.setTextColor(color!!)

        val butt: Button = view.findViewById(R.id.button2)
        butt.setOnClickListener{
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
    }

}
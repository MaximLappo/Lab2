package com.example.lab1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


class input : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var entry: AutoCompleteTextView? = null
        var butt: Button? = null
        var radio: RadioGroup? = null

        super.onCreate(savedInstanceState)
        entry = view.findViewById(R.id.autoCompleteTextView)
        butt = view.findViewById(R.id.button)
        radio = view.findViewById(R.id.radio)



        butt?.setOnClickListener {
            if (childFragmentManager.findFragmentByTag("output")==null) {
                    if (entry?.text?.toString()?.trim()?.equals("")!!)
                        Toast.makeText(view.context, "Введіть текст", Toast.LENGTH_LONG).show()
                    else {
                        val frag = output()
                        val bundle = Bundle()
                        frag.arguments = bundle

                        var radioCheck = radio?.checkedRadioButtonId
                        val color = when (radioCheck) {
                            R.id.rd1 -> Color.GREEN
                            R.id.rd2 -> Color.RED
                            R.id.rd3 -> Color.BLUE
                            R.id.rd4 -> Color.YELLOW
                            else -> Color.BLACK
                        }
                        bundle.putString("message", entry.text.toString())
                        bundle.putInt("color", color)
                        childFragmentManager.beginTransaction().add(R.id.out, frag, "output")
                            .commit()
                    }
                }
            else
                Toast.makeText(view.context, "!!!!", Toast.LENGTH_SHORT).show()
        }
    }
}




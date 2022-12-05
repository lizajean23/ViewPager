package com.example.viewpager.fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpager.R

class FirstFragment:Fragment(R.layout.first_fragment) {
    private lateinit var note: EditText
    private lateinit var button: Button
    private lateinit var text : TextView

    private lateinit var  sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        note = view.findViewById(R.id.note)
        button = view.findViewById(R.id.add)
        text = view.findViewById(R.id.textView3)


        sharedPreferences  = requireActivity().getSharedPreferences("my pref", MODE_PRIVATE)
        val prefNote = sharedPreferences.getString("NOTE","")
        text.text = prefNote

        button.setOnClickListener {
            val noted = note.text.toString()

            if(noted.isNullOrEmpty()){
                return@setOnClickListener
            }
            val notes = text.text.toString()
            val resultText = notes + '\n' + noted
            text.text = resultText
            note.setText("")


            sharedPreferences.edit()
                .putString("NOTE", resultText)
                .apply()
        }
    }

}



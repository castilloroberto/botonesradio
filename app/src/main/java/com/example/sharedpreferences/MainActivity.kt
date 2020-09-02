package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_ver_datos.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cargarData()
        btn_save.setOnClickListener { saveData() }
        btn_datos.setOnClickListener { abirData() }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_pirates ->
                    if (checked) {
                        // Pirates are the best
                    }
                R.id.radio_ninjas ->
                    if (checked) {
                        // Ninjas rule
                    }
            }
        }
    }


    private fun abirData(){
        val inte = Intent(this,VerDatos::class.java)
        startActivity(inte)


    }
    private fun cargarData() {
        val sharedprefs = getSharedPreferences("misprefe",Context.MODE_PRIVATE)
        val dato = sharedprefs.getString("nombre", "nombre:")
        val edad = sharedprefs.getString("edad", "edad:")
        et_edad.setText(edad)
        tv_title.text = dato
        et_nombre.setText(dato)

    }

    private fun saveData() {
        val sharedprefs = getSharedPreferences("misprefe",Context.MODE_PRIVATE)
        with(sharedprefs.edit()) {
            putString("nombre", et_nombre.text.toString())
            putString("edad", et_edad.text.toString())
            commit()
        }
        cargarData()
    }
}
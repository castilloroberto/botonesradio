package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ver_datos.*

class VerDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_datos)
        cargarData()

    }


    private fun astac(){
        val sharedPref = getSharedPreferences("nombre",
            Context.MODE_PRIVATE
        )
    }

    private fun cargarData() {
        val sharedprefs = getSharedPreferences("misprefe",Context.MODE_PRIVATE)
//        val sharedprefs = getPreferences(Context.MODE_PRIVATE)
        val dato = sharedprefs.getString("nombre", "nombre:")
        val edad = sharedprefs.getString("edad", "edad:")
        tvedad_vda.text = edad
        tvnombre_vda.text = dato
//        .setText(dato)

    }
}
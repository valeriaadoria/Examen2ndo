package edu.iest.examen2ndo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Perfil : AppCompatActivity() {
    private lateinit var tvBienvenido: TextView
    private lateinit var FAB: FloatingActionButton
    private lateinit var etNombre: EditText
    private lateinit var etEdad: EditText
    private lateinit var etGato: EditText
    private val NOMBRE_KEY = "nombre"
    private val GATO_KEY = "gato"
    private val EDAD_KEY = "edad"
    private var nombre: String = ""
    private var gato: String = ""
    private var edad: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PREFERENCIAS", "onCreate")
        setContentView(R.layout.activity_perfil)
        inicializarVistas()

        Log.d("PREFERENCIAS", savedInstanceState?.getString(NOMBRE_KEY).toString())
        Log.d("PREFERENCIAS", savedInstanceState?.getString(GATO_KEY).toString())
        Log.d("PREFERENCIAS", savedInstanceState?.getString(EDAD_KEY).toString())
    }
        override fun onSaveInstanceState(outState: Bundle) {
            Log.d("PREFERENCIAS", "onSaveInstanceState")
            outState.putString(NOMBRE_KEY, nombre )
            outState.putString(GATO_KEY, gato)
            outState.putString(EDAD_KEY, edad)


            outState.run {
                putString(NOMBRE_KEY, nombre)
                putString(EDAD_KEY, edad)
                putString(GATO_KEY, gato)
            }
            // call superclass to save any view hierarchy
            super.onSaveInstanceState(outState)

        }


        override fun onResume() {
           /* tvBienvenido = findViewById(R.id.tvBienvenido)
            etNombre = findViewById(R.id.etNombre)
            etGato = findViewById(R.id.etGato)
            etEdad = findViewById(R.id.etEdad)

            Log.d("PREFERENCIAS","onResume")
            if(TextUtils.isEmpty(nombre)){
                val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
                nombre=miSharedPreferences.getString(NOMBRE_KEY,"valeria").toString()
            }
            if(TextUtils.isEmpty(gato)){
                val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
                gato=miSharedPreferences.getString(GATO_KEY,"dante").toString()
            }
            super.onResume()*/
            tvBienvenido = findViewById(R.id.tvBienvenido)
            etNombre = findViewById(R.id.etNombre)
            etGato = findViewById(R.id.etGato)
            etEdad = findViewById(R.id.etEdad)

            super.onResume()

            val sharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            nombre = sharedPreferences.getString(NOMBRE_KEY, "") ?: ""
            gato = sharedPreferences.getString(GATO_KEY, "") ?: ""
            edad = sharedPreferences.getString(EDAD_KEY, "") ?: ""

            etNombre.setText(nombre)
            etGato.setText(gato)
            etEdad.setText(edad)

            cambiarTextoBienvenida(nombre, gato,edad)
        }

        override fun onStart() {
            Log.d("PREFERENCIAS","onStart")
            tvBienvenido.text="Sin Datos Previos"
            super.onStart()
        }

        override fun onPause() {
            Log.d("PREFERENCIAS","onPause")
            super.onPause()
            // Guardar valores actuales de nombre y gato en SharedPreferences
            val sharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(NOMBRE_KEY, nombre).apply()
            editor.putString(GATO_KEY, gato).apply()        }

        override fun onDestroy() {
            Log.d("PREFERENCIAS","onDestroy")
            super.onDestroy()
        }

        private fun cambiarTextoBienvenida(nombre: String, gato:String,edad:String) {
            if (!TextUtils.isEmpty(nombre)||!TextUtils.isEmpty(gato)||!TextUtils.isEmpty(edad)) {
                tvBienvenido.text = "Con Datos Previamente Guardados"
                Toast.makeText(this, "Datos Guardados", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No se registraron datos", Toast.LENGTH_LONG).show()
            }
        }

        private fun inicializarVistas() {
            tvBienvenido = findViewById(R.id.tvBienvenido)
            etNombre = findViewById(R.id.etNombre)
            etGato = findViewById(R.id.etGato)
            etEdad = findViewById(R.id.etEdad)

            FAB= findViewById(R.id.fab)

            FAB.setOnClickListener {
                nombre = etNombre.text.toString()
                edad = etEdad.text.toString()
                gato = etGato.text.toString()
                cambiarTextoBienvenida(nombre,gato,edad)
                val miSharedPreferences = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
                val editor = miSharedPreferences.edit()
                editor.putString(NOMBRE_KEY, nombre).apply()
                editor.putString(EDAD_KEY, edad).apply()
                editor.putString(GATO_KEY, gato).apply()

            }

        }

    }
package edu.iest.examen2ndo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examen2ndo.adapter.OpcionAdapter
import edu.iest.examen2ndo.models.FakerOpcion
import edu.iest.examen2ndo.models.Opcion

class MainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.pantalla, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val juegos = FakerOpcion().getOpciones()
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        var administradorDeLayouts = GridLayoutManager(this,2)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = OpcionAdapter(juegos, this)
        Toast.makeText(this, "WIFI", Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val juegos = FakerOpcion().getOpciones()
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        var administradorDeLayouts = GridLayoutManager(this,2)
        recycler.layoutManager = administradorDeLayouts
        recycler.adapter = OpcionAdapter(juegos, this)


    }



}
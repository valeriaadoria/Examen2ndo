package edu.iest.examen2ndo

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
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
        if (connectToInternet()) {
            Toast.makeText(this, "Conectado", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "No Conectado", Toast.LENGTH_LONG).show()
        }

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
    private fun connectToInternet(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }



}
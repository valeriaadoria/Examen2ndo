package edu.iest.examen2ndo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examen2ndo.Perfil
import edu.iest.examen2ndo.R
import edu.iest.examen2ndo.models.Opcion
import edu.iest.examen2ndo.opcion

class OpcionAdapter(private val itemList: List<Opcion>, context: Context) : RecyclerView.Adapter<OpcionAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        var id: Int = 0// inicializamos position con un valor por defecto

        init {

            // setOnClickListener para el imageView
            imageView.setOnClickListener {
                val intent = Intent(itemView.context, Perfil::class.java)
                Toast.makeText(itemView.context,"Has seleccionado el elemento " + textView.text, Toast.LENGTH_SHORT).show()

                if (textView.text=="Perfil"){
                    itemView.context.startActivity(intent)
                }

                if (textView.text=="Cerrar"){
                    (itemView.context as AppCompatActivity).finish()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_opcion, parent, false)
        val holder = MyViewHolder(itemView)
        itemView.setOnClickListener {
            Toast.makeText(
                parent.context,
                "Has seleccionado el elemento ${holder.id + 1}", // mostramos la posición + 1
                Toast.LENGTH_SHORT
            ).show()
        }
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.imageView.setImageResource(currentItem.img)
        holder.textView.text = currentItem.text
        holder.id = position // asignamos la posición
    }

    override fun getItemCount() = itemList.size
}


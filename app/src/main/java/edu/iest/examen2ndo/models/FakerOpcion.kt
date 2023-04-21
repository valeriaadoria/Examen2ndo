package edu.iest.examen2ndo.models

import edu.iest.examen2ndo.R

class FakerOpcion {
    fun getOpciones() : ArrayList<Opcion>{
        val opciones : ArrayList<Opcion>
        opciones = arrayListOf<Opcion>()

        val opcion = Opcion(1, R.drawable.cat,"Gatos")
        opciones.add(opcion)
        opciones.add(Opcion(2, R.drawable.profile,"Perfil"))
        opciones.add(Opcion(3, R.drawable.config,"Configurar"))
        opciones.add(Opcion(4, R.drawable.close,"Cerrar"))
        return opciones
    }
}
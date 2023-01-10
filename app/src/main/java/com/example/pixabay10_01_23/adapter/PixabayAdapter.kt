package com.example.pixabay10_01_23.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabay10_01_23.R
import com.example.pixabay10_01_23.models.Hit

class PixabayAdapter(var lista: MutableList<Hit>): RecyclerView.Adapter<PixaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_pixa, parent, false)
        return PixaViewHolder(v)
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.render(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}
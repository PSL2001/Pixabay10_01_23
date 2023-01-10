package com.example.pixabay10_01_23.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pixabay10_01_23.databinding.LayoutPixaBinding
import com.example.pixabay10_01_23.models.Hit
import com.squareup.picasso.Picasso

class PixaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val binding = LayoutPixaBinding.bind(v)

    fun render(hit: Hit) {
        Picasso.get().load(hit.webformatURL).into(binding.ivImagen)
        binding.tvAutor.text = hit.user
        binding.tvLikes.text = hit.likes.toString()
    }

}

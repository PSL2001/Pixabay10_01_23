package com.example.pixabay10_01_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pixabay10_01_23.adapter.PixabayAdapter
import com.example.pixabay10_01_23.apiProvider.ApiClient
import com.example.pixabay10_01_23.databinding.ActivityMainBinding
import com.example.pixabay10_01_23.models.Hit
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var lista = mutableListOf<Hit>()
    lateinit var adapter: PixabayAdapter
    var key = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        key = getString(R.string.api_key)
        setContentView(binding.root)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recPix.layoutManager = layoutManager
        adapter = PixabayAdapter(lista)
        binding.recPix.adapter = adapter
        traerImagenes()
    }

    private fun traerImagenes() {
        lifecycleScope.launch{
            val datos = ApiClient.service.getImages(key, "Aviones")

            adapter.lista = datos.hits.toMutableList()
            adapter.notifyDataSetChanged()
        }
    }
}
package com.example.pixabay10_01_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
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
    var term = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        key = getString(R.string.api_key)
        setContentView(binding.root)
        setRecyclerView()
        setListeners()
    }

    private fun setListeners() {
        binding.svBusca.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                term = p0.toString()
                traerImagenes(term)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })
    }
    private fun setRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recPix.layoutManager = layoutManager
        adapter = PixabayAdapter(lista)
        binding.recPix.adapter = adapter

    }

    private fun traerImagenes(termino: String) {
        lifecycleScope.launch{
            val datos = ApiClient.service.getImages(key, termino)

            adapter.lista = datos.hits.toMutableList()
            adapter.notifyDataSetChanged()
        }
    }
}
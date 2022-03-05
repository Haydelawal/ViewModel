package com.example.retrofit_ss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_ss.adapter.MyAdapter
import com.example.retrofit_ss.databinding.ActivityMainBinding
import com.example.retrofit_ss.model.Post
import com.example.retrofit_ss.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


       // val myPost = Post(2,2, "LAHM54", "android")
        viewModel.getPost("111")

        viewModel.myResponse.observe( this, Observer { response ->
            if(response.isSuccessful) {

                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.headers().toString())

            }
            else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun setUpRecyclerView() {
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
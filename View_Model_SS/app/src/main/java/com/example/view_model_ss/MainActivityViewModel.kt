package com.example.view_model_ss

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var number = 0
    fun addNumber() {
        number++
    }

    override fun onCleared() {
        super.onCleared()
    }
}
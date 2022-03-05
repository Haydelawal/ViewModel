package com.example.view_model_ss

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(name: String):ViewModel() {

    var myName = name

    init {
        Log.d("ViewModel", "Youtube $myName")
    }

}
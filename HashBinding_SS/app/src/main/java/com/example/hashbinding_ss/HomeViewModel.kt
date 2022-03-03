package com.example.hashbinding_ss

import android.util.Log
import androidx.lifecycle.ViewModel
import java.security.MessageDigest

class HomeViewModel : ViewModel() {

    fun getHash(plaintext: String, algorithm: String): String {

        val bytes = MessageDigest.getInstance(algorithm).digest(plaintext.toByteArray())
        return toHex(bytes)

    }


    private fun toHex(byteArray: ByteArray): String {
//        Log.d("ViewModel", byteArray.joinToString("") {"%02x".format(it) })
        return byteArray.joinToString("") {"%02x".format(it) }
    }


}

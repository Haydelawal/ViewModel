package com.example.google_sign_in_ss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.google_sign_in_ss.databinding.ActivityDashboardBinding
import com.example.google_sign_in_ss.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class DashboardActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        val currentUser = mAuth.currentUser
        binding.idTxt.text = currentUser?.uid
        binding.nameTxt.text = currentUser?.email
        binding.emailTxt.text = currentUser?.email


        Glide.with(this).load(currentUser?.photoUrl).into(binding.profileImage)

        binding.signOutBtn.setOnClickListener {
            mAuth.signOut()
            val signOutIntent = Intent(this, SignInActivity::class.java)
            startActivity(signOutIntent)
            finish()
        }

    }
}
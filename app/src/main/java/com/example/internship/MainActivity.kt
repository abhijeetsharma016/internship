package com.example.internship

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        val horseFragment = HorsesFragment()
        fragmentManager.beginTransaction().replace(R.id.fragment_container, horseFragment).commit()

        val previousButton = findViewById<ImageButton>(R.id.previous_button)
        val nextButton = findViewById<ImageButton>(R.id.next_button)

        nextButton.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val currentFragment = fragmentManager.findFragmentById(R.id.fragment_container)
            if (currentFragment is HorsesFragment) {
                previousButton.visibility = View.VISIBLE
                nextButton.visibility = View.GONE
                fragmentTransaction.replace(R.id.fragment_container, CowsFragment())
            }
            fragmentTransaction.commit()
        }

        previousButton.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val currentFragment = fragmentManager.findFragmentById(R.id.fragment_container)
            if (currentFragment is CowsFragment) {
                previousButton.visibility = View.GONE
                nextButton.visibility = View.VISIBLE
                fragmentTransaction.replace(R.id.fragment_container, HorsesFragment())
            }
            fragmentTransaction.commit()
        }
    }
}
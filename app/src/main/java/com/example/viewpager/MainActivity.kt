package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager.adapter.ViewPagerFragmentAdapter
import com.example.viewpager.fragments.FirstFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

   private lateinit var viewPager: ViewPager2
   private lateinit var tabLayout : TabLayout
   private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.TabLayout)
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)

        viewPager.adapter = viewPagerFragmentAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "MAGARIA ${position + 1}"

        }.attach()

    }

}
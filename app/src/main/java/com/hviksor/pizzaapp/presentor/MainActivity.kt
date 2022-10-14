package com.hviksor.pizzaapp.presentor

import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hviksor.pizzaapp.R
import com.hviksor.pizzaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initial()

    }

    private fun initial() {
        with(binding) {
            viewPager.adapter = ViewPagerAdapter(this@MainActivity)
            tableLayout.tabIconTint = null
            TabLayoutMediator(binding.tableLayout, binding.viewPager) { tab, pos ->
                when (pos) {
                    0 -> {
                        tab.setIcon(R.drawable.ic_menu)
                        tab.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.menu_red))

                    }

                    1 -> {
                        tab.setIcon(R.drawable.ic_profile)
                        tab.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.menu_grey))
                    }
                    else -> {
                        tab.setIcon(R.drawable.ic_basket)
                        tab.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.menu_grey))
                    }

                }

            }.attach()
            binding.tableLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.menu_red))
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    tab?.icon?.setTint(ContextCompat.getColor(this@MainActivity, R.color.menu_grey))
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    TODO("Not yet implemented")
                }

            })


        }


    }
}
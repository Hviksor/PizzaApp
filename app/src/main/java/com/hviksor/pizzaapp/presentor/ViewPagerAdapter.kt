package com.hviksor.pizzaapp.presentor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hviksor.pizzaapp.presentor.screen.SecondFragment
import com.hviksor.pizzaapp.presentor.screen.StartFragment
import com.hviksor.pizzaapp.presentor.screen.ThirdFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StartFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()

        }
    }
}
package com.hviksor.pizzaapp.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hviksor.pizzaapp.presentation.screen.FragmentType
import com.hviksor.pizzaapp.presentation.screen.ProfileFragment
import com.hviksor.pizzaapp.presentation.screen.MenuFragment
import com.hviksor.pizzaapp.presentation.screen.CardFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return FragmentType.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (FragmentType.values()[position]) {
            FragmentType.MENU -> MenuFragment()
            FragmentType.PROFILE -> ProfileFragment()
            FragmentType.CARD -> CardFragment()
        }
    }
}
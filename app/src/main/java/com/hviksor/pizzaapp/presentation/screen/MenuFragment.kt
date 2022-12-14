package com.hviksor.pizzaapp.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hviksor.pizzaapp.databinding.FragmentMenuBinding
import com.hviksor.pizzaapp.presentation.screen.category.CategoryAdapter
import com.hviksor.pizzaapp.presentation.screen.products.ProductAdapter

class MenuFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProvider(this)[PizzaViewModel::class.java]
    }
    private val productAdapter by lazy {
        ProductAdapter()
    }

    private val categoryAdapter by lazy {
        CategoryAdapter()
    }
    private val categoryRCView by lazy {
        binding.categoryRcView
    }
    private val productRCView by lazy {
        binding.productsRcView
    }
    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRCView()
        enableViewModelFields()
        shortCategoryClick()
    }

    private fun enableViewModelFields() {
        viewModel.categoryList.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }
        viewModel.productList.observe(viewLifecycleOwner) {
            productAdapter.submitList(it)
        }
    }

    private fun initRCView() {
        categoryRCView.adapter = categoryAdapter
        categoryRCView.itemAnimator?.changeDuration = 0
        productRCView.adapter = productAdapter
    }

    private fun shortCategoryClick() {
        categoryAdapter.categoryItemClick = {
            viewModel.changeEnabled(it)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
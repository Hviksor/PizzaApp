package com.hviksor.pizzaapp.data.network

import android.util.Log
import org.jsoup.Jsoup


class GetWbeInform {

    fun getWeb() {
        try {
            val doc = Jsoup.connect(PIZZA_URI).get()
            val pizzaCatalog = doc.getElementsByAttributeValue("class", CATALOG)
            println(pizzaCatalog.size)
            for (item in pizzaCatalog) {
                val url = item.select("img").attr("src")
                val desc = item.select(".catalog__item-about").text()
                val price = item.select(".catalog__item-price").text()
                val title = item.select(".catalog__item-name").text()
                Log.e("Jssoup",title+price+desc+url)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val PIZZA_URI = "https://pizza-vsem.ru/pomodoro/pizza/"
        private const val CATALOG = "catalog__item catalog__item--long js-item"
    }

}
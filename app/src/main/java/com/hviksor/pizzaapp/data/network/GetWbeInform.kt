package com.hviksor.pizzaapp.data.network

import org.jsoup.Jsoup


class GetWbeInform : ApiService {
    private var lisPizzaInfo = ArrayList<PizzaInfoDto>()

    override suspend fun loadDataPizzaInfo(): ArrayList<PizzaInfoDto> {
        try {
            val doc = Jsoup.connect(PIZZA_URI).get()
            val pizzaCatalog = doc.getElementsByAttributeValue("class", CATALOG)
            println(pizzaCatalog.size)
            for (item in pizzaCatalog) {
                var i = 0
                val url = item.select("img").attr("src")
                val desc = item.select(".catalog__item-about").text()
                val price = item.select(".catalog__item-price").text()
                val title = item.select(".catalog__item-name").text()
                lisPizzaInfo.add(PizzaInfoDto(title, desc, price, url, i))
                i++
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return lisPizzaInfo
    }

    companion object {
        private const val PIZZA_URI = "https://pizza-vsem.ru/pomodoro/pizza/"
        private const val CATALOG = "catalog__item catalog__item--long js-item"
    }

}
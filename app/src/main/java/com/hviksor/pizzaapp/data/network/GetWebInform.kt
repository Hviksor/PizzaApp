package com.hviksor.pizzaapp.data.network

import org.jsoup.Jsoup


class GetWebInform : ApiService {
    private var lisPizzaInfo = ArrayList<PizzaInfoDto>()

    override suspend fun loadDataPizzaInfo(): ArrayList<PizzaInfoDto> {
        try {
            val doc = Jsoup.connect(PIZZA_URI).get()
            val pizzaCatalog = doc.getElementsByAttributeValue("class", CATALOG)
            println(pizzaCatalog.size)
            var pizzaId = DEFAULT_PIZZA_ID
            for (item in pizzaCatalog) {
                val imgUrl = item.select(SELECT_URL).attr(SELECT_URL_ATR)

                val description = item.select(SELECT_DESCRIPTION).text()
                val price = item.select(SELECT_PRICE).text()
                val title = item.select(SELECT_TITLE).text()
                if (!imgUrl.isEmpty()) {
                    lisPizzaInfo.add(PizzaInfoDto(title, description, price, imgUrl, pizzaId))
                    pizzaId++
                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return lisPizzaInfo
    }

    companion object {
        private const val PIZZA_URI = "https://pizza-vsem.ru/pomodoro/pizza/"
        private const val CATALOG = "catalog__item catalog__item--long js-item"
        private const val SELECT_URL = "img"
        private const val SELECT_URL_ATR = "src"
        private const val SELECT_DESCRIPTION = ".catalog__item-about"
        private const val SELECT_PRICE = ".catalog__item-price"
        private const val SELECT_TITLE = ".catalog__item-name"
        private const val DEFAULT_PIZZA_ID = 0


    }

}
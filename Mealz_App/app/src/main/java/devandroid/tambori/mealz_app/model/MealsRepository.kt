package devandroid.tambori.mealz_app.model

import devandroid.tambori.mealz_app.model.api.MealsWebService
import devandroid.tambori.mealz_app.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository (private val webService: MealsWebService = MealsWebService()){
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()

    }
}
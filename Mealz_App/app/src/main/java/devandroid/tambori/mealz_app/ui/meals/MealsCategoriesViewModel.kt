package devandroid.tambori.mealz_app.ui.meals

import androidx.lifecycle.ViewModel
import devandroid.tambori.mealz_app.model.MealsRepository
import devandroid.tambori.mealz_app.model.response.MealResponse
import devandroid.tambori.mealz_app.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel (
    private val repository: MealsRepository = MealsRepository()
):ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?)-> Unit) {
        return repository.getMeals(){
            response -> successCallback(response)
        }
    }
}
package devandroid.tambori.mealz_app.ui.meals

import androidx.lifecycle.ViewModel
import devandroid.tambori.mealz_app.model.MealsRepository
import devandroid.tambori.mealz_app.model.response.MealResponse

class MealsCategoriesViewModel (
    private val repository: MealsRepository = MealsRepository()
):ViewModel() {
    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}
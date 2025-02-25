package devandroid.tambori.mealz_app.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import devandroid.tambori.mealz_app.model.MealsRepository
import devandroid.tambori.mealz_app.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel (
    private val repository: MealsRepository = MealsRepository()
):ViewModel() {
    private val mealsJob = Job()
    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        scope.launch() {
            val meals = getMeals()
            mealsState.value = meals
        }

    }


    val mealsState: MutableState<List<MealResponse>> =  mutableStateOf(emptyList<MealResponse>())

    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }
}
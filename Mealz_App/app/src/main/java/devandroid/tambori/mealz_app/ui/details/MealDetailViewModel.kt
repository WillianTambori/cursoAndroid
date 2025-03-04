package devandroid.tambori.mealz_app.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import devandroid.tambori.mealz_app.model.MealsRepository
import devandroid.tambori.mealz_app.model.response.MealResponse

class MealDetailViewModel(private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val repository: MealsRepository = MealsRepository.getInstance()
    var mealState = mutableStateOf<MealResponse?>(value = null)
    init {
        val mealId = savedStateHandle.get<String>("meal_category_id")?: ""
        mealState.value = repository.getMeal(mealId)

    }

}
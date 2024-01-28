package nl.anno.amsterdam.data.preferences

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_FIRST_TIME = "first_time"
    }

    // MutableStateFlow, der den Status des ersten Starts speichert
    private val _isFirstTimeFlow = MutableStateFlow(isFirstTime())
    val isFirstTimeFlow = _isFirstTimeFlow.asStateFlow()

    // Funktion, um zu prüfen, ob es das erste Mal ist, dass die App geöffnet wird
    fun isFirstTime(): Boolean {
        return sharedPreferences.getBoolean(KEY_FIRST_TIME, true)
    }

    // Funktion, um den Onboarding-Status auf "erledigt" zu setzen
    fun setOnboardingDone() {
        print("Onboarding done!")
        sharedPreferences.edit().putBoolean(KEY_FIRST_TIME, false).apply()
        _isFirstTimeFlow.value = false
    }
}

package nl.anno.amsterdam

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nl.anno.amsterdam.api.BuildingsApi
import nl.anno.amsterdam.data.LocalBuilding
import nl.anno.amsterdam.data.mapBuildingToLocalBuilding
import nl.anno.amsterdam.network.ApiHelper
import java.io.IOException

class MainViewModel : ViewModel() {
    private val _buildings = MutableStateFlow<List<LocalBuilding>>(emptyList())
    val buildings: StateFlow<List<LocalBuilding>> = _buildings.asStateFlow()

    // Add a new MutableStateFlow for status messages
    private val _statusMessage = MutableStateFlow<String?>(null)
    val statusMessage: StateFlow<String?> = _statusMessage.asStateFlow()


    private val _filterCentury  = MutableStateFlow<Int>(-1)
    val filterCentury : StateFlow<Int> = _filterCentury.asStateFlow()

    private val _search = MutableStateFlow<String>("")
    val search: StateFlow<String> = _search.asStateFlow()


    val api = ApiHelper.api

    init {
        fetchBuildings(-1.0, -1.0)
    }

    fun setFilterCentury(cent: Int) {
        viewModelScope.launch {
            _filterCentury.emit(cent)
            fetchBuildings(null, null)
        }
    }

    fun setSearch(search: String) {
        viewModelScope.launch {
            _search.emit(search)
            fetchBuildings(null, null)
        }
    }

    fun fetchBuildings(lat: Double?, long: Double?) {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            // Handle the error here. You can customize the actions accordingly.
            if (throwable is IOException) {
                Log.e("MainViewModel", "Network error: ${throwable.message}")
                _statusMessage.value = "Network error: ${throwable.message}"
            } else {
                Log.e("MainViewModel", "An unexpected error occurred: ${throwable.message}")
                _statusMessage.value = "An unexpected error occurred: ${throwable.message}"
            }
        }

        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            try {
                val list = api.buildingsSlimList(
                    lat?.toBigDecimal(),
                    long?.toBigDecimal(), if(filterCentury.value == -1) null else filterCentury.value,
                    search.value.ifEmpty { null })
                println(list.size)
                _buildings.value = list.map { mapBuildingToLocalBuilding(it) }
                println(buildings.value)
                // Add a success message
                _statusMessage.value = "Buildings fetched successfully!"
            } catch (e: Exception) {
                // Handle the error if it wasn't caught by the CoroutineExceptionHandler

                Log.e("MainViewModel", "An unexpected error occurred: ${e.message}")
                _statusMessage.value = "An unexpected error occurred: ${e.message}"
            }
        }
    }
}

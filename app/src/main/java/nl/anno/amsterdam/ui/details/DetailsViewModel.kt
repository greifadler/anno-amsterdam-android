package nl.anno.amsterdam.ui.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import nl.anno.amsterdam.data.LocalBuilding
import nl.anno.amsterdam.data.LocalImage
import nl.anno.amsterdam.data.mapBuildingToLocalBuilding
import nl.anno.amsterdam.network.ApiHelper
import java.io.IOException

class DetailsViewModel : ViewModel() {

    private val _localBuilding = MutableStateFlow<LocalBuilding?>(null)
    val localBuilding: StateFlow<LocalBuilding?> = _localBuilding.asStateFlow()

    private val _selectedLocalImage = MutableStateFlow<LocalImage?>(null)
    val selectedLocalImage: StateFlow<LocalImage?> = _selectedLocalImage.asStateFlow()

    private val _statusMessage = MutableStateFlow<String?>(null)
    val statusMessage: StateFlow<String?> = _statusMessage.asStateFlow()


    val api = ApiHelper.api

    fun setBuilding(localBuilding: LocalBuilding?) {
        viewModelScope.launch {
            _localBuilding.emit(localBuilding)
            fetchBuildingsDetails()
        }
    }

    fun setSelectedImage(img: LocalImage?) {
        viewModelScope.launch {
            _selectedLocalImage.emit(img)
        }
    }

    fun fetchBuildingsDetails() {
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
            localBuilding.value?.let {
                try {
                    val building = api.buildingsRead(it.id)
                    var x =mapBuildingToLocalBuilding(building)
                    localBuilding.value?.let {
                        x = x.copy(mainLocalImageLink = it.mainLocalImageLink)//TODO: vor abagabe api fixen
                    }
                    _localBuilding.emit(x)

                    _statusMessage.emit("Buildings fetched successfully!")
                } catch (e: Exception) {
                    // Handle the error if it wasn't caught by the CoroutineExceptionHandler

                    Log.e("MainViewModel", "An unexpected error occurred: ${e.message}")
                    _statusMessage.emit("An unexpected error occurred: ${e.message}")
                }
            }
        }
    }

}
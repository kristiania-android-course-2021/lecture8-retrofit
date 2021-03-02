package no.kristinia.myapplication

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import no.kristinia.myapplication.data.API
import no.kristinia.myapplication.data.XkcdService
import no.kristinia.myapplication.data.domain.Comic

class MainViewModel : ViewModel() {

    val xkcdService: XkcdService = API.xkcdService

    private val maxNum = MutableLiveData<Int>()

    private val _currentComic = MutableLiveData<Comic>()
    val currentComic: LiveData<Comic> get() = _currentComic

    init {
        loadLatestComic()
    }

    val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        // TODO: Show an error to the user.
    }

    private fun loadLatestComic() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val latestComic = xkcdService.getLatest()
            maxNum.postValue(latestComic.num)
            _currentComic.postValue(latestComic)
        }
    }

    private fun loadComic(num: Int) {
        if (num > maxNum.value!!) return
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val newComic = xkcdService.getComic(num.toString())
            _currentComic.postValue(newComic)
        }
    }

    fun loadPreviousComic() {
        currentComic.value?.let { currentComic ->
            loadComic(currentComic.num - 1)
        }
    }

    fun loadNextComic() {
        currentComic.value?.let { currentComic ->
            loadComic(currentComic.num + 1)
        }
    }


}
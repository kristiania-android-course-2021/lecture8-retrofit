package no.kristinia.myapplication

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _score = MutableLiveData<Int>(0)
    val score: LiveData<Int> get() = _score


}
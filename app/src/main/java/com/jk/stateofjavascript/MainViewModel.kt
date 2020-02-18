package com.jk.stateofjavascript

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _viewState = MutableLiveData<MainViewState>()
    val viewState: LiveData<MainViewState>
        get() = _viewState

    fun start() {
        viewModelScope.launch {
            try {
                val result = HttpClient.instance.query(AllToolsQuery()).toDeferred().await()
                _viewState.value = MainViewState(result.data()?.survey?.tools?.mapNotNull {
                    it.entity?.let { Tool(it.name!!, it.description) }
                } ?: emptyList())
            } catch (exception: ApolloException) {

            }
        }
    }
}

data class MainViewState(val tools: List<Tool>)

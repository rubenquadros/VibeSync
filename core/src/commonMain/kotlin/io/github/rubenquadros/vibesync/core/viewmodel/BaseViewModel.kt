package io.github.rubenquadros.vibesync.core.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.saved
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.KSerializer

abstract class BaseViewModel<STATE: Any>(
    private val savedStateHandle: SavedStateHandle,
    private val initialState: STATE,
    private val serializer: KSerializer<STATE>
): ViewModel() {

    private val _uiState: MutableStateFlow<STATE> = MutableStateFlow(getOrCreateInitialState())
    val uiState: StateFlow<STATE> = _uiState.asStateFlow()

    fun updateState(reducer: () -> STATE) {
        _uiState.update {
            val newState = reducer()
            savedStateHandle["SAVED_STATE"] = newState
            newState
        }
    }

    private fun getOrCreateInitialState(): STATE {
        val savedState by savedStateHandle.saved(
            key = "SAVED_STATE",
            serializer = serializer
        ){ initialState }
        return savedState
    }
}
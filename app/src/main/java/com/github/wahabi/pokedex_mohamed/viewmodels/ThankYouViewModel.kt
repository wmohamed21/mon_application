package com.github.wahabi.pokedex_mohamed.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wahabi.pokedex_mohamed.repertoire.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ThankYouViewModel @Inject constructor(private val dataStoreRepository: DataStoreRepository) :
    ViewModel() {

    fun saveDialogShown() = viewModelScope.launch {
        dataStoreRepository.saveDialogShown()

    }
}
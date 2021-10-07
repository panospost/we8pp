package com.example.we8.ui.screens.FirstScreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.we8.models.domain.ListItem
import com.example.we8.repository.AppRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    private val repository: AppRepositoryImpl
): ViewModel() {
    var isLoading = mutableStateOf(false)
    var errorMessage = mutableStateOf("")
    var listItems = mutableStateListOf<ListItem>()

    init {
        loadData()
    }

    private fun loadData(){
        isLoading.value = true
        viewModelScope.launch {
           repository.getData().flowOn(Dispatchers.Main).collect {
               isLoading.value = false
               listItems.addAll(it)
           }
        }
    }
}
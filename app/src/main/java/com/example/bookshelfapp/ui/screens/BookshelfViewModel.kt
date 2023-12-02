package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
//import com.example.amphibians.BookshelfApplication
//import com.example.amphibians.data.BookshelfRepository
//import com.example.amphibians.model.Bookshelf
import com.example.bookshelfapp.BookshelfApplication
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BookshelfUState {
//    data class Success(val amphibians: List<Bookshelf>) : BookshelfUiState
//    object Error : BookshelfUiState
//    object Loading : BookshelfUiState
//}
//
//class AmphibiansViewModel(private val amphibiansRepository: BookshelfRepository) : ViewModel() {
//
//    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
//        private set
//
//    init {
//        loadBooks()
//    }
//
//    fun loadBooks(){
//        viewModelScope.launch {
//            amphibiansUiState = BookshelfUiState.Loading
//            amphibiansUiState = try {
//                BookshelfUiState.Success(amphibiansRepository.getAmphibians())
//            } catch (e: IOException) {
//                BookshelfUiState.Error
//            } catch (e: HttpException) {
//                BookshelfUiState.Error
//            }
//        }
//    }
//
//    companion object {
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
//                        as BookshelfApplication)
//                val amphibiansRepository = application.container.amphibiansRepository
//                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
//            }
//        }
//    }
}
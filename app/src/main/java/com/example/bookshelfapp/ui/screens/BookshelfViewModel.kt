package com.example.bookshelfapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelfapp.BookshelfApplication
import com.example.bookshelfapp.data.BookshelfRepository
import com.example.bookshelfapp.model.Book
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BookshelfUiState {
    data class Success(val books: List<Book>) : BookshelfUiState
    object Error : BookshelfUiState
    object Loading : BookshelfUiState
}

class BookshelfViewModel(private val bookshelfRepository: BookshelfRepository) : ViewModel() {

    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    init {
        getBooks("")
        searchBooks("")
        getBookDetails("")
    }

    fun getBooks(query: String) {
        viewModelScope.launch {
            bookshelfUiState = BookshelfUiState.Loading
            bookshelfUiState = try {
                BookshelfUiState.Success(bookshelfRepository.getBooks(query))
            } catch (e: IOException) {
                e.printStackTrace()
                BookshelfUiState.Error
            } catch (e: HttpException) {
                e.printStackTrace()
                BookshelfUiState.Error
            }
        }
    }



    fun searchBooks(query: String) {
        viewModelScope.launch {
            bookshelfUiState = BookshelfUiState.Loading
            bookshelfUiState = try {
                val books = bookshelfRepository.searchBooks(query)
                BookshelfUiState.Success(books)
            } catch (e: IOException) {
                e.printStackTrace()
                BookshelfUiState.Error
            } catch (e: HttpException) {
                e.printStackTrace()
                BookshelfUiState.Error
            }
        }
    }

    fun getBookDetails(bookId: String) {
        viewModelScope.launch {
            bookshelfUiState = BookshelfUiState.Loading
            try {
                val bookDetails = bookshelfRepository.getBookDetails(bookId)
                bookshelfUiState = BookshelfUiState.Success(listOf(bookDetails))
            } catch (e: IOException) {
                e.printStackTrace()
                bookshelfUiState = BookshelfUiState.Error
            } catch (e: HttpException) {
                e.printStackTrace()
                bookshelfUiState = BookshelfUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as BookshelfApplication)
                val bookshelfRepository = application.container.bookshelfRepository
                BookshelfViewModel(bookshelfRepository = bookshelfRepository)
            }
        }
    }


}


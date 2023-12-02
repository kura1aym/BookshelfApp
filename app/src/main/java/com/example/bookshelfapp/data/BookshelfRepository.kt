package com.example.bookshelfapp.data

import com.example.bookshelfapp.model.Book
import com.example.bookshelfapp.model.BookItem
import com.example.bookshelfapp.model.VolumeInfo
import com.example.bookshelfapp.network.BookshelfApiService

class BookshelfRepository(private val googleBooksService: BookshelfApiService) {

    suspend fun searchBooks(query: String): List<Book> {
        val response = googleBooksService.searchBooks(query)
        return response.items.map { it.toBook() }
    }

    suspend fun getBooks(query: String): List<Book> {
        val response = googleBooksService.searchBooks(query)
        return response.items.map { it.toBook() }
    }

    suspend fun getBookDetails(bookId: String): Book {
        val response = googleBooksService.getBookDetails(bookId)
        return response.volumeInfo.toBook(bookId)
    }

    private fun BookItem.toBook(): Book {
        return Book(id, volumeInfo.title, volumeInfo.author, volumeInfo.imageLinks)
    }

    private fun VolumeInfo.toBook(bookId: String): Book {
        return Book(bookId, title, author, imageLinks)
    }

}

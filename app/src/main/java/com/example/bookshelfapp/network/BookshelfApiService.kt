package com.example.bookshelfapp.network

import com.example.bookshelfapp.model.BookDetailsResponse
import com.example.bookshelfapp.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookshelfApiService {
    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BooksResponse

    @GET("volumes/{id}")
    suspend fun getBookDetails(@Path("id") bookId: String): BookDetailsResponse
}


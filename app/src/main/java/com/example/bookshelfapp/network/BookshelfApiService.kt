package com.example.bookshelfapp.network

import com.example.bookshelfapp.model.BookDetailsResponse
import com.example.bookshelfapp.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookshelfApiService {

    @GET("v1/volumes")
    suspend fun searchBooks(@Query("q") query: String): BooksResponse

    @GET("v1/volumes/{id}")
    suspend fun getBookDetails(@Path("id") bookId: String): BookDetailsResponse
}

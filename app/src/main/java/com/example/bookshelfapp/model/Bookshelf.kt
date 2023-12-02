package com.example.bookshelfapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val title: String,
    val authors: List<String>,
    val description: String,
    @SerialName("imageLinks") val imageLinks: ImageLinks
)

@Serializable
data class ImageLinks(
    @SerialName("smallThumbnail") val smallThumbnail: String,
    val thumbnail: String,
    val small: String,
    val medium: String,
    val large: String,
    @SerialName("extraLarge") val extraLarge: String
)

@Serializable
data class BooksResponse(
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val id: String,
    @SerialName("volumeInfo") val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val description: String,
    @SerialName("imageLinks") val imageLinks: ImageLinks
)

@Serializable
data class BookDetailsResponse(
    @SerialName("volumeInfo") val volumeInfo: VolumeInfo
)

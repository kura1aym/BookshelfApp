package com.example.bookshelfapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val id: String,
    val title: String,
    val author: String,
    @SerialName("imageLinks") val imageLinks: ImageLinks
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
    val small: String,
    val medium: String,
    val large: String,
    @SerialName("extraLarge") val extraLarge: String
)

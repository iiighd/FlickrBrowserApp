package com.example.myfliker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    companion object {
        const val apiKey = "4a3f80cf9fdd204a30faa774deaa0bd9"
    }

    @GET("rest/?method=flickr.photos.search&api_key=$apiKey&format=json&nojsoncallback=1")
    fun getPhotos(@Query("text") text: String): Call<PhotoCollection?>?
}
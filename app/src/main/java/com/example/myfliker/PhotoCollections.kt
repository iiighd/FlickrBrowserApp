package com.example.myfliker

import android.provider.Contacts
import com.google.gson.annotations.SerializedName

data class PhotoCollection(
    @SerializedName("photos")
    val photos : Photos,
    @SerializedName("stat")
    val stat: String
    )

data class Photos(
    @SerializedName("Photo")
    val photo:List<photo>,
    @SerializedName("total")
    val total: Int
)
data class photo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server : String,
    @SerializedName("title")
    val title : String
)
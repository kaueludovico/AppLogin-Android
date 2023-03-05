package com.zallpy.applogin.model

import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("username")
    var username: String,
    @SerializedName("password")
    var password: String
)

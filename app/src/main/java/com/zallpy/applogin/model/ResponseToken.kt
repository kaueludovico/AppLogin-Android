package com.zallpy.applogin.model

import com.google.gson.annotations.SerializedName

data class ResponseToken(
    @SerializedName("token")
    var token: String
)

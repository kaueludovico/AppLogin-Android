package com.zallpy.applogin.network

import com.zallpy.applogin.model.Login
import com.zallpy.applogin.model.ResponseToken
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface EndPoint {
    @POST("/auth")
    fun authUser(
        @Body
        userLogin: Login
    ) : Call<ResponseToken>
}
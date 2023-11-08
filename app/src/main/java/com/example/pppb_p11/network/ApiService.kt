package com.example.pppb_p11.network

import com.example.pppb_p11.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("employees")
    fun getAllUser() : Call<Users>
}
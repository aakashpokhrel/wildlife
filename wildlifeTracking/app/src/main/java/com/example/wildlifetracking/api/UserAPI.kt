package com.example.wildlifetracking.api

import com.example.wildlifetracking.entity.User
import com.example.wildlifetracking.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {
    //register user
    @POST("auth/register")
    suspend fun registerUser(
        @Body user : User
    ): Response<LoginResponse>

    //login user
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun checkUser(
        @Field("username") username : String,
        @Field("password") password : String
    ): Response<LoginResponse>
}
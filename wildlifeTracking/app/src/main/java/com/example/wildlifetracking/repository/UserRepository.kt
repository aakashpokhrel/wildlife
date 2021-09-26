package com.example.wildlifetracking.repository

import com.example.wildlifetracking.api.MyApiRequest
import com.example.wildlifetracking.api.ServiceBuilder
import com.example.wildlifetracking.entity.User
import com.example.wildlifetracking.response.LoginResponse

class UserRepository: MyApiRequest() {
    private val UserAPI = ServiceBuilder.buildService(com.example.wildlifetracking.api.UserAPI::class.java)

    //Register User
    suspend fun registerUser(user : User) : LoginResponse {
        return apiRequest {
            UserAPI.registerUser(user)
        }
    }
    suspend fun loginUser(username : String, password : String): LoginResponse {
        return apiRequest {
            UserAPI.checkUser(username, password)
        }
    }
}
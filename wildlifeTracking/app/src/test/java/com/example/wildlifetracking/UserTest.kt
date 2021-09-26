package com.example.wildlifetracking

import com.example.wildlifetracking.entity.User
import com.example.wildlifetracking.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UserTest {
    private lateinit var userRepository: UserRepository

    //Login test
    @Test
    fun checkLogin() = runBlocking {
        userRepository = UserRepository()
        val response = userRepository.loginUser("saksham", "saksham123")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    //registration test
    @Test
    fun registerUser() = runBlocking {
        val user = User(
            fname = "priyanka",
            lname = "magar",
            username = "priyanka",
            password = "priyanka123",

            )
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }



}
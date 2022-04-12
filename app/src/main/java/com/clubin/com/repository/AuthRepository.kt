package com.clubin.com.repository


import com.clubin.com.network.AllApi
import com.clubin.com.utills.UserPreferences
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: AllApi,
    private val preferences: UserPreferences
) : BaseRepository(api) {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }

    suspend fun register(
        name: String,
        age: String,
        email: String,
        password: String
    ) = safeApiCall {
        api.register(name, age, email, password)
    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        preferences.saveAccessTokens(accessToken, refreshToken)
    }

}
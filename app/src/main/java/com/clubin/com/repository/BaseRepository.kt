package com.clubin.com.repository

import com.clubin.com.network.BaseApi
import com.clubin.com.network.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {

    suspend fun logout() = safeApiCall {
        api.logout()
    }
}
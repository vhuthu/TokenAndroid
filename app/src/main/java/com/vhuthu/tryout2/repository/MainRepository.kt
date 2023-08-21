package com.vhuthu.tryout2.repository

import com.vhuthu.tryout2.data.network.ApiService
import com.vhuthu.tryout2.utils.toResultFlow
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {



    fun getDetails() = toResultFlow {

        apiService.getDetails()
    }
}
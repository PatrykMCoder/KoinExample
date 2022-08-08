package com.pmprogramms.koinexample.repo

import com.pmprogramms.koinexample.apiService.ApiService

class Repository (private val apiService: ApiService){
    fun getFacts() = apiService.getFacts()
}
package com.pmprogramms.koinexample.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pmprogramms.koinexample.data.CatFact
import com.pmprogramms.koinexample.repo.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FactsViewModel(private val repo: Repository): ViewModel(), Callback<List<CatFact>> {
    private val _data = MutableLiveData<List<CatFact>>()

    val data: LiveData<List<CatFact>> get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        repo.getFacts().enqueue(this)
    }

    override fun onResponse(call: Call<List<CatFact>>, response: Response<List<CatFact>>) {
        if(response.isSuccessful) {
            _data.postValue(response.body())
        }
    }

    override fun onFailure(call: Call<List<CatFact>>, t: Throwable) {

    }
}
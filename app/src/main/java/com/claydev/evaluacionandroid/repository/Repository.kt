package com.claydev.evaluacionandroid.repository

class Repository {
    suspend fun getTarjeta() = RetrofitCliente.apiService.getTarjeta()
    suspend fun getMovimientos() = RetrofitCliente.apiService.getMovimientos()
}
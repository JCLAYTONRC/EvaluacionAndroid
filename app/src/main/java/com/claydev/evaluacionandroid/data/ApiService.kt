package com.claydev.evaluacionandroid.data

import com.claydev.evaluacionandroid.model.MovimientosModel
import com.claydev.evaluacionandroid.model.TarjetaModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("tarjetacredito.php/1")
    suspend fun getTarjeta(): Response<TarjetaModel>

    @GET("tarjetacredito-movimientos.php/3")
    suspend fun getMovimientos(): Response<List<MovimientosModel>>
}
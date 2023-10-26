package com.claydev.evaluacionandroid.model


import com.google.gson.annotations.SerializedName

data class MovimientosModel(
    @SerializedName("Descripcion")
    val descripcion: String,
    @SerializedName("Fecha")
    val fecha: String,
    @SerializedName("Monto")
    val monto: String,
    @SerializedName("pkMovimientosID")
    val pkMovimientosID: String
)
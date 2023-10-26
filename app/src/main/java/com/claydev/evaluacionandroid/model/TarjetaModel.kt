package com.claydev.evaluacionandroid.model


import com.google.gson.annotations.SerializedName

data class TarjetaModel(
    @SerializedName("CVV")
    val cVV: Int,
    @SerializedName("Fecha_Exp")
    val fechaExp: String,
    @SerializedName("Monto")
    val monto: Int,
    @SerializedName("Nombre_Banco")
    val nombreBanco: String,
    @SerializedName("Numero_Tarjeta")
    val numeroTarjeta: String,
    @SerializedName("pkTarjetaCreditoID")
    val pkTarjetaCreditoID: Int,
    @SerializedName("Titular_Tarjeta")
    val titularTarjeta: String
)
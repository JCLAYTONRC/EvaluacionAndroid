package com.claydev.evaluacionandroid.ui.viewmodels

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.claydev.evaluacionandroid.model.MovimientosModel
import com.claydev.evaluacionandroid.model.TarjetaModel
import com.claydev.evaluacionandroid.repository.Repository
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {
    private val repository = Repository()

    private val _tarjeta = MutableLiveData<TarjetaModel>()
    val tarjeta: LiveData<TarjetaModel> get() = _tarjeta

    private val _movimientos = MutableLiveData<List<MovimientosModel>>()
    val movimientos : LiveData<List<MovimientosModel>> get() = _movimientos

    private val _cvv = MutableLiveData<String>()
    val cvv: LiveData<String> get() = _cvv

    private val _timer = MutableLiveData<String>()
    val timer: LiveData<String> get() = _timer

    fun getTarjeta(){
        viewModelScope.launch {
            val response = repository.getTarjeta()
            _tarjeta.value = response.body()
        }
    }

    fun getMovimientos(){
        viewModelScope.launch {
            val response = repository.getMovimientos()
            _movimientos.value = response.body()
        }
    }

    fun generarCVV(){
        val randomCVV =(100..999).random()
        _cvv.value = randomCVV.toString()
    }

    fun starTimer(){
        object : CountDownTimer(300000, 1000){
            override fun onTick(p0: Long) {
                val minutes = p0 / 60000
                val seconds = (p0 % 60000) / 1000
                _timer.value = "$minutes:${String.format("%02d", seconds)}"
            }

            override fun onFinish() {
                _timer.value = "0:00"
                _cvv.value = ""
            }
        }.start()
    }
}
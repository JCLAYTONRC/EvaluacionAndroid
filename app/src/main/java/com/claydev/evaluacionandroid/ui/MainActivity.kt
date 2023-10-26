package com.claydev.evaluacionandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.claydev.evaluacionandroid.databinding.ActivityMainBinding
import com.claydev.evaluacionandroid.ui.adapters.RecyclerAdapter
import com.claydev.evaluacionandroid.ui.viewmodels.MainViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewModel: MainViewModel
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        recyclerView = mBinding.rvMain
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(emptyList())
        recyclerView.adapter = adapter


        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.getTarjeta()
        mViewModel.getMovimientos()

        mViewModel.tarjeta.observe(this, Observer {tarjeta ->
            with(mBinding){
                tvTitularTarjetaResponse.text = tarjeta.titularTarjeta
                tvFechaExpiracionResponse.text = tarjeta.fechaExp
                tvBanco.text = tarjeta.nombreBanco
            }
        })

        mViewModel.movimientos.observe(this, Observer {movimientos ->
            adapter.updateInfo(movimientos)

        })

        mViewModel.cvv.observe(this,Observer { cvv ->
            mBinding.tvCVVResponse.text = cvv
        })

        mBinding.tvCVVResponse.setOnClickListener {
            mViewModel.generarCVV()
            mViewModel.starTimer()
        }
    }
}
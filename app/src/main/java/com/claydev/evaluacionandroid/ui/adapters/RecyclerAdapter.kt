package com.claydev.evaluacionandroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.claydev.evaluacionandroid.databinding.ItemMovBinding
import com.claydev.evaluacionandroid.model.MovimientosModel

class RecyclerAdapter(private var movimientos: List<MovimientosModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val mBinding = ItemMovBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val movimiento = movimientos[position]
        holder.mBinding.tvFecha.text = movimiento.fecha
        holder.mBinding.tvGasto.text = movimiento.descripcion
        holder.mBinding.tvTotal.text = "-$${movimiento.monto}"
    }

    override fun getItemCount(): Int = movimientos.size

    inner class ViewHolder(val mBinding : ItemMovBinding) : RecyclerView.ViewHolder(mBinding.root){

    }

    fun updateInfo(newMovimientos: List<MovimientosModel>){
        movimientos = newMovimientos
        notifyDataSetChanged()
    }


}
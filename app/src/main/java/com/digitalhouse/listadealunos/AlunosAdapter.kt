package com.digitalhouse.listadealunos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunosAdapter(private val listaAlunos: ArrayList<Aluno>, val listener: OnclickAlunoListener): RecyclerView.Adapter<AlunosAdapter.AlunosViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlunosAdapter.AlunosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_aluno, parent, false)
        return AlunosViewHolder(itemView)
    }

    override fun getItemCount() = listaAlunos.size


    override fun onBindViewHolder(holder: AlunosAdapter.AlunosViewHolder, position: Int) {

        var aluno = listaAlunos.get(position)
        holder.tvNomeAluno.text = aluno.nome

    }

    interface OnclickAlunoListener{
        fun onClickAluno(position: Int)
    }

    inner class AlunosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var tvNomeAluno: TextView = itemView.findViewById(R.id.tvNomeAluno) //outras informações no item aluno seriam inseridas aqui

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View) {
            val position = adapterPosition

            if(position != RecyclerView.NO_POSITION)
                listener.onClickAluno(position)
        }

    }
}
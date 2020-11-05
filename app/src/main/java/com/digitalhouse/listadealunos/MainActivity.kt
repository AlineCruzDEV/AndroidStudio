package com.digitalhouse.listadealunos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AlunosAdapter.OnclickAlunoListener {

    var listAlunos = getAllAlunos()
    var adapter = AlunosAdapter(listAlunos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAlunos.adapter = adapter
        rvAlunos.layoutManager = LinearLayoutManager(this)
        rvAlunos.setHasFixedSize(true)


    }

    //Retorna uma lista de Alunos fixo
    fun getAllAlunos(): ArrayList<Aluno> {

        val aluno1 = Aluno(1, "Rodrigo", 7.0)
        val aluno2 = Aluno(2, "Mateus", 7.0)
        val aluno3 = Aluno(3, "Daniel", 7.0)

        return arrayListOf<Aluno>(aluno1, aluno2, aluno3)

    }

    override fun onClickAluno(position: Int) {
        var aluno = listAlunos.get(position)
        Toast.makeText(this, aluno.nome, Toast.LENGTH_SHORT).show()
    }
}
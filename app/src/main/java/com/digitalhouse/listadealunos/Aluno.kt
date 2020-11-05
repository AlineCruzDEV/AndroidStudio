package com.digitalhouse.listadealunos

class Aluno(val cod: Int, var nome: String, var nota: Double) {

    override fun toString(): String {
        return "Aluno(cod=$cod, nome='$nome', nota=$nota)"
    }
}
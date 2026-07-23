package com.geovani237.gerenciador_academia;

import com.geovani237.gerenciador_academia.controller.AlunoController;
import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Plano;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.AlunoService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        AlunoService service = new AlunoService();
        AlunoController controller = new AlunoController(service);

        Treino treino = new Treino(1L, "Hipertrofia", "Supino Reto", 3, 8);
        Plano plano = new Plano(1L, new BigDecimal("39.99"), "25/07/2026", true);
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Geovani");
        aluno.setTelefone("19999999999");
        aluno.setObjetivo("Ganhar Músculo");
        aluno.setAtivo(true);
        aluno.setMatricula("1234");
        aluno.setTreino(treino);
        aluno.setPlano(plano);

        controller.cadastrar(aluno);
    }
}

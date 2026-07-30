package com.geovani237.gerenciador_academia;

import com.geovani237.gerenciador_academia.controller.AlunoController;
import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Plano;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.AlunoService;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        AlunoService service = new AlunoService();
        AlunoController controller = new AlunoController();
//
//        Treino treino1 = new Treino(1, "Hipertrofia", Set.of(), 3, 8);
//        Treino treino2 = new Treino(2L, "Hipertrofia", "Supino Inclinado", 4, 12);
//
//        Treino treino3 = new Treino(3L, "Hipertrofia", "Supino Inclinado", 4, 12);
//        Plano plano = new Plano(1L, new BigDecimal("39.99"), "25/07/2026", true);

        Treino treino = new Treino();
        treino.setObjetivo("Hipertrofia");
        treino.setExercicio(Set.of("Supino Reto", "Supino Declinado"));
        treino.setRepeticoes(12);
        treino.setSeries(4);

        Plano plano = new Plano();
        plano.setId(1L);
        plano.setStatus(true);
        plano.setValor(new BigDecimal("39.99"));
        plano.setVencimento(1);

        Aluno aluno = new Aluno();
        aluno.setNome("Geovani1");
        aluno.setTelefone("19999999999");
        aluno.setObjetivo("Ganhar Músculo");
        aluno.setTreino(treino);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Geovani2");
        aluno2.setTelefone("19999999999");
        aluno2.setObjetivo("Ganhar Músculo");
        aluno2.setPlano(plano);





//        aluno2.setTreino(List.of(treino1, treino2));
//        aluno2.setPlano(plano);


        controller.cadastrar(aluno);
        controller.cadastrar(aluno2);
        controller.cadastrar(treino);
        controller.checkIn(aluno2);
        controller.checkIn(aluno2);
        controller.checkIn(aluno2);
        controller.listarTodos().forEach(System.out::println);
//        controller.visualizar(aluno2);
    }
}

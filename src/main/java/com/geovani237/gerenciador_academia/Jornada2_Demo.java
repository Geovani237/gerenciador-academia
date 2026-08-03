package com.geovani237.gerenciador_academia;

import com.geovani237.gerenciador_academia.controller.AlunoController;
import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Exercicio;
import com.geovani237.gerenciador_academia.domain.PlanoEnum;
import com.geovani237.gerenciador_academia.domain.Treino;

import java.util.HashMap;
import java.util.Map;

public class Jornada2_Demo {

    public static void main(String[] args) {
        AlunoController controller = new AlunoController();

        // Mock de Aluno
        Aluno aluno = new Aluno(
                "Geovani",
                "123456789",
                "Ganhar massa muscular",
                PlanoEnum.MENSAL
        );
        controller.cadastrar(aluno);

        // Mock de Treino
        Treino treino = new Treino();
        treino.setObjetivo("Hipertrofia");

        Map<String, Exercicio> exercicios = new HashMap<>();
        exercicios.put("Supino Reto", new Exercicio(3, 12));
        exercicios.put("Agachamento", new Exercicio(3, 12));
        //exercicios.put("Supino Reto", new Exercicio(3, 15)); // deve substituir existente
        treino.setExercicios(exercicios);

        //TODO treinoController.cadastrar(treino); // Implementar cadastro de treino no controller

        // Inicio Jornada
        aluno.setTreino(treino);
        //TODO alunoController.atualizarTreino(matricula, treino)

        controller.listarTodos().forEach(System.out::println);
    }

}

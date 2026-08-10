package com.geovani237.gerenciador_academia;

import com.geovani237.gerenciador_academia.controller.AlunoController;
import com.geovani237.gerenciador_academia.controller.TreinoController;
import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Exercicio;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.domain.enums.ObjetivoTreinoEnum;
import com.geovani237.gerenciador_academia.domain.enums.PlanoEnum;

import java.util.HashMap;
import java.util.Map;

public class Jornada2_Demo {

    public static void main(String[] args) {
        System.out.println("JORNADA 2: Montagem de Treino =====================");

        AlunoController alunoController = new AlunoController();
        TreinoController treinoController = new TreinoController();

        // Mock de Aluno
        Aluno aluno = new Aluno(
                "Geovani",
                "123456789",
                "Ganhar massa muscular",
                PlanoEnum.MENSAL
        );
        alunoController.cadastrar(aluno);
        alunoController.listarTodos().forEach(System.out::println);

        // Mock de Treino
        Treino treino = new Treino();
        treino.setObjetivo(ObjetivoTreinoEnum.HIPERTROFIA);

        Map<String, Exercicio> exercicios = new HashMap<>();
        exercicios.put("Supino Reto", new Exercicio(3, 12));
        exercicios.put("Agachamento", new Exercicio(3, 12));
        exercicios.put("Supino Reto", new Exercicio(3, 15)); // deve substituir existente
        treino.setExercicios(exercicios);

        treinoController.cadastrar(treino);

        // Inicio Jornada
        aluno.setTreino(treino);
        alunoController.atualizarTreino(aluno.getMatricula(), treino);
        System.out.println(); //Só para pular linha
        alunoController.listarTreino(aluno.getMatricula()).forEach(System.out::println);
    }

}

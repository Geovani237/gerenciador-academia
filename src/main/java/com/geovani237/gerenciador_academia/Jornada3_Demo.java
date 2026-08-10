package com.geovani237.gerenciador_academia;

import com.geovani237.gerenciador_academia.controller.AlunoController;
import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.enums.PlanoEnum;

public class Jornada3_Demo {

    public static void main(String[] args) {
        System.out.println("JORNADA 3: Check-in na Academia =====================");
        AlunoController controller = new AlunoController();

        // Mock de Aluno
        Aluno aluno = new Aluno(
                "Geovani",
                "123456789",
                "Ganhar massa muscular",
                PlanoEnum.MENSAL
        );

        controller.cadastrar(aluno);
        controller.listarTodos().forEach(System.out::println);

        // Iniciando Jornada
        controller.checkIn(aluno.getMatricula());
        controller.checkIn(aluno.getMatricula());
        controller.checkIn(aluno.getMatricula());
        controller.checkIn(aluno.getMatricula());

        System.out.println(); //Só para pular linha
        controller.listarHistorico(aluno.getMatricula()).forEach(System.out::println);
    }

}

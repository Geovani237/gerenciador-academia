package com.geovani237.gerenciador_academia;

import com.geovani237.gerenciador_academia.controller.AlunoController;
import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.PlanoEnum;

public class Jornada1_Demo {

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
        controller.listarTodos().forEach(System.out::println);
    }

}

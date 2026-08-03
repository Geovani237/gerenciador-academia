package com.geovani237.gerenciador_academia;

import com.geovani237.gerenciador_academia.controller.AlunoController;
import com.geovani237.gerenciador_academia.controller.PagamentoController;
import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.enums.PlanoEnum;

public class Jornada4_Demo {

    public static void main(String[] args) {
        System.out.println("JORNADA 4: Pagamento da Mensalidade =====================");
        AlunoController alunoController = new AlunoController();
        PagamentoController pagamentoController = new PagamentoController();

        // Mock de Aluno
        Aluno aluno = new Aluno(
                "Geovani",
                "123456789",
                "Ganhar massa muscular",
                PlanoEnum.SEMESTRAL
        );

        alunoController.cadastrar(aluno);
        alunoController.listarTodos().forEach(System.out::println);

        // Iniciando Jornada
        System.out.println();
        pagamentoController.listarPagamentos(aluno.getMatricula()).forEach(System.out::println);

        System.out.println();
        pagamentoController.darBaixaPagamento(aluno.getMatricula(), 1);
        pagamentoController.darBaixaPagamento(aluno.getMatricula(), 2);
        pagamentoController.listarPagamentos(aluno.getMatricula()).forEach(System.out::println);
    }

}

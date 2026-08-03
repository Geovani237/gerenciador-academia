package com.geovani237.gerenciador_academia.controller;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.AlunoService;

import java.util.List;

public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController() {
        this.alunoService = new AlunoService();
    }

    public Integer cadastrar(Aluno aluno) {
        return alunoService.cadastro(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    public void checkIn(Integer matricula) {
        alunoService.checkIn(matricula);
    }

    public void atualizarTreino(Integer matricula, Treino treino) {
        alunoService.atualizarTreino(matricula, treino);
    }

    public List<String> listarTreino(Integer matricula) {
        return alunoService.listarTreino(matricula);
    }

    public List<String> listarHistorico(Integer matricula) {
        return alunoService.listarHistorico(matricula);
    }

}

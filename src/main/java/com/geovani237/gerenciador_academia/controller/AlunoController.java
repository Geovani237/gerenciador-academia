package com.geovani237.gerenciador_academia.controller;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//RestController
//RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController() {
        this.alunoService = new AlunoService();
    }

//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastrar(Aluno aluno) {
//        System.out.println(aluno);
        return alunoService.cadastro(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

//    public List<?> visualizar(Aluno aluno) {
//        System.out.println(aluno.getTreino());
//        return alunoService.visualizar(aluno);
//    }
}

package com.geovani237.gerenciador_academia.controller;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.AlunoService;
import com.geovani237.gerenciador_academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//RestController
//RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    private final TreinoService treinoService;

    public AlunoController() {
        this.treinoService = new TreinoService();
        this.alunoService = new AlunoService();
    }

//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastrar(Aluno aluno) {
//        System.out.println(aluno);
        return alunoService.cadastro(aluno);
    }

    public Treino cadastrar(Treino treino) {
        return treinoService.cadastro(treino);
    }

    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

//    public List<?> visualizar(Aluno aluno) {
//        System.out.println(aluno.getTreino());
//        return alunoService.visualizar(aluno);
//    }
}

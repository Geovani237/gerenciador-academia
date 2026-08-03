package com.geovani237.gerenciador_academia.controller;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Plano;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.AlunoService;
import com.geovani237.gerenciador_academia.service.PlanoService;
import com.geovani237.gerenciador_academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

//RestController
//RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController() {
        this.alunoService = new AlunoService();
    }

//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
    public Integer cadastrar(Aluno aluno) {
//        System.out.println(aluno);
        return alunoService.cadastro(aluno);
    }

//    public Treino cadastrar(Treino treino) {
//        return treinoService.cadastro(treino);
//    }

    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    public void checkIn(Aluno aluno) {
        alunoService.checkIn(aluno);
    }

    public void atualizarTreino(Integer matricula, Treino treino) {
        alunoService.atualizarTreino(matricula, treino);
    }

    public List<String> listarTreino(Integer matricula) {
        return alunoService.listarTreino(matricula);
    }

//    public void consultarPlano(Aluno aluno) {
//        planoService.consultar(aluno);
//    }

//    public void pagarMensalidade(Aluno aluno, Plano plano) {
//        planoService.pagarMensalidade(aluno, plano);
//    }



//    public List<?> visualizar(Aluno aluno) {
//        System.out.println(aluno.getTreino());
//        return alunoService.visualizar(aluno);
//    }
}

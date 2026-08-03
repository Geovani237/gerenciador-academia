package com.geovani237.gerenciador_academia.controller;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Plano;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.AlunoService;
import com.geovani237.gerenciador_academia.service.PlanoService;
import com.geovani237.gerenciador_academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//RestController
//RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    private final TreinoService treinoService;

    private final PlanoService planoService;

    public AlunoController() {
        this.treinoService = new TreinoService();
        this.alunoService = new AlunoService();
        this.planoService = new PlanoService();
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

    public void checkIn(Aluno aluno) {
        alunoService.checkIn(aluno);
    }

    public void consultarPlano(Aluno aluno) {
        planoService.consultar(aluno);
    }

    public void pagarMensalidade(Aluno aluno, Plano plano) {
        planoService.pagarMensalidade(aluno, plano);
    }



//    public List<?> visualizar(Aluno aluno) {
//        System.out.println(aluno.getTreino());
//        return alunoService.visualizar(aluno);
//    }
}

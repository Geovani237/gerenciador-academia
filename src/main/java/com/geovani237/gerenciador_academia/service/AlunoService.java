package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.exceptions.BusinessException;
import com.geovani237.gerenciador_academia.repository.AlunoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Service

public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final PagamentoService pagamentoService;


    public AlunoService() {
        this.alunoRepository = new AlunoRepository();
        this.pagamentoService = new PagamentoService();
    }

    public Integer cadastro(Aluno aluno) {

        if (aluno.getNome() == null || aluno.getTelefone() == null) {
            throw new BusinessException("Dados obrigatórios não preenchidos");
        }

        try {
            // Gera novo aluno (matricula)
            Aluno alunoCadastrado = alunoRepository.cadastrar(aluno);

            // Gera plano de pagamento (aluno)
            pagamentoService.cadastrarPlano(alunoCadastrado.getMatricula(), alunoCadastrado.getPlano());

            return alunoCadastrado.getMatricula();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar aluno", e);
        }
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.listarTodos();
    }

    public void checkIn(Integer matricula) {
        
        boolean statusPlano = pagamentoService.verificarStatusPlano(matricula);
        
        // Se valido, faz checkin
        if (statusPlano) {
            Aluno aluno = alunoRepository.buscarPorMatricula(matricula);
            aluno.getHistorico().add(LocalDateTime.now());
        } else {
            throw new BusinessException("Plano do aluno não está ativo. Acesso negado.");
        }
    }

    public void atualizarTreino(Integer matricula, Treino treino) {
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);
        if (aluno != null) {
            aluno.setTreino(treino);
            alunoRepository.atualizar(aluno);
        } else {
            throw new BusinessException("Aluno não encontrado para matrícula: " + matricula);
        }
    }

    public List<String> listarTreino(Integer matricula) {
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);
        if (aluno != null) {
            Treino treino = aluno.getTreino();
            if (treino != null) {
                List<String> exercicios = new ArrayList<>();
                exercicios.add("Aluno: " +  aluno.getNome());
                exercicios.add("Objetivo do treino: " + treino.getObjetivo());
                exercicios.add("=============================");
                treino.getExercicios().forEach((nome, exercicio) -> {
                    exercicios.add("Exercício: " + nome + ", Séries: " + exercicio.getSeries() + ", Repetições: " + exercicio.getRepeticoes());
                });
                return exercicios;
            } else {
                throw new BusinessException("Treino não encontrado para matrícula: " + matricula);
            }
        } else {
            throw new BusinessException("Aluno não encontrado para matrícula: " + matricula);
        }
    }

    public List<String> listarHistorico(Integer matricula) {
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);
        if (aluno != null) {
            List<String> historico = new ArrayList<>();
            historico.add("Aluno: " + aluno.getNome());
            historico.add("Histórico de check-ins:");
            aluno.getHistorico().forEach(data -> historico.add(data.toString()));
            return historico;
        } else {
            throw new BusinessException("Aluno não encontrado para matrícula: " + matricula);
        }
    }


//    public List<?> visualizar(Aluno aluno) {
//
//        for (int i = 0; i < aluno.getTreino().size(); i++) {
//            Treino treino = aluno.getTreino().get(i);
//            System.out.println("--------------------------------");
//            System.out.println(treino.getExercicio());
//            System.out.println("--------------------------------");
//        }
//        return List.of(aluno.getTreino());
//    }

}

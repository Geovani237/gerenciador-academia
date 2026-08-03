package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.exceptions.BusinessException;
import com.geovani237.gerenciador_academia.repository.AlunoRepository;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Service

public class AlunoService {

    private final AlunoRepository alunoRepository;


    public AlunoService() {
        this.alunoRepository = new AlunoRepository();
    }

    public Integer cadastro(Aluno aluno) {

        if (aluno.getNome() == null || aluno.getTelefone() == null) {
            throw new BusinessException("Dados obrigatórios não preenchidos");
        }

        try {
            Aluno alunoCadastrado = alunoRepository.cadastrar(aluno);
            return alunoCadastrado.getMatricula();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar aluno", e);
        }
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.listarTodos();
    }

    public void checkIn(Aluno aluno) {
        //TODO tratar NPE para plano quando se faz check-in

//        if (aluno.getPlano().getStatus()) {
//            List<LocalDateTime> datas = aluno.getHistorico();
//            datas.add(LocalDateTime.now());
//            aluno.setHistorico(datas);
//            System.out.println("Acesso a academia LIBERADO!");
//            System.out.println(aluno.getPlano().getStatus());
//        } else {
//            System.out.println("Acesso a academina NEGADO!");
//            System.out.println(aluno.getPlano().getStatus());
//        }
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

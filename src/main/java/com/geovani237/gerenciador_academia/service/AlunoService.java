package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.repository.AlunoRepository;

import java.util.List;

//@Service
public class AlunoService implements AlunoRepository {

    @Override
    public Aluno cadastro(Aluno aluno) {

        if (aluno.getNome() == null || aluno.getTelefone() == null) {
            throw new IllegalArgumentException();
        }

        return aluno;

    }

    @Override
    public List<?> visualizar(Aluno aluno) {

        for (int i = 0; i < aluno.getTreino().size(); i++) {
            Treino treino = aluno.getTreino().get(i);
            System.out.println("--------------------------------");
            System.out.println(treino.getExercicio());
            System.out.println("--------------------------------");
        }
        return List.of(aluno.getTreino());
    }

}

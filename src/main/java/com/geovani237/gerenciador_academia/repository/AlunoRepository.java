package com.geovani237.gerenciador_academia.repository;

import com.geovani237.gerenciador_academia.domain.Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class AlunoRepository {

    private static final Map<Integer, Aluno> dbAlunos = new HashMap<>();
    private static Integer nextId = 1;

    public Aluno cadastrar(Aluno aluno) {
        aluno.setMatricula(nextId++);
        dbAlunos.put(aluno.getMatricula(), aluno);
        return aluno;
    }

    public void atualizar(Aluno aluno) {
        dbAlunos.put(aluno.getMatricula(), aluno);
    }

    public List<Aluno> listarTodos() {
        return new ArrayList<>(dbAlunos.values());
    }

    public Aluno buscarPorMatricula(Integer matricula) {
        return dbAlunos.get(matricula);
    }
}

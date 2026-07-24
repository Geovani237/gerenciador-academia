package com.geovani237.gerenciador_academia.repository;

import com.geovani237.gerenciador_academia.domain.Aluno;

import java.util.List;

//@Repository
public interface AlunoRepository {

    Aluno cadastro(Aluno aluno);
    List<?> visualizar(Aluno aluno);


}

package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Plano;
import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.repository.AlunoRepository;

import java.math.BigDecimal;

//@Service
public class AlunoService implements AlunoRepository {

    @Override
    public Aluno cadastro(Aluno aluno) {
        return aluno;
    }
}

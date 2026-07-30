package com.geovani237.gerenciador_academia.repository;

import com.geovani237.gerenciador_academia.domain.Treino;

import java.util.HashMap;
import java.util.Map;

public class TreinoRepository {

    private static final Map<Integer, Treino> dbTreino = new HashMap<>();
    private static Integer nextId = 1;

    public Treino cadastrar(Treino treino) {
        treino.setId(nextId++);
        dbTreino.put(treino.getId(), treino);
        return treino;
    }

}

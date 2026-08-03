package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.repository.TreinoRepository;

public class TreinoService {

    private final TreinoRepository treinoRepository;


    public TreinoService() {
        this.treinoRepository = new TreinoRepository();
    }

    public Treino cadastro(Treino treino) {

        return treinoRepository.cadastrar(treino);
    }
}

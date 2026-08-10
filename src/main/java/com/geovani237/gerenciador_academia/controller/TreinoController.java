package com.geovani237.gerenciador_academia.controller;

import com.geovani237.gerenciador_academia.domain.Treino;
import com.geovani237.gerenciador_academia.service.TreinoService;


public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController() {
        this.treinoService = new  TreinoService();
    }

    public Treino cadastrar(Treino treino) {
        return treinoService.cadastro(treino);
    }
}

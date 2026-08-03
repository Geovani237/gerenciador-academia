package com.geovani237.gerenciador_academia.controller;

import com.geovani237.gerenciador_academia.service.PagamentoService;

import java.util.List;

public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController() {
        this.pagamentoService = new PagamentoService();
    }

    public List<String> listarPagamentos(Integer matricula) {
        return pagamentoService.listarPagamentos(matricula);
    }

    public void darBaixaPagamento(Integer matricula, int idPagamento) {
        pagamentoService.darBaixaPagamento(matricula, idPagamento);
    }
}

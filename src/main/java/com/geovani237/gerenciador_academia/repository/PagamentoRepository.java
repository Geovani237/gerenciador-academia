package com.geovani237.gerenciador_academia.repository;

import com.geovani237.gerenciador_academia.domain.Pagamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagamentoRepository {

    private static final Map<Integer, Pagamento> dbPagamentos = new HashMap<>();
    private static Integer nextId = 1;

    public Pagamento cadastrar(Pagamento pagamento) {
        pagamento.setIdPagamento(nextId++);
        dbPagamentos.put(pagamento.getIdPagamento(), pagamento);
        return pagamento;
    }

    public void atualizar(Pagamento pagamento) {
        dbPagamentos.put(pagamento.getIdPagamento(), pagamento);
    }

    public List<Pagamento> listarMensalidades(Integer matricula) {
        return dbPagamentos.values().stream()
                .filter(p -> p.getIdMatricula().equals(matricula))
                .toList();
    }

    public Pagamento buscarPor(Integer matricula, int idPagamento) {
        return dbPagamentos.values().stream()
                .filter(p -> p.getIdMatricula().equals(matricula) && p.getIdPagamento() == idPagamento)
                .findFirst()
                .orElse(null);
    }

}

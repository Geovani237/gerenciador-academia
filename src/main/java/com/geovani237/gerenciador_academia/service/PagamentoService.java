package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Pagamento;
import com.geovani237.gerenciador_academia.domain.enums.PlanoEnum;
import com.geovani237.gerenciador_academia.domain.enums.StatusPagamentoEnum;
import com.geovani237.gerenciador_academia.exceptions.BusinessException;
import com.geovani237.gerenciador_academia.repository.PagamentoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService() {
        this.pagamentoRepository = new PagamentoRepository();
    }

    public void cadastrarPlano(Integer matricula, PlanoEnum plano) {
        if (matricula == null || matricula <= 0) {
            throw new BusinessException("Matrícula inválida");
        }

        if (plano == null) {
            throw new BusinessException("Plano inválido");
        }

        switch (plano) {
            case MENSAL -> {
                cadastrarMensalidade(matricula, plano, 1);
            }
            case SEMESTRAL -> {
                cadastrarMensalidade(matricula, plano, 6);
            }
            case ANUAL -> {
                cadastrarMensalidade(matricula, plano, 12);
            }
            default -> {
                throw new BusinessException("Plano inválido");
            }
        }
    }

    private void cadastrarMensalidade(Integer matricula, PlanoEnum plano, int meses) {
        for (int i = 0; i < meses; i++) {
            Pagamento pagamento = new Pagamento();
            pagamento.setIdMatricula(matricula);
            pagamento.setValor(plano.getValor());
            pagamento.setDtVencimento(LocalDate.now().plusMonths(i + 1));
            pagamento.setStatus(StatusPagamentoEnum.EM_ABERTO);
            pagamentoRepository.cadastrar(pagamento);
        }
    }

    public boolean verificarStatusPlano(Integer matricula) {
        List<Pagamento> mensalidades = pagamentoRepository.listarMensalisades(matricula);

        // Filtrar mensalidade do mes
        Predicate<Pagamento> naoVencido = p -> p.getDtVencimento() != null
                && !p.getDtVencimento().isBefore(LocalDate.now());

        // Filtrar status vencimento
        Predicate<Pagamento> ehStatusValido = p -> p.getStatus() == StatusPagamentoEnum.EM_ABERTO
                || p.getStatus() == StatusPagamentoEnum.PAGO;

        // Encontra o primeiro válido ou NULL
        Pagamento pagamento = mensalidades.stream()
                .filter(naoVencido)
                .filter(ehStatusValido)
                .findFirst()
                .orElse(null);

        return pagamento != null;
    }

}
package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Pagamento;
import com.geovani237.gerenciador_academia.domain.enums.PlanoEnum;
import com.geovani237.gerenciador_academia.domain.enums.StatusPagamentoEnum;
import com.geovani237.gerenciador_academia.exceptions.BusinessException;
import com.geovani237.gerenciador_academia.repository.AlunoRepository;
import com.geovani237.gerenciador_academia.repository.PagamentoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final AlunoRepository alunoRepository;

    public PagamentoService() {
        this.pagamentoRepository = new PagamentoRepository();
        this.alunoRepository = new AlunoRepository();
    }

    public void cadastrarPlano(Integer matricula, PlanoEnum plano) {
        if (matricula == null || matricula <= 0) {
            throw new BusinessException("Matrícula inválida");
        }

        if (plano == null) {
            throw new BusinessException("Plano inválido");
        }

        switch (plano) {
            case MENSAL -> cadastrarMensalidade(matricula, plano, 1);
            case SEMESTRAL -> cadastrarMensalidade(matricula, plano, 6);
            case ANUAL -> cadastrarMensalidade(matricula, plano, 12);
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
        List<Pagamento> mensalidades = pagamentoRepository.listarMensalidades(matricula);

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

    public List<String> listarPagamentos(Integer matricula) {
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);
        if (aluno != null) {
            List<Pagamento> pagamentos = pagamentoRepository.listarMensalidades(matricula);
            if (pagamentos != null) {
                List<String> detalhesPagamentos = new ArrayList<>();
                detalhesPagamentos.add("Aluno: " +  aluno.getNome());
                detalhesPagamentos.add("=============================");
                pagamentos.forEach(pagamento -> detalhesPagamentos.add("Pagamento: " + pagamento.getIdPagamento() + ", Valor: " + pagamento.getValor() + ", Vencimento: " + pagamento.getDtVencimento() + ", Status: " + pagamento.getStatus()));
                return detalhesPagamentos;
            } else {
                throw new BusinessException("Pagamentos não encontrados para matrícula: " + matricula);
            }
        } else {
            throw new BusinessException("Aluno não encontrado para matrícula: " + matricula);
        }
    }

    public void darBaixaPagamento(Integer matricula, int idPagamento) {
        Pagamento pagamento = pagamentoRepository.buscarPor(matricula, idPagamento);
        if (pagamento != null) {
            pagamento.setStatus(StatusPagamentoEnum.PAGO);
            pagamentoRepository.atualizar(pagamento);
        } else {
            throw new BusinessException("Pagamento não encontrado para matrícula: " + matricula + " e idPagamento: " + idPagamento);
        }
    }
}
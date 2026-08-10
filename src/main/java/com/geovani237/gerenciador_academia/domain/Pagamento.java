package com.geovani237.gerenciador_academia.domain;

import com.geovani237.gerenciador_academia.domain.enums.StatusPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pagamento {

    private Integer idPagamento;
    private Integer idMatricula;
    private BigDecimal valor;
    private LocalDate dtVencimento;
    private LocalDate dtPagamento;
    private StatusPagamentoEnum status;

}

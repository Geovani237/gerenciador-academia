package com.geovani237.gerenciador_academia.domain.enums;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum PlanoEnum {
    MENSAL(new BigDecimal("100.0")),
    SEMESTRAL(new BigDecimal("90.0")),
    ANUAL(new BigDecimal("75.0"));

    private final BigDecimal valor;
    PlanoEnum(BigDecimal valor) {
        this.valor = valor;
    }
}

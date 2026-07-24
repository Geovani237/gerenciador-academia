package com.geovani237.gerenciador_academia.domain;

import java.math.BigDecimal;

public class Plano {

    private Long id;
    private BigDecimal valor;
    private String vencimento;
    private Boolean status;

    public Plano(Long id, BigDecimal valor, String vencimento, Boolean status) {
        this.id = id;
        this.valor = valor;
        this.vencimento = vencimento;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return " Plano {\n" +
                "    id=" + id +
                ",\n    valor=" + valor +
                ",\n    vencimento='" + vencimento + '\'' +
                ",\n    status=" + status + "\n"+
                '}';
    }
}

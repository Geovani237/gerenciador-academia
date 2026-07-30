package com.geovani237.gerenciador_academia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Plano {

    private Long id;
    private BigDecimal valor;
    private Integer vencimento;
    private Boolean status;


//    @Override
//    public String toString() {
//        return " Plano {\n" +
//                "    id=" + id +
//                ",\n    valor=" + valor +
//                ",\n    vencimento='" + vencimento + '\'' +
//                ",\n    status=" + status + "\n"+
//                '}';
//    }
}

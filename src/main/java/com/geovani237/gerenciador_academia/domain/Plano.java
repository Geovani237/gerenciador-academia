package com.geovani237.gerenciador_academia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Plano {

    //TODO Alterar vencimento para utilizar datas

    private Long id;
    private BigDecimal valor;
    private Integer vencimento;
    private Boolean status;

//    public void setStatus(Boolean status) {
//        if (getVencimento() == 0){
//            this.status = status;
//        } else {
//            this.status = false;
//        }
//    }

//    public Integer getVencimento() {
//        return vencimento;
//    }

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

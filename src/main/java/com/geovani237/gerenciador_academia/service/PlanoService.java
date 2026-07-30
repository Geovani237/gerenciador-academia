package com.geovani237.gerenciador_academia.service;

import com.geovani237.gerenciador_academia.domain.Aluno;
import com.geovani237.gerenciador_academia.domain.Plano;

public class PlanoService {

    public void consultar(Aluno aluno) {
        //TODO NPE quando consultar aluno sem Plano
        if (aluno.getPlano().getVencimento() > 1) {
            aluno.getPlano().setStatus(false);
        } else {
            aluno.getPlano().setStatus(true);
        }

        System.out.println(aluno.getPlano());
    }

    public void pagarMensalidade(Aluno aluno, Plano plano) {
        if (aluno.getPlano().getVencimento() > 0) {
           Integer parcelasAPagar = aluno.getPlano().getVencimento();

           aluno.getPlano().setVencimento(parcelasAPagar--);

           plano.setVencimento(parcelasAPagar);

           System.out.println("1 Mensalidade foi paga! Sobraram: " + parcelasAPagar);
        }
    }
}

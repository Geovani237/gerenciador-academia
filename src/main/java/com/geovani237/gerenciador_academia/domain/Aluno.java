package com.geovani237.gerenciador_academia.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
public class Aluno {

    private Integer matricula;
    private String nome;
    private String telefone;
    private String objetivo;
//    private String matricula;
//    private List<Treino> treino = new ArrayList<>();
    private Plano plano;

}

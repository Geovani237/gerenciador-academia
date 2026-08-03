package com.geovani237.gerenciador_academia.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
public class Aluno {

    private Integer matricula;
    private String nome;
    private String telefone;
    private String objetivo;
    private Treino treino;
    private Plano plano;
    private List<LocalDateTime> historico = new ArrayList<>();

}

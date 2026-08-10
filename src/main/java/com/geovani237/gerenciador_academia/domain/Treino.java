package com.geovani237.gerenciador_academia.domain;

import com.geovani237.gerenciador_academia.domain.enums.ObjetivoTreinoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Treino {

    private Integer id;
    private ObjetivoTreinoEnum objetivo;
    private Map<String, Exercicio> exercicios;

}

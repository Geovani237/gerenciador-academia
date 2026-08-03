package com.geovani237.gerenciador_academia.domain;

import com.geovani237.gerenciador_academia.domain.enums.PlanoEnum;
import lombok.Data;

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
    private PlanoEnum plano;
    private List<LocalDateTime> historico = new ArrayList<>();

    public Aluno() {
    }
    public Aluno(String nome, String telefone, String objetivo, PlanoEnum plano) {
        this.nome = nome;
        this.telefone = telefone;
        this.objetivo = objetivo;
        this.plano = plano;
    }

}

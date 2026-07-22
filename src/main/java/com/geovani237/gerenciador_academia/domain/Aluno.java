package com.geovani237.gerenciador_academia.domain;

//@Entity
public class Aluno {

    private Long id;
    private String nome;
    private String telefone;
    private String objetivo;
//    private Boolean plano;
    private String matricula;
    private Treino treino;
    private Plano Plano;

    public Aluno() {

    }

    public Aluno(Long id, String nome, String telefone, String objetivo, String matricula, Treino treino, Plano plano) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.objetivo = objetivo;
        this.matricula = matricula;
        this.treino = treino;
        Plano = plano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public Plano getPlano() {
        return Plano;
    }

    public void setPlano(Plano plano) {
        Plano = plano;
    }
}

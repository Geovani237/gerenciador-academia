package com.geovani237.gerenciador_academia.domain;

public class Treino {

    private Long id;
    private String objetivo;
    private String exercicio;
    private Integer series;
    private Integer repeticoes;

    public Treino(Long id, String objetivo, String exercicio, Integer series, Integer repeticoes) {
        this.id = id;
        this.objetivo = objetivo;
        this.exercicio = exercicio;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(Integer repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return " Treino {\n" +
                "    id=" + id +
                ",\n    objetivo='" + objetivo + '\'' +
                ",\n    exercicio='" + exercicio + '\'' +
                ",\n    series=" + series +
                ",\n    repeticoes=" + repeticoes + "\n"+
                '}';
    }
}

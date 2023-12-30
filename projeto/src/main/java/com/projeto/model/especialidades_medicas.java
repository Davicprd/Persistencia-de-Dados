package com.projeto.model;

import java.util.Date;

public class especialidades_medicas {
    private Integer id;
    private String observacao;
    private Date dt_conclusao;
    private Integer id_especialidade;
    private Integer id_medico;

    public especialidades_medicas(Integer id, String observacao, Date dt_conclusao, Integer id_especialidade, Integer id_medico) {
        this.id = id;
        this.observacao = observacao;
        this.dt_conclusao = dt_conclusao;
        this.id_especialidade = id_especialidade;
        this.id_medico = id_medico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDt_conclusao() {
        return dt_conclusao;
    }

    public void setDt_conclusao(Date dt_conclusao) {
        this.dt_conclusao = dt_conclusao;
    }

    public Integer getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(Integer id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public Integer getId_medico() {
        return id_medico;
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    @Override
    public String toString() {
        return "especialidades_medicas {" +
                "id=" + id +
                ", observacao='" + observacao + '\'' +
                ", dt_conclusao=" + dt_conclusao +
                ", id_especialidade=" + id_especialidade +
                ", id_medico=" + id_medico +
                '}';
    }
}

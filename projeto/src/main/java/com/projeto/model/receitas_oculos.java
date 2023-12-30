package com.projeto.model;

import java.util.Date;

public class receitas_oculos {
    private Integer id;
    private String detalhamento;
    private Date dt_consulta;
    private Integer id_consulta_medica;

    public receitas_oculos(Integer id, String detalhamento, Date dt_consulta, Integer id_consulta_medica) {
        this.id = id;
        this.detalhamento = detalhamento;
        this.dt_consulta = dt_consulta;
        this.id_consulta_medica = id_consulta_medica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Date getDt_consulta() {
        return dt_consulta;
    }

    public void setDt_consulta(Date dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Integer getId_consulta_medica() {
        return id_consulta_medica;
    }

    public void setId_consulta_medica(Integer id_consulta_medica) {
        this.id_consulta_medica = id_consulta_medica;
    }

    @Override
    public String toString() {
        return "receitas_oculos {" +
                "id=" + id +
                ", detalhamento='" + detalhamento + '\'' +
                ", dt_consulta=" + dt_consulta +
                ", id_co_msultaMedica=" + id_consulta_medica +
                '}';
    }
}

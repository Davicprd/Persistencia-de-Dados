package com.projeto.model;

import java.util.Date;

public class consultas_medicas {
    private Integer id;
    private String assinatura;
    private Date dt_consulta;
    private Integer id_pacientes;
    private Integer id_medicos;

    public consultas_medicas(Integer id, String assinatura, Date dt_consulta, Integer id_pacientes, Integer id_medicos) {
        this.id = id;
        this.assinatura = assinatura;
        this.dt_consulta = dt_consulta;
        this.id_pacientes = id_pacientes;
        this.id_medicos = id_medicos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public Date getDt_consulta() {
        return dt_consulta;
    }

    public void setDt_consulta(Date dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Integer getId_pacientes() {
        return id_pacientes;
    }

    public void setId_pacientes(Integer id_pacientes) {
        this.id_pacientes = id_pacientes;
    }

    public Integer getId_medicos() {
        return id_medicos;
    }

    public void setId_medicos(Integer id_medicos) {
        this.id_medicos = id_medicos;
    }

    @Override
    public String toString() {
        return "consultas_medicas {" +
                "id=" + id +
                ", assinatura='" + assinatura + '\'' +
                ", dt_consulta=" + dt_consulta +
                ", id_pacientes=" + id_pacientes +
                ", id_medicos=" + id_medicos +
                '}';
    }
}
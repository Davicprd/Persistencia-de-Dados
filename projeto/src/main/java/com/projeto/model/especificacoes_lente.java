package com.projeto.model;

public class especificacoes_lente {
    private Integer id;
    private float valor;
    private Integer id_estruturas_lente;
    private Integer id_atributos_estrutura_lente;

    public especificacoes_lente(Integer id, float valor, Integer id_estruturas_lente, Integer id_atributos_estrutura_lente) {
        this.id = id;
        this.valor = valor;
        this.id_estruturas_lente = id_estruturas_lente;
        this.id_atributos_estrutura_lente = id_atributos_estrutura_lente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getId_estruturas_lente() {
        return id_estruturas_lente;
    }

    public void setId_estruturas_lente(Integer id_estruturas_lente) {
        this.id_estruturas_lente = id_estruturas_lente;
    }

    public Integer getId_atributos_estrutura_lente() {
        return id_atributos_estrutura_lente;
    }

    public void setId_atributos_estrutura_lente(Integer id_atributos_estrutura_lente) {
        this.id_atributos_estrutura_lente = id_atributos_estrutura_lente;
    }

    @Override
    public String toString() {
        return "especificacoes_lente {" +
                "id=" + id +
                ", valor=" + valor +
                ", id_estruturas_lente=" + id_estruturas_lente +
                ", id_atributos_estrutura_lente=" + id_atributos_estrutura_lente +
                '}';
    }
}
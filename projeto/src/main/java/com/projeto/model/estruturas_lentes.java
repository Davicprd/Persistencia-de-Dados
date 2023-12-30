package com.projeto.model;

public class estruturas_lentes {
    private Integer id;
    private String tipo_correcao;
    private int distancia_pupilar;
    private Integer id_receitas_oculos;

    public estruturas_lentes(Integer id, String tipo_correcao, int distancia_pupilar, Integer id_receitas_oculos) {
        this.id = id;
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
        this.id_receitas_oculos = id_receitas_oculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_correcao() {
        return tipo_correcao;
    }

    public void setTipo_correcao(String tipo_correcao) {
        this.tipo_correcao = tipo_correcao;
    }

    public int getDistancia_pupilar() {
        return distancia_pupilar;
    }

    public void setDistancia_pupilar(int distancia_pupilar) {
        this.distancia_pupilar = distancia_pupilar;
    }

    public Integer getId_receitas_oculos() {
        return id_receitas_oculos;
    }

    public void setId_receitas_oculos(Integer id_receitas_oculos) {
        this.id_receitas_oculos = id_receitas_oculos;
    }

    @Override
    public String toString() {
        return "estruturas_lentes {" +
                "id=" + id +
                ", tipo_correcao='" + tipo_correcao + '\'' +
                ", distancia_pupilar=" + distancia_pupilar +
                ", id_receitas_oculos=" + id_receitas_oculos +
                '}';
    }
}
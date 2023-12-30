package com.projeto.model;

public class observacoes_laudos {
    private Integer id;
    private String descricao;
    private Integer id_receitas_oculos;

    public observacoes_laudos(Integer id, String descricao, Integer id_receitas_oculos) {
        this.id = id;
        this.descricao = descricao;
        this.id_receitas_oculos = id_receitas_oculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_receitas_oculos() {
        return id_receitas_oculos;
    }

    public void setId_receitas_oculos(Integer id_receitas_oculos) {
        this.id_receitas_oculos = id_receitas_oculos;
    }

    @Override
    public String toString() {
        return "observacoes_laudos {" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", id_receitas_oculos=" + id_receitas_oculos +
                '}';
    }
}

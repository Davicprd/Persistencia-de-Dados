package com.projeto.model;

public class atributos_estrutura_lente {

  private Integer id;
  private String descricao;
  private String lado_olho;

  public atributos_estrutura_lente(Integer id, String descricao, String lado_olho) {
    this.id = id;
    this.descricao = descricao;
    this.lado_olho = lado_olho;
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

  public String getLado_olho() {
    return lado_olho;
  }

  public void setLado_olho(String lado_olho) {
    this.lado_olho = lado_olho;
  }

  @Override
  public String toString() {
    return "atributos_estrutura_lente {" +
      "id='" + id + "\'" +
      ", descricao='" + descricao + "\'" +
      ", lado_olho='" + lado_olho + "\'" +
      '}';
  }
}

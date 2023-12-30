package com.projeto.model;

public class especialidades {

  private Integer id;
  private String descricao;
  private String conselho;

  public especialidades(Integer id, String descricao, String conselho) {
    this.id = id;
    this.descricao = descricao;
    this.conselho = conselho;
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

  public String getConselho() {
    return conselho;
  }

  public void setConselho(String conselho) {
    this.conselho = conselho;
  }

  @Override
  public String toString() {
    return "especialidades {" +
      "id='" + id + "\'" +
      ", descricao='" + descricao + "\'" +
      ", conselho='" + conselho + "\'" +
      '}';
  }
  
}
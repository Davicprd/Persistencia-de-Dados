package com.projeto.model;

public class medicos {

  private Integer id;
  private String nome;
  private String crm;

  public medicos(Integer id, String nome, String crm) {
    this.id = id;
    this.nome = nome;
    this.crm = crm;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  @Override
  public String toString() {
    return "medicos {" +
      "id='" + id + "\'" +
      ", nome='" + nome + "\'" +
      ", crm='" + crm + "\'" +
      '}';
  }
}
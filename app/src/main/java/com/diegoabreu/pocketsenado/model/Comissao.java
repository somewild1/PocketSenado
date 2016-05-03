package com.diegoabreu.pocketsenado.model;

import java.io.Serializable;

/**
 * Created by Diego on 28/04/16.
 */
public class Comissao implements Serializable {

    private int id;
    private String sigla;
    private String nome;
    private String siglaCasa;
    private String nomeCasa;
    private String dataInicio;
    private String descricaoTipo;

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaCasa() {
        return siglaCasa;
    }

    public void setSiglaCasa(String siglaCasa) {
        this.siglaCasa = siglaCasa;
    }

    public String getNomeCasa() {
        return nomeCasa;
    }

    public void setNomeCasa(String nomeCasa) {
        this.nomeCasa = nomeCasa;
    }

    public static class TipoComissao {
        public static final int PERMANENTE = 1;
        public static final int CPI = 2;
        public static final int TEMPORARIA = 3;
    }

}

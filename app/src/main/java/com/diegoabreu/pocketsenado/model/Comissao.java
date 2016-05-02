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
    private String descricaoSubtitulo;
    private String finalidade;
    private int tipoComissao;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public int getTipoComissao() {
        return tipoComissao;
    }

    public void setTipoComissao(int tipoComissao) {
        this.tipoComissao = tipoComissao;
        if (tipoComissao == 21) {
            tipo = "PERMANENTE";
        } else if (tipoComissao == 22) {
            tipo = "CPI";
        } else {
            tipo = "TEMPORÁRIA";
        }
    }

    public String getDescricaoSubtitulo() {
        return descricaoSubtitulo;
    }

    public void setDescricaoSubtitulo(String descricaoSubtitulo) {
        this.descricaoSubtitulo = descricaoSubtitulo;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
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
        public static final int PERMANENTE = 21;
        public static final int CPI = 22;
        public static final int TEMPORARIA = 121;
    }

}

package com.diegoabreu.pocketsenado.model;

import java.io.Serializable;

/**
 * Created by mtuser on 28/04/16.
 */
public class Comissao implements Serializable {

    private int id;
    private String sigla;
    private String nome;
    private String siglaCasa;
    private String nomeCasa;

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
}

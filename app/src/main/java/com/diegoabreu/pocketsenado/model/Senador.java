package com.diegoabreu.pocketsenado.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;

import com.diegoabreu.pocketsenado.activity.MainActivity;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Diego on 22/04/16.
 */
public class Senador implements Serializable {

    private int id;
    private String nomeAbreviado;
    private String nomeCompleto;
    private String formaTratamento;
    private String foto;
    private String pagina;
    private String email;
    private String partido;
    private String estado;
    private String endereco;
    private String telefone;
    private String dataFiliacao;
    private List<Comissao> comissoes = new ArrayList<>();
    private List<Materia> materias = new ArrayList<>();
    private List<Relatoria> relatorias = new ArrayList<>();

    public void addRelatoria(Relatoria relatoria) {
        this.relatorias.add(relatoria);
    }

    public List<Relatoria> getRelatorias() {
        return relatorias;
    }

    public void setRelatorias(List<Relatoria> relatorias) {
        this.relatorias = relatorias;
    }

    public void addMateria(Materia materia) {
        materias.add(materia);
    }

    public void addMaterias(List<Materia> materias) {
        this.materias.addAll(0, materias);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public void addComissao(Comissao comissao) {
        comissoes.add(comissao);
    }

    public List<Comissao> getComissoes() {
        return comissoes;
    }

    public void setComissoes(List<Comissao> comissoes) {
        this.comissoes = comissoes;
    }

    public String getDataFiliacao() {
        return dataFiliacao;
    }

    public void setDataFiliacao(String dataFiliacao) {
        this.dataFiliacao = dataFiliacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getFormaTratamento() {
        return formaTratamento;
    }

    public void setFormaTratamento(String formaTratamento) {
        this.formaTratamento = formaTratamento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) { this.foto = foto; }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

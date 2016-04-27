package com.diegoabreu.pocketsenado.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;

import com.diegoabreu.pocketsenado.activity.MainActivity;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

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

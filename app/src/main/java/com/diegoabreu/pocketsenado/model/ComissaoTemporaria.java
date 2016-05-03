package com.diegoabreu.pocketsenado.model;

/**
 * Created by mtuser on 03/05/16.
 */
public class ComissaoTemporaria extends Comissao {


    private String descricaoSubtitulo;
    private String finalidade;

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
}

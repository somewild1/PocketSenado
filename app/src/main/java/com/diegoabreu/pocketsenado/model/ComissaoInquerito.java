package com.diegoabreu.pocketsenado.model;

/**
 * Created by Diego on 03/05/16.
 */
public class ComissaoInquerito extends Comissao {

    private String nomeSecretario;
    private String descricaoSubtitulo;
    private String finalidade;

    public String getNomeSecretario() {
        return nomeSecretario;
    }

    public void setNomeSecretario(String nomeSecretario) {
        this.nomeSecretario = nomeSecretario;
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

}

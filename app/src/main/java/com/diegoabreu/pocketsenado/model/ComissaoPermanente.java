package com.diegoabreu.pocketsenado.model;

/**
 * Created by mtuser on 03/05/16.
 */
public class ComissaoPermanente extends Comissao {

    private String nomeSecretario;
    private String enderecoSubSecretaria;
    private String numeroTelefoneSecretaria;
    private String email;
    private String descricaoAgendaReuniao;

    public String getNomeSecretario() {
        return nomeSecretario;
    }

    public void setNomeSecretario(String nomeSecretario) {
        this.nomeSecretario = nomeSecretario;
    }

    public String getEnderecoSubSecretaria() {
        return enderecoSubSecretaria;
    }

    public void setEnderecoSubSecretaria(String enderecoSubSecretaria) {
        this.enderecoSubSecretaria = enderecoSubSecretaria;
    }

    public String getNumeroTelefoneSecretaria() {
        return numeroTelefoneSecretaria;
    }

    public void setNumeroTelefoneSecretaria(String numeroTelefoneSecretaria) {
        this.numeroTelefoneSecretaria = numeroTelefoneSecretaria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoAgendaReuniao() {
        return descricaoAgendaReuniao;
    }

    public void setDescricaoAgendaReuniao(String descricaoAgendaReuniao) {
        this.descricaoAgendaReuniao = descricaoAgendaReuniao;
    }
}

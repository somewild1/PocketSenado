package com.diegoabreu.pocketsenado.model;

import java.util.Date;

/**
 * Created by Diego on 29/04/16.
 */
public class Relatoria {

    private Materia materia;
    private Comissao comissao;
    private String dataDesignacao;

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }

    public String getDataDesignacao() {
        return dataDesignacao;
    }

    public void setDataDesignacao(String dataDesignacao) {
        this.dataDesignacao = dataDesignacao;
    }
}

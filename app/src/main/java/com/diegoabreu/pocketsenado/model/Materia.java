package com.diegoabreu.pocketsenado.model;

/**
 * Created by Diego on 29/04/16.
 */
public class Materia implements Comparable<Materia> {

    private int id;
    private String siglaCasa;
    private String nomeCasa;
    private String siglaTipo;
    private String descricaoTipo;
    private String numero;
    private String ano;
    private String ementa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSiglaTipo() {
        return siglaTipo;
    }

    public void setSiglaTipo(String siglaTipo) {
        this.siglaTipo = siglaTipo;
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    @Override
    public int compareTo(Materia materia) {
        try {
            return Integer.parseInt(materia.getNumero()) - Integer.parseInt(this.getNumero());
        } catch (Exception e) {
            return 1;
        }
    }

}

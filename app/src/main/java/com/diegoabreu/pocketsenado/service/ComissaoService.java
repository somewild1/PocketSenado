package com.diegoabreu.pocketsenado.service;

import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.util.ComissaoParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by mtuser on 04/05/16.
 */
public class ComissaoService {

    private static ComissaoService ourInstance = new ComissaoService();

    public static ComissaoService getInstance() {
        return ourInstance;
    }

    private static List<Comissao> comissoesPermanentes = null;
    private static List<Comissao> comissoesTemporarias = null;
    private static List<Comissao> comissoesInquerito = null;

    HttpURLConnection urlConnection;

    public List<Comissao> getComissoes(int tipo) {
        ComissaoParser comissaoParser = new ComissaoParser();

        if (tipo == Comissao.TipoComissao.PERMANENTE) {

            if (comissoesPermanentes == null)
                comissoesPermanentes = comissaoParser.parsePermanente(getInputStreamComissaoPermanente());
            return comissoesPermanentes;

        } else if (tipo == Comissao.TipoComissao.TEMPORARIA) {

            if (comissoesTemporarias == null)
                comissoesTemporarias = comissaoParser.parseTemporaria(getInputStreamComissaoTemporaria());
            return comissoesTemporarias;

        } else if (tipo == Comissao.TipoComissao.CPI) {

            if (comissoesInquerito == null)
                comissoesInquerito = comissaoParser.parseInquerito(getInputStreamComissaoInquerito());
            return comissoesInquerito;

        } else {
            throw new RuntimeException("Tipo de comissão não esperado.");
        }

    }

    public Comissao getComissao(int id) {
        for (int i = 0; i < getComissoes(Comissao.TipoComissao.PERMANENTE).size(); i++) {
            if (comissoesPermanentes.get(i).getId() == id)
                return comissoesPermanentes.get(i);
        }

        for (int i = 0; i < getComissoes(Comissao.TipoComissao.TEMPORARIA).size(); i++) {
            if (comissoesTemporarias.get(i).getId() == id)
                return comissoesTemporarias.get(i);
        }

        for (int i = 0; i < getComissoes(Comissao.TipoComissao.CPI).size(); i++) {
            if (comissoesInquerito.get(i).getId() == id)
                return comissoesInquerito.get(i);
        }

        return null;
    }

    public InputStream getInputStreamComissaoTemporaria() {
        URL url = null;

        try {

            url = new URL("http://legis.senado.leg.br/dadosabertos/dados/ComissoesTemporarias.xml");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            return urlConnection.getInputStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getInputStreamComissaoPermanente() {
        URL url = null;

        try {

            url = new URL("http://legis.senado.leg.br/dadosabertos/dados/ComissoesPermanentes.xml");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            return urlConnection.getInputStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getInputStreamComissaoInquerito() {
        URL url = null;

        try {

            url = new URL("http://legis.senado.leg.br/dadosabertos/dados/ComissoesInquerito.xml");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            return urlConnection.getInputStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

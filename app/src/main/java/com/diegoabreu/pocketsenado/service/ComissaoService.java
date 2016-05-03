package com.diegoabreu.pocketsenado.service;

import android.util.Log;

import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.util.ComissaoParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by mtuser on 29/04/16.
 */
public class ComissaoService {

    HttpURLConnection urlConnection;

    public InputStream getInputStreamComissao(int tipo) {
        URL url = null;

        try {
            String tipoComissao;

            if (tipo == Comissao.TipoComissao.PERMANENTE) {
                tipoComissao = "permanente";
            } else if (tipo == Comissao.TipoComissao.CPI) {
                tipoComissao = "cpi";
            } else {
                tipoComissao = "temporaria";
            }

            url = new URL("http://legis.senado.gov.br/dadosabertos/comissao/lista/" + tipoComissao);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            return urlConnection.getInputStream();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Comissao> getComissoes(int tipo) {
        List<Comissao> comissoes = null;
        ComissaoParser comissaoParser = new ComissaoParser();

        if (tipo == Comissao.TipoComissao.PERMANENTE) {
            comissoes = comissaoParser.parsePermanente(getInputStreamComissaoPermanente());
        } else if (tipo == Comissao.TipoComissao.TEMPORARIA) {
            comissoes = comissaoParser.parseTemporaria(getInputStreamComissaoTemporaria());
        } else if (tipo == Comissao.TipoComissao.CPI) {
            comissoes = comissaoParser.parseInquerito(getInputStreamComissaoInquerito());
        } else {
            throw new RuntimeException("Tipo de comissão não esperado.");
        }

        return comissoes;
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

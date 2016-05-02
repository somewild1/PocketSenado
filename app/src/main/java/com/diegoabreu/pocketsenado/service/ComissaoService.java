package com.diegoabreu.pocketsenado.service;

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
        List<Comissao> comissoes;

        ComissaoParser comissaoParser = new ComissaoParser();
        comissoes = comissaoParser.parse(getInputStreamComissao(tipo));

        return comissoes;
    }
}

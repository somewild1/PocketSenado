package com.diegoabreu.pocketsenado.service;

import android.util.Log;

import com.diegoabreu.pocketsenado.model.Senador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtuser on 22/04/16.
 */
public class SenadorService {


    HttpURLConnection urlConnection;

    public String getStringSenadores() {
        URL url = null;
        BufferedReader reader = null;

        try {
            url = new URL("http://legis.senado.gov.br/dadosabertos/senador/lista/atual");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            return buffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
    }

    public String getStringSenador(int id) {
        URL url = null;
        BufferedReader reader = null;

        try {
            url = new URL("http://legis.senado.gov.br/dadosabertos/senador/" + id);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            return buffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
    }

    public List<Senador> getSenadores() {
        String senadoresString = getStringSenadores();
        List<Senador> retorno = new ArrayList<>();

        try {
            JSONObject senadoresObject = new JSONObject(senadoresString).getJSONObject("ListaParlamentarEmExercicio");
            JSONArray senadores = senadoresObject.getJSONObject("Parlamentares").getJSONArray("Parlamentar");
            Senador senador;
            for (int i = 0; i < senadores.length(); i++) {
                JSONObject senadorJson = senadores.getJSONObject(i).getJSONObject("IdentificacaoParlamentar");
                senador = new Senador();
                senador.setEmail(senadorJson.getString("EmailParlamentar"));
                senador.setEstado(senadorJson.getString("UfParlamentar"));
                senador.setFormaTratamento(senadorJson.getString("FormaTratamento"));
                senador.setFoto(senadorJson.getString("UrlFotoParlamentar"));
                senador.setId(senadorJson.getInt("CodigoParlamentar"));
                senador.setNomeAbreviado(senadorJson.getString("NomeParlamentar"));
                senador.setNomeCompleto(senadorJson.getString("NomeCompletoParlamentar"));
                senador.setPagina(senadorJson.getString("UrlPaginaParlamentar"));
                senador.setPartido(senadorJson.getString("SiglaPartidoParlamentar"));
                retorno.add(senador);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    //TODO: getSenador()

}

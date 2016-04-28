package com.diegoabreu.pocketsenado.util;

import android.util.Log;

import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.model.Senador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Diego on 28/04/16.
 */
public class SenadorParser {

    public Senador parse(InputStream inputStreamSenador, Senador senador) {

        try {
            // criando um DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // definindo o arquivo que vai ser parseado
            Document document = builder.parse(inputStreamSenador);
            document.getDocumentElement().normalize();

            // pegando a tag root Parlamentar
            Element root = (Element) document.getDocumentElement().getElementsByTagName("Parlamentar").item(0);

            // dados básicos do parlamentar
            Element dadosBasicos = (Element) root.getElementsByTagName("DadosBasicosParlamentar").item(0);
            senador.setEndereco(dadosBasicos.getElementsByTagName("EnderecoParlamentar").item(0).getTextContent());
            senador.setTelefone(dadosBasicos.getElementsByTagName("TelefoneParlamentar").item(0).getTextContent());

            // filiacao do parlamentar
            Element filiacao = (Element) root.getElementsByTagName("FiliacaoAtual").item(0);
            senador.setDataFiliacao(filiacao.getElementsByTagName("DataFiliacao").item(0).getTextContent());

            // comissões
            NodeList comissoes = ((Element) root.getElementsByTagName("MembroAtualComissoes").item(0)).getElementsByTagName("Comissao");
            for (int i = 0; i < comissoes.getLength(); i++) {
                Element comissaoElement = (Element) ((Element) comissoes.item(i)).getElementsByTagName("IdentificacaoComissao").item(0);
                Comissao comissao = new Comissao();
                comissao.setId(Integer.parseInt(comissaoElement.getElementsByTagName("CodigoComissao").item(0).getTextContent()));
                comissao.setNome(comissaoElement.getElementsByTagName("NomeComissao").item(0).getTextContent());
                comissao.setNomeCasa(comissaoElement.getElementsByTagName("NomeCasaComissao").item(0).getTextContent());
                comissao.setSigla(comissaoElement.getElementsByTagName("SiglaComissao").item(0).getTextContent());
                comissao.setSiglaCasa(comissaoElement.getElementsByTagName("SiglaCasaComissao").item(0).getTextContent());

                senador.addComissao(comissao);
            }

            return senador;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

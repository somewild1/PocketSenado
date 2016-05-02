package com.diegoabreu.pocketsenado.util;

import com.diegoabreu.pocketsenado.model.Comissao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Diego on 29/04/16.
 */
public class ComissaoParser {

    //TODO: implementar o parser das comissões
    public List<Comissao> parse(InputStream inputStream) {

        try {
            List<Comissao> comissoes = new ArrayList<>();

            // criando um DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // definindo o arquivo que vai ser parseado
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            // pegando a tag root colegiados
            Element root = (Element) ((Element) document.getDocumentElement().getElementsByTagName("colegiado").item(0)).getElementsByTagName("colegiados").item(0);

            // pegando lista de comissoes
            NodeList comissoesNodeList = root.getElementsByTagName("colegiado");

            for (int i = 0; i < comissoesNodeList.getLength(); i++) {
                Comissao comissao = new Comissao();
                Element comissaoElement = (Element) comissoesNodeList.item(i);

                comissao.setSigla(comissaoElement.getElementsByTagName("SiglaColegiado").item(0).getTextContent());
                comissao.setNomeCasa("Senado Federal");
                comissao.setNome(comissaoElement.getElementsByTagName("NomeColegiado").item(0).getTextContent());
                comissao.setId(Integer.parseInt(comissaoElement.getElementsByTagName("CodigoColegiado").item(0).getTextContent()));
                comissao.setDataInicio(comissaoElement.getElementsByTagName("DataInicio").item(0).getTextContent());
                comissao.setSiglaCasa("SF");
                comissao.setTipoComissao(Integer.parseInt(comissaoElement.getElementsByTagName("CodigoTipoColegiado").item(0).getTextContent()));

                if (comissao.getTipoComissao() != Comissao.TipoComissao.PERMANENTE) {
                    comissao.setFinalidade(comissaoElement.getElementsByTagName("TextoFinalidade").item(0).getTextContent());
                }

                if (comissao.getTipoComissao() == Comissao.TipoComissao.CPI) {
                    comissao.setDescricaoSubtitulo(comissaoElement.getElementsByTagName("DescricaoSubtitulo").item(0).getTextContent());
                }

                comissoes.add(comissao);
            }

            return comissoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

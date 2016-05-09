package com.diegoabreu.pocketsenado.util;

import android.util.Log;

import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.model.ComissaoInquerito;
import com.diegoabreu.pocketsenado.model.ComissaoPermanente;
import com.diegoabreu.pocketsenado.model.ComissaoTemporaria;

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

    public List<Comissao> parseTemporaria(InputStream inputStream) {

        try {
            List<Comissao> comissoes = new ArrayList<>();

            // criando um DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // definindo o arquivo que vai ser parseado
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            // pegando a tag root colegiados
            Element root = (Element) document.getDocumentElement().getElementsByTagName("Colegiados").item(0);

            // pegando lista de comissoes
            NodeList comissoesNodeList = root.getElementsByTagName("Colegiado");

            for (int i = 0; i < comissoesNodeList.getLength(); i++) {
                ComissaoTemporaria comissao = new ComissaoTemporaria();
                Element comissaoElement = (Element) comissoesNodeList.item(i);

                comissao.setSigla(comissaoElement.getElementsByTagName("SiglaColegiado").item(0).getTextContent());
                comissao.setNomeCasa("Senado Federal");
                comissao.setNome(comissaoElement.getElementsByTagName("NomeColegiado").item(0).getTextContent());
                comissao.setId(Integer.parseInt(comissaoElement.getElementsByTagName("CodigoColegiado").item(0).getTextContent()));
                comissao.setDataInicio(comissaoElement.getElementsByTagName("DataInicio").item(0).getTextContent());
                comissao.setDescricaoTipo(comissaoElement.getElementsByTagName("DescricaoTipoColegiado").item(0).getTextContent());
                comissao.setSiglaCasa("SF");
                comissao.setFinalidade(comissaoElement.getElementsByTagName("Finalidade").item(0).getTextContent());

                comissoes.add(comissao);
            }

            return comissoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Comissao> parsePermanente(InputStream inputStream) {

        try {
            List<Comissao> comissoes = new ArrayList<>();

            // criando um DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // definindo o arquivo que vai ser parseado
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            // pegando a tag root colegiados
            Element root = (Element) document.getDocumentElement().getElementsByTagName("Colegiados").item(0);

            // pegando lista de comissoes
            NodeList comissoesNodeList = root.getElementsByTagName("Colegiado");

            for (int i = 0; i < comissoesNodeList.getLength(); i++) {
                ComissaoPermanente comissao = new ComissaoPermanente();
                Element comissaoElement = (Element) comissoesNodeList.item(i);

                comissao.setSigla(comissaoElement.getElementsByTagName("SiglaColegiado").item(0).getTextContent());
                comissao.setNomeCasa("Senado Federal");
                comissao.setNome(comissaoElement.getElementsByTagName("NomeColegiado").item(0).getTextContent());
                comissao.setId(Integer.parseInt(comissaoElement.getElementsByTagName("CodigoColegiado").item(0).getTextContent()));
                comissao.setDataInicio(comissaoElement.getElementsByTagName("DataInicio").item(0).getTextContent());
                comissao.setDescricaoTipo(comissaoElement.getElementsByTagName("DescricaoTipoColegiado").item(0).getTextContent());
                comissao.setSiglaCasa("SF");
                comissao.setNomeSecretario(comissaoElement.getElementsByTagName("NomeSecretario").item(0).getTextContent());
                comissao.setEnderecoSubSecretaria(comissaoElement.getElementsByTagName("EnderecoSubSecretaria").item(0).getTextContent());
                comissao.setNumeroTelefoneSecretaria(comissaoElement.getElementsByTagName("NumeroTelefoneSecretaria").item(0).getTextContent());
                comissao.setEmail(comissaoElement.getElementsByTagName("EnderecoMail").item(0).getTextContent());

                if (comissaoElement.getElementsByTagName("DescricaoAgendaReuniao").item(0) != null)
                    comissao.setDescricaoAgendaReuniao(comissaoElement.getElementsByTagName("DescricaoAgendaReuniao").item(0).getTextContent());
                else
                    comissao.setDescricaoAgendaReuniao("Sem agenda fixa");

                comissoes.add(comissao);
            }

            return comissoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Comissao> parseInquerito(InputStream inputStream) {

        try {
            List<Comissao> comissoes = new ArrayList<>();

            // criando um DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // definindo o arquivo que vai ser parseado
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            // pegando a tag root colegiados
            Element root = (Element) document.getDocumentElement().getElementsByTagName("Colegiados").item(0);

            // pegando lista de comissoes
            NodeList comissoesNodeList = root.getElementsByTagName("Colegiado");

            for (int i = 0; i < comissoesNodeList.getLength(); i++) {
                ComissaoInquerito comissao = new ComissaoInquerito();
                Element comissaoElement = (Element) comissoesNodeList.item(i);

                comissao.setSigla(comissaoElement.getElementsByTagName("SiglaColegiado").item(0).getTextContent());
                comissao.setNomeCasa("Senado Federal");
                comissao.setNome(comissaoElement.getElementsByTagName("NomeColegiado").item(0).getTextContent());
                comissao.setId(Integer.parseInt(comissaoElement.getElementsByTagName("CodigoColegiado").item(0).getTextContent()));
                comissao.setDataInicio(comissaoElement.getElementsByTagName("DataInicio").item(0).getTextContent());
                comissao.setDescricaoTipo(comissaoElement.getElementsByTagName("DescricaoTipoColegiado").item(0).getTextContent());
                comissao.setSiglaCasa("SF");
                if (comissaoElement.getElementsByTagName("NomeSecretario").item(0) != null)
                    comissao.setNomeSecretario(comissaoElement.getElementsByTagName("NomeSecretario").item(0).getTextContent());
                else
                    comissao.setNomeSecretario("Não possui");
                comissao.setDescricaoSubtitulo(comissaoElement.getElementsByTagName("DescricaoSubtitulo").item(0).getTextContent());
                comissao.setFinalidade(comissaoElement.getElementsByTagName("Finalidade").item(0).getTextContent());

                comissoes.add(comissao);
            }

            return comissoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

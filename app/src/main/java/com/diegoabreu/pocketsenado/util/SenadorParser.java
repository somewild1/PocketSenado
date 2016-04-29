package com.diegoabreu.pocketsenado.util;

import android.util.Log;

import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.model.Materia;
import com.diegoabreu.pocketsenado.model.Relatoria;
import com.diegoabreu.pocketsenado.model.Senador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

            // matérias
            NodeList materias = ((Element) root.getElementsByTagName("MateriasDeAutoriaTramitando").item(0)).getElementsByTagName("Materia");
            List<Materia> listMaterias = new ArrayList<>();
            String ultimoAno = "";
            for (int i = 0; i < materias.getLength(); i++) {
                Materia materia = new Materia();
                materia.setEmenta(((Element) materias.item(i)).getElementsByTagName("EmentaMateria").item(0).getTextContent());
                Element materiaElement = (Element) ((Element) materias.item(i)).getElementsByTagName("IdentificacaoMateria").item(0);
                materia.setSiglaCasa(materiaElement.getElementsByTagName("SiglaCasaIdentificacaoMateria").item(0).getTextContent());
                materia.setAno(materiaElement.getElementsByTagName("AnoMateria").item(0).getTextContent());
                materia.setDescricaoTipo(materiaElement.getElementsByTagName("DescricaoSubtipoMateria").item(0).getTextContent());
                materia.setId(Integer.parseInt(materiaElement.getElementsByTagName("CodigoMateria").item(0).getTextContent()));
                materia.setNomeCasa(materiaElement.getElementsByTagName("NomeCasaIdentificacaoMateria").item(0).getTextContent());
                materia.setNumero(materiaElement.getElementsByTagName("NumeroMateria").item(0).getTextContent());
                materia.setSiglaTipo(materiaElement.getElementsByTagName("SiglaSubtipoMateria").item(0).getTextContent());

                if (materia.getAno().equals(ultimoAno) || i == 0) {
                    listMaterias.add(materia);
                    ultimoAno = materia.getAno();
                } else {
                    Collections.sort(listMaterias);
                    senador.addMaterias(listMaterias);
                    listMaterias = new ArrayList<>();
                    listMaterias.add(materia);
                    ultimoAno = materia.getAno();
                }
            }
            if (listMaterias.size() > 0) {
                Collections.sort(listMaterias);
                senador.addMaterias(listMaterias);
            }

            // relatorias
            NodeList relatorias = ((Element) root.getElementsByTagName("RelatoriasAtuais").item(0)).getElementsByTagName("Relatoria");
            List<Relatoria> listRelatoria = new ArrayList<>();
            for (int i = 0; i < relatorias.getLength(); i++) {
                Relatoria relatoria = new Relatoria();

                Materia materia = new Materia();
                Element materiaElement = (Element) ((Element) relatorias.item(i)).getElementsByTagName("Materia").item(0);
                materia.setEmenta(materiaElement.getElementsByTagName("EmentaMateria").item(0).getTextContent());
                materiaElement = (Element) materiaElement.getElementsByTagName("IdentificacaoMateria").item(0);
                materia.setSiglaCasa(materiaElement.getElementsByTagName("SiglaCasaIdentificacaoMateria").item(0).getTextContent());
                materia.setAno(materiaElement.getElementsByTagName("AnoMateria").item(0).getTextContent());
                materia.setDescricaoTipo(materiaElement.getElementsByTagName("DescricaoSubtipoMateria").item(0).getTextContent());
                materia.setId(Integer.parseInt(materiaElement.getElementsByTagName("CodigoMateria").item(0).getTextContent()));
                materia.setNomeCasa(materiaElement.getElementsByTagName("NomeCasaIdentificacaoMateria").item(0).getTextContent());
                materia.setNumero(materiaElement.getElementsByTagName("NumeroMateria").item(0).getTextContent());
                materia.setSiglaTipo(materiaElement.getElementsByTagName("SiglaSubtipoMateria").item(0).getTextContent());

                relatoria.setMateria(materia);

                Element comissaoElement = (Element) ((Element) relatorias.item(i)).getElementsByTagName("IdentificacaoComissao").item(0);
                Comissao comissao = new Comissao();
                comissao.setId(Integer.parseInt(comissaoElement.getElementsByTagName("CodigoComissao").item(0).getTextContent()));
                comissao.setNome(comissaoElement.getElementsByTagName("NomeComissao").item(0).getTextContent());
                comissao.setNomeCasa(comissaoElement.getElementsByTagName("NomeCasaComissao").item(0).getTextContent());
                comissao.setSigla(comissaoElement.getElementsByTagName("SiglaComissao").item(0).getTextContent());
                comissao.setSiglaCasa(comissaoElement.getElementsByTagName("SiglaCasaComissao").item(0).getTextContent());

                relatoria.setComissao(comissao);
                relatoria.setDataDesignacao(((Element) relatorias.item(0)).getElementsByTagName("DataDesignacao").item(0).getTextContent());

                senador.addRelatoria(relatoria);
            }

            return senador;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

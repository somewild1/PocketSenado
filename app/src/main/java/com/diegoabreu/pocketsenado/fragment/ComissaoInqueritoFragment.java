package com.diegoabreu.pocketsenado.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.activity.ComissaoDetailActivity;
import com.diegoabreu.pocketsenado.model.ComissaoInquerito;

import org.w3c.dom.Text;

public class ComissaoInqueritoFragment extends Fragment {

    View myView;
    ComissaoInquerito comissao;
    TextView nomeComissao;
    TextView siglaTipoComissao;
    TextView siglaCasaNomeCasa;
    TextView secretario;
    TextView descricaoSubtitulo;
    TextView finalidade;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_comissao_inquerito, container, false);

        // pegando as instâncias das views
        nomeComissao = (TextView) myView.findViewById(R.id.nome_comissao);
        siglaTipoComissao = (TextView) myView.findViewById(R.id.sigla_tipo_comissao);
        siglaCasaNomeCasa = (TextView) myView.findViewById(R.id.sigla_casa_nome_casa);
        secretario = (TextView) myView.findViewById(R.id.secretario);
        descricaoSubtitulo = (TextView) myView.findViewById(R.id.descricao_subtitulo);
        finalidade = (TextView) myView.findViewById(R.id.finalidade);

        // pegando a instância da comissao da activity mãe do fragment
        comissao = (ComissaoInquerito) ((ComissaoDetailActivity) getActivity()).comissao;

        // trocando o nome do fragment
        getActivity().setTitle(comissao.getSigla());

        // alterando os dados das views
        nomeComissao.setText(comissao.getNome());
        siglaTipoComissao.setText(comissao.getSigla() + " - " + comissao.getDescricaoTipo());
        siglaCasaNomeCasa.setText(comissao.getSiglaCasa() + " | " + comissao.getNomeCasa());
        secretario.setText("Secretário(a): " + comissao.getNomeSecretario());
        descricaoSubtitulo.setText(comissao.getDescricaoSubtitulo());
        finalidade.setText(comissao.getFinalidade());

        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}

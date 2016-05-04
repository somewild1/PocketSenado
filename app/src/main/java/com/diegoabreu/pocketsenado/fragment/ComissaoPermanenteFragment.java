package com.diegoabreu.pocketsenado.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.activity.ComissaoDetailActivity;
import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.model.ComissaoPermanente;

public class ComissaoPermanenteFragment extends Fragment {

    View myView;
    ComissaoPermanente comissao;
    TextView nomeComissao;
    TextView siglaTipoComissao;
    TextView siglaCasaNomeCasa;
    TextView secretario;
    TextView telefone;
    TextView email;
    TextView enderecoSecretaria;
    TextView reunioes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_comissao_permanente, container, false);

        // pegando as instâncias das views
        nomeComissao = (TextView) myView.findViewById(R.id.nome_comissao);
        siglaTipoComissao = (TextView) myView.findViewById(R.id.sigla_tipo_comissao);
        siglaCasaNomeCasa = (TextView) myView.findViewById(R.id.sigla_casa_nome_casa);
        secretario = (TextView) myView.findViewById(R.id.secretario);
        telefone = (TextView) myView.findViewById(R.id.telefone);
        email = (TextView) myView.findViewById(R.id.email);
        enderecoSecretaria = (TextView) myView.findViewById(R.id.endereco_secretaria);
        reunioes = (TextView) myView.findViewById(R.id.reunioes);

        // pegando a instância da comissao da activity mãe do fragment
        comissao = (ComissaoPermanente) ((ComissaoDetailActivity) getActivity()).comissao;

        // trocando o nome do fragment
        getActivity().setTitle(comissao.getSigla());

        // alterando os dados das views
        nomeComissao.setText(comissao.getNome());
        siglaTipoComissao.setText(comissao.getSigla() + " - " + comissao.getDescricaoTipo());
        siglaCasaNomeCasa.setText(comissao.getSiglaCasa() + " | " + comissao.getNomeCasa());
        secretario.setText("Secretário(a): " + comissao.getNomeSecretario());
        telefone.setText("Telefone: " + comissao.getNumeroTelefoneSecretaria());
        email.setText(comissao.getEmail());
        enderecoSecretaria.setText("Secretaria: " + comissao.getEnderecoSubSecretaria());
        reunioes.setText("Reuniões: " + comissao.getDescricaoAgendaReuniao());

        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}

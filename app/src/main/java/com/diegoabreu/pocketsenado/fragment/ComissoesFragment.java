package com.diegoabreu.pocketsenado.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.adapter.ComissaoListAdapter;
import com.diegoabreu.pocketsenado.adapter.SenadorListAdapter;
import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.model.Senador;
import com.diegoabreu.pocketsenado.service.ComissaoService;

import java.util.List;

public class ComissoesFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    View myView;
    ListView lvComissoes;
    ComissaoService comissaoService;
    List<Comissao> comissoesPermanentes;
    List<Comissao> comissoesCPI;
    List<Comissao> comissoesTemporarias;
    ComissaoListAdapter comissaoListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_comissoes, container, false);
        setHasOptionsMenu(true);

        this.lvComissoes = (ListView) myView.findViewById(R.id.list_view_comissoes);
        this.comissaoService = new ComissaoService();


        Spinner spinner = (Spinner) myView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(myView.getContext(),
        R.array.tipos_comissoes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();

        refreshComissoes(Comissao.TipoComissao.PERMANENTE);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Comissões");
    }

    private void refreshComissoes(final int tipoComissao) {
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                return comissaoService.getComissoes((int) objects[0]);
            }

            @Override
            protected void onPostExecute(Object o) {
                if (tipoComissao == Comissao.TipoComissao.PERMANENTE) {
                    comissoesPermanentes = (List<Comissao>) o;
                } else if (tipoComissao == Comissao.TipoComissao.CPI) {
                    comissoesCPI = (List<Comissao>) o;
                } else {
                    comissoesTemporarias = (List<Comissao>) o;
                }

                populateListViewComissao((List<Comissao>) o);
            }
        }.execute(tipoComissao);
    }

    public void populateListViewComissao(List<Comissao> comissaoList) {
        if (getActivity() != null) {
            comissaoListAdapter = new ComissaoListAdapter(getActivity(), comissaoList);
            lvComissoes.setAdapter(comissaoListAdapter);
        }
    }

    //TODO: terminar de terminar a seleção do spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {
            if (comissoesPermanentes != null) {
                comissaoListAdapter = new ComissaoListAdapter(getActivity(), comissoesPermanentes);
                lvComissoes.setAdapter(comissaoListAdapter);
            } else {
                refreshComissoes(Comissao.TipoComissao.PERMANENTE);
            }
        } else if (i == 1) {
            if (comissoesCPI != null) {
                comissaoListAdapter = new ComissaoListAdapter(getActivity(), comissoesCPI);
                lvComissoes.setAdapter(comissaoListAdapter);
            } else {
                refreshComissoes(Comissao.TipoComissao.CPI);
            }
        } else {
            if (comissoesTemporarias != null) {
                comissaoListAdapter = new ComissaoListAdapter(getActivity(), comissoesTemporarias);
                lvComissoes.setAdapter(comissaoListAdapter);
            } else {
                refreshComissoes(Comissao.TipoComissao.TEMPORARIA);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

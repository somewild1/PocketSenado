package com.diegoabreu.pocketsenado.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.model.Relatoria;

import java.util.List;

/**
 * Created by Diego on 29/04/16.
 */
public class SenadorRelatoriaListAdapter extends ArrayAdapter<Relatoria> {

    private Activity context;
    private List<Relatoria> relatorias;

    public SenadorRelatoriaListAdapter(Activity context, List<Relatoria> relatorias) {
        super(context, R.layout.adapter_list_item_senador_relatoria, relatorias);

        this.context = context;
        this.relatorias = relatorias;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null || convertView.findViewById(R.id.ano) != null) {
            convertView = inflater.inflate(R.layout.adapter_list_item_senador_relatoria, null, true);
        }

        if (position == (getCount() - 1)) {
            convertView.setBackgroundResource(R.color.white);
        }

        TextView materia = (TextView) convertView.findViewById(R.id.materia_relatoria);
        TextView comissao = (TextView) convertView.findViewById(R.id.comissao_relatoria);


        materia.setText(
            "MATÉRIA: " +
            this.relatorias.get(position).getMateria().getSiglaCasa() + " " +
            this.relatorias.get(position).getMateria().getSiglaTipo() + " " +
            this.relatorias.get(position).getMateria().getNumero() + "/" +
            this.relatorias.get(position).getMateria().getAno());

        comissao.setText(
            "COMISSÃO: " +
            this.relatorias.get(position).getComissao().getSigla() + " | " +
            this.relatorias.get(position).getComissao().getNomeCasa()
        );

        return convertView;
    }

}

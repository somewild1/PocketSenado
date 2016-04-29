package com.diegoabreu.pocketsenado.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.model.Materia;


import java.util.List;

/**
 * Created by Diego on 29/04/16.
 */
public class SenadorMateriaListAdapter extends ArrayAdapter<Materia> {

    Activity context;
    List<Materia> materias;

    public SenadorMateriaListAdapter(Activity context, List<Materia> materias) {
        super(context, R.layout.adapter_list_item_senador_materia, materias);

        this.materias = materias;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null || convertView.findViewById(R.id.ano) != null) {
            convertView = inflater.inflate(R.layout.adapter_list_item_senador_materia, null, true);
        }

        if (position == 0 || !(this.materias.get(position - 1).getAno().equals(this.materias.get(position).getAno()))) {
            TextView ano = (TextView) convertView.findViewById(R.id.ano);
            ano.setText("Matérias de " + this.materias.get(position).getAno());
            ano.setVisibility(View.VISIBLE);
        }

        TextView tipoMateria = (TextView) convertView.findViewById(R.id.descricao_tipo);
        TextView casaTipoNumeroAno = (TextView) convertView.findViewById(R.id.casa_tipo_numero_ano);

        tipoMateria.setText(this.materias.get(position).getDescricaoTipo());
        casaTipoNumeroAno.setText(
                        this.materias.get(position).getSiglaCasa() + " " +
                        this.materias.get(position).getSiglaTipo() + " " +
                        this.materias.get(position).getNumero() + "/" +
                        this.materias.get(position).getAno());

        return convertView;
    }

}

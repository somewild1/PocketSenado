package com.diegoabreu.pocketsenado.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.model.Comissao;

import java.util.List;

/**
 * Created by mtuser on 02/05/16.
 */
public class ComissaoListAdapter extends ArrayAdapter<Comissao> {

    private Activity context;
    private List<Comissao> comissoes;

    public ComissaoListAdapter(Activity context, List<Comissao> comissoes) {
        super(context, R.layout.adapter_list_comisssao, comissoes);

        this.context = context;
        this.comissoes = comissoes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_list_comisssao, null, true);
        }

        TextView nome = (TextView) convertView.findViewById(R.id.nome_comissao);
        TextView siglaCasa = (TextView) convertView.findViewById(R.id.sigla_e_casa_comissao);

        nome.setText(this.comissoes.get(position).getNome());
        siglaCasa.setText(this.comissoes.get(position).getTipo() + " - "  + this.comissoes.get(position).getSigla() + " | " + getItem(position).getNomeCasa());

        return convertView;
    }

}

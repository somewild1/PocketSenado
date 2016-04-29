package com.diegoabreu.pocketsenado.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.model.Senador;

import java.util.List;

/**
 * Created by mtuser on 28/04/16.
 */
public class SenadorComissaoListAdapter extends ArrayAdapter<Comissao> {

    private Activity context;
    private List<Comissao> comissoes;

    public SenadorComissaoListAdapter(Activity context, List<Comissao> comissoes) {
        super(context, R.layout.adapter_list_item_senador_comisssao, comissoes);

        this.context = context;
        this.comissoes = comissoes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_list_item_senador_comisssao, null, true);
        }

        Log.i("TESTE", position + " | " + getCount());

        if (position == (getCount() - 1)) {
            convertView.setBackgroundResource(R.color.white);
        }

        TextView nome = (TextView) convertView.findViewById(R.id.nome_comissao);
        TextView siglaCasa = (TextView) convertView.findViewById(R.id.sigla_e_casa_comissao);

        nome.setText(this.comissoes.get(position).getNome());
        siglaCasa.setText(this.comissoes.get(position).getSigla() + " | " + getItem(position).getNomeCasa());

        return convertView;
    }

}

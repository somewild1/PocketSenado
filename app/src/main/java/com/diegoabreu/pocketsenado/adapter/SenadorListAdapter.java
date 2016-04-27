package com.diegoabreu.pocketsenado.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.model.Senador;
import com.squareup.picasso.Picasso;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 25/04/16.
 */
public class SenadorListAdapter extends ArrayAdapter<Senador> implements Filterable {

    private Activity context;
    private List<Senador> senadores;
    public List<Senador> filteredSenadores;

    public SenadorListAdapter(Activity context, List<Senador> senadores) {
        super(context, R.layout.adapter_list_item_senador, senadores);

        this.context = context;
        this.senadores = senadores;
        this.filteredSenadores = senadores;
    }

    @Override
    public int getCount() {
        return filteredSenadores.size();
    }

    @Override
    public Senador getItem(int position) {
        return filteredSenadores.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_list_item_senador, null, true);
        }

        ImageView image = (ImageView) convertView.findViewById(R.id.imagemSenador);
        TextView nome = (TextView) convertView.findViewById(R.id.nomeSenador);
        TextView partido = (TextView) convertView.findViewById(R.id.partidoSenador);

        Picasso.with(context).load(getItem(position).getFoto()).resize(64, 80).into(image);
        nome.setText(getItem(position).getNomeAbreviado());
        partido.setText(getItem(position).getPartido() + "/" + getItem(position).getEstado());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredSenadores = (List<Senador>) results.values;
                SenadorListAdapter.this.notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Senador> filteredResults = getFilteredResults(constraint.toString());

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };
    }

    private List<Senador> getFilteredResults(String nome) {
        List<Senador> result = new ArrayList<Senador>();
        nome = nome.toLowerCase().trim();
        nome = Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        String filterableString;

        for (Senador senador: senadores) {
            filterableString = senador.getNomeAbreviado().toLowerCase().trim();
            filterableString = Normalizer.normalize(filterableString, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

            if (filterableString.contains(nome)) {
                result.add(senador);
            }
        }

        return result;
    }
}

package com.diegoabreu.pocketsenado.fragment;


import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.activity.SenadorDetailActivity;
import com.diegoabreu.pocketsenado.adapter.SenadorListAdapter;
import com.diegoabreu.pocketsenado.model.Senador;
import com.diegoabreu.pocketsenado.service.SenadorService;

import java.util.List;

public class SenadoresFragment extends Fragment {

    View myView;
    List<Senador> senadores;
    ListView lvSenadores;
    SenadorService senadorService;
    SenadorListAdapter senadorListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_senadores, container, false);

        setHasOptionsMenu(true);

        this.lvSenadores = (ListView) myView.findViewById(R.id.list_view_senador);
        this.senadorService = new SenadorService();

        this.lvSenadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), SenadorDetailActivity.class);
                intent.putExtra("senador", senadorListAdapter.filteredSenadores.get(i));
                startActivity(intent);
            }
        });

        return myView;
    }

    @Override
    public void onStart() {
        super.onStart();

        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                return senadorService.getSenadores();
            }

            @Override
            protected void onPostExecute(Object o) {
                senadores = (List<Senador>) o;
                populateListViewSenador();
            }
        }.execute();

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Senadores");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.senadores_menu, menu);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                senadorListAdapter.getFilter().filter(newText);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    private void populateListViewSenador() {
        if (getActivity() != null) {
            senadorListAdapter = new SenadorListAdapter(getActivity(), this.senadores);
            lvSenadores.setAdapter(senadorListAdapter);
        }
    }

}

package com.diegoabreu.pocketsenado.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.adapter.SenadorComissaoListAdapter;
import com.diegoabreu.pocketsenado.adapter.SenadorMateriaListAdapter;
import com.diegoabreu.pocketsenado.adapter.SenadorRelatoriaListAdapter;
import com.diegoabreu.pocketsenado.model.Senador;
import com.diegoabreu.pocketsenado.service.SenadorService;
import com.squareup.picasso.Picasso;

public class SenadorDetailActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    Senador senador;

    TextView nomeCompleto;
    TextView filiacao;
    TextView email;
    TextView endereco;
    FrameLayout contentWraper;
    TextView comissoesButton;
    AlertDialog comissoesAlertDialog;
    AlertDialog materiasAlertDialog;
    AlertDialog relatoriasAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senador_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // pegando as instâncias das views
        nomeCompleto = (TextView) findViewById(R.id.nome_completo);
        filiacao = (TextView) findViewById(R.id.filiacao);
        contentWraper = (FrameLayout) findViewById(R.id.content_senador_detail_wrapper);
        comissoesButton = (TextView) findViewById(R.id.comissoes);
        email = (TextView) findViewById(R.id.email);
        endereco = (TextView) findViewById(R.id.endereco);

        // ativando o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // pegando o senador passado para a Intent
        senador = (Senador) getIntent().getExtras().getSerializable("senador");

        // trocando nome na toolbar
        setTitle(senador.getNomeAbreviado());

        // carregando a foto do senador
        Picasso.with(this).load(senador.getFoto()).into((ImageView) findViewById(R.id.header_image));

        // carregando as informações do senador nas views
        new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                SenadorService service = new SenadorService();
                senador = service.getSenador(senador);
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                carregaInformacoes();
                contentWraper.setVisibility(View.VISIBLE);
            }
        }.execute();


    }

    private void carregaInformacoes() {
        nomeCompleto.setText(senador.getFormaTratamento() + senador.getNomeCompleto());

        filiacao.setText(senador.getPartido() + "/" + senador.getEstado() + " desde " + senador.getDataFiliacao());

        email.setText(senador.getEmail());

        endereco.setText(senador.getEndereco());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setAdapter(new SenadorComissaoListAdapter(this, senador.getComissoes()), this);
        comissoesAlertDialog = builder.create();

        builder = new AlertDialog.Builder(this);
        builder.setAdapter(new SenadorMateriaListAdapter(this, senador.getMaterias()), this);
        materiasAlertDialog = builder.create();

        builder = new AlertDialog.Builder(this);
        builder.setAdapter(new SenadorRelatoriaListAdapter(this, senador.getRelatorias()), this);
        relatoriasAlertDialog = builder.create();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return true;
        }
    }

    public void abrirPagina(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(senador.getPagina()));
        startActivity(intent);
    }

    public void abrirComissoes(View view) {
        comissoesAlertDialog.show();
    }

    public void abrirMaterias(View view) { materiasAlertDialog.show(); }

    public void abrirRelatorias(View view) { relatoriasAlertDialog.show(); }

    //TODO: implementar o método onClick das comissões e das matérias
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }

}

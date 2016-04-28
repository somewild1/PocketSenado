package com.diegoabreu.pocketsenado.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.adapter.SenadorComissaoListAdapter;
import com.diegoabreu.pocketsenado.adapter.SenadorListAdapter;
import com.diegoabreu.pocketsenado.model.Senador;
import com.diegoabreu.pocketsenado.service.SenadorService;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.w3c.dom.Text;

import java.io.IOException;

public class SenadorDetailActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    Senador senador;

    TextView nomeCompleto;
    TextView filiacao;
    TextView email;
    TextView endereco;
    FrameLayout contentWraper;
    TextView comissoesButton;
    AlertDialog comissoesAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senador_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // pegando as instâncias das views
        nomeCompleto = (TextView) findViewById(R.id.nome_completo);
        filiacao = (TextView) findViewById(R.id.filiacao);
        contentWraper = (FrameLayout) findViewById(R.id.content_wraper);
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

        //TODO: implementar a abertura da lista de matérias
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

    //TODO: implementar o método onClick das comissões
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }

}

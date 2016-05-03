package com.diegoabreu.pocketsenado.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.fragment.ComissaoPermanenteFragment;
import com.diegoabreu.pocketsenado.model.Comissao;
import com.diegoabreu.pocketsenado.model.ComissaoInquerito;
import com.diegoabreu.pocketsenado.model.ComissaoPermanente;
import com.diegoabreu.pocketsenado.model.ComissaoTemporaria;

public class ComissaoDetailActivity extends AppCompatActivity {

    private Comissao comissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comissao_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        comissao = (Comissao) getIntent().getExtras().getSerializable("comissao");

        // escolhendo o fragment de acordo com o tipo de comissão
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (comissao instanceof ComissaoPermanente) {
            fragmentTransaction.replace(R.id.fragment_container_comissao, new ComissaoPermanenteFragment()).commit();
        } else if (comissao instanceof ComissaoInquerito) {
            fragmentTransaction.replace(R.id.fragment_container_comissao, new ComissaoPermanenteFragment()).commit();
        } else if (comissao instanceof ComissaoTemporaria) {
            fragmentTransaction.replace(R.id.fragment_container_comissao, new ComissaoPermanenteFragment()).commit();
        }

        // ativando o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

}

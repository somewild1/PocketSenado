package com.diegoabreu.pocketsenado.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.diegoabreu.pocketsenado.R;
import com.diegoabreu.pocketsenado.model.Senador;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;

public class SenadorDetailActivity extends AppCompatActivity {

    Senador senador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senador_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // pegando as instâncias das views

        // ativando o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // pegando o senador passado para a Intent
        senador = (Senador) getIntent().getExtras().getSerializable("senador");

        // carregando a foto do senador
        Picasso.with(this).load(senador.getFoto()).into((ImageView) findViewById(R.id.header_image));

        // trocando o título da toolbar
        setTitle(senador.getNomeAbreviado());

        // carregando as informações do senador nas views

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

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(senador.getPagina()));
        startActivity(intent);
    }
}

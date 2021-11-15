package com.marcelo.ifome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.marcelo.ifome.Domain.ComidaDomain;
import com.marcelo.ifome.Helper.ManagementCard;
import com.marcelo.ifome.R;

public class ShowDetalhesActivity extends AppCompatActivity {

    private TextView btnAdicionarAoCarrinho, text_titulo, text_preco, text_descricao, text_quantidade;
    private ImageView btnRemover, btnAdicionar, fotoDaComida;
    private ComidaDomain object;
    private int quantidadeOrdem = 1;
    private ManagementCard managementCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detalhes);

        managementCard = new ManagementCard(this);
        iniciaView();
        getBundle();
    }

    private void getBundle() {
        object = (ComidaDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getFoto(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(fotoDaComida);

        text_titulo.setText(object.getTitulo());
        text_preco.setText(String.valueOf(object.getPreco()));
        text_descricao.setText(object.getDescricao());
        text_quantidade.setText(String.valueOf(quantidadeOrdem));

        btnAdicionar.setOnClickListener(v -> {
            quantidadeOrdem = quantidadeOrdem + 1;
            text_quantidade.setText(String.valueOf(quantidadeOrdem));
        });

        btnRemover.setOnClickListener(v -> {
            if(quantidadeOrdem>1) {
                quantidadeOrdem = quantidadeOrdem - 1;
            }
            text_quantidade.setText(String.valueOf(quantidadeOrdem));
        });

        btnAdicionarAoCarrinho.setOnClickListener(v -> {
            object.setNumberInCard(quantidadeOrdem);
            managementCard.insertComida(object);
        });
    }

    private void iniciaView() {
        btnAdicionarAoCarrinho = findViewById(R.id.btnAdicionarAoCarrinho);
        text_titulo = findViewById(R.id.text_titulo);
        text_preco = findViewById(R.id.text_preco);
        text_descricao = findViewById(R.id.text_descricao);
        text_quantidade = findViewById(R.id.text_quantidade);
        btnRemover = findViewById(R.id.btnRemover);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        fotoDaComida = findViewById(R.id.fotoDaComidaDetalhe);
    }
}
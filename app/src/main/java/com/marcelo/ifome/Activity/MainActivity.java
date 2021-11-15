package com.marcelo.ifome.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.marcelo.ifome.Adapter.CategoryAdapter;
import com.marcelo.ifome.Adapter.PopularAdapter;
import com.marcelo.ifome.Domain.CategoriaDomain;
import com.marcelo.ifome.Domain.ComidaDomain;
import com.marcelo.ifome.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView.Adapter adapterCategorias, adapterPopular;
    RecyclerView recyclerViewListaCategoria, recyclerViewListaPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategoria();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.btnCarrinho);
        LinearLayout btnHome = findViewById(R.id.btnHome);

        floatingActionButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CarrinhoActivity.class)));
        btnHome.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CarrinhoActivity.class)));
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutPopularManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewListaPopular = findViewById(R.id.recyclerViewPopular);
        recyclerViewListaPopular.setLayoutManager(linearLayoutPopularManager);

        ArrayList<ComidaDomain> listaDeComidas = new ArrayList<>();
        listaDeComidas.add(new ComidaDomain("Pizza", "pizza1", "Pizza grande e saborosa", 79.90));
        listaDeComidas.add(new ComidaDomain("Hamburguer", "burger", "Hamburguer grande e saborosa", 29.90));
        listaDeComidas.add(new ComidaDomain("Pizza vegetal", "pizza2", "HotDog grande e saborosa", 9.90));

        adapterPopular = new PopularAdapter(listaDeComidas);
        recyclerViewListaPopular.setAdapter(adapterPopular);
    }

    private void recyclerViewCategoria() {
        LinearLayoutManager linearLayoutCategoriaManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewListaCategoria = findViewById(R.id.recyclerViewListaCategoria);
        recyclerViewListaCategoria.setLayoutManager(linearLayoutCategoriaManager);

        ArrayList<CategoriaDomain> listaDeCategorias = new ArrayList<>();
        listaDeCategorias.add(new CategoriaDomain("Pizza", "cat_1"));
        listaDeCategorias.add(new CategoriaDomain("Burguer", "cat_2"));
        listaDeCategorias.add(new CategoriaDomain("HotDog", "cat_3"));
        listaDeCategorias.add(new CategoriaDomain("Bebidas", "cat_4"));
        listaDeCategorias.add(new CategoriaDomain("Dount", "cat_5"));

        adapterCategorias = new CategoryAdapter(listaDeCategorias);
        recyclerViewListaCategoria.setAdapter(adapterCategorias);
    }


}
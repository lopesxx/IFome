package com.marcelo.ifome.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.marcelo.ifome.Adapter.CarrinhoAdapter;
import com.marcelo.ifome.Helper.ManagementCard;
import com.marcelo.ifome.Interface.ChangeNumberItemListener;
import com.marcelo.ifome.R;

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView.Adapter produtosCarrinhoAdapter;
    private RecyclerView recyclerViewProdutosCarrinho;
    private ManagementCard managementCard;
    private TextView text_totalItems, text_totalFrete, text_TotalCarrinho, text_CarrinhoVazio, btnFinalizarCarrinho;
    private ScrollView scrollViewCarrinho;
    private double preco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        managementCard = new ManagementCard(this);

        iniciarView();
        iniciarLista();
        calcularCarrinho();
        bottomNavigation();
    }


    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.btnCarrinho);
        LinearLayout btnHome = findViewById(R.id.btnHome);

        floatingActionButton.setOnClickListener(v -> startActivity(new Intent(CarrinhoActivity.this, CarrinhoActivity.class)));
        btnHome.setOnClickListener(v -> startActivity(new Intent(CarrinhoActivity.this, MainActivity.class)));
    }

    private void iniciarLista() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewProdutosCarrinho.setLayoutManager(linearLayoutManager);
        produtosCarrinhoAdapter = new CarrinhoAdapter(managementCard.getListaDeComidaDomains(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                calcularCarrinho();
            }
        });
        recyclerViewProdutosCarrinho.setAdapter(produtosCarrinhoAdapter);
        if(managementCard.getListaDeComidaDomains().isEmpty()) {
            text_CarrinhoVazio.setVisibility(View.VISIBLE);
            scrollViewCarrinho.setVisibility(View.GONE);
        } else {
            text_CarrinhoVazio.setVisibility(View.GONE);
            scrollViewCarrinho.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("SetTextI18n")
    private void calcularCarrinho() {
        double taxaDeEntrega = 10;

        preco = Math.round((taxaDeEntrega + managementCard.getPrecoTotal()*100.0)/100.0);
        text_TotalCarrinho.setText("R$ " + preco);
        text_totalFrete.setText("R$ " + taxaDeEntrega);
    }

    private void iniciarView() {
        recyclerViewProdutosCarrinho = findViewById(R.id.recyclerViewProdutosCarrinho);
        text_totalItems = findViewById(R.id.text_valor_total_items);
        text_totalFrete = findViewById(R.id.text_valor_total_entrega);
        text_TotalCarrinho  = findViewById(R.id.text_valor_total);
        text_CarrinhoVazio = findViewById(R.id.text_CarrinhoVazio);
        btnFinalizarCarrinho = findViewById(R.id.btnFinalizarCarrinho);
        scrollViewCarrinho = findViewById(R.id.scrollViewCarrinho);
    }
}
package com.marcelo.ifome.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.marcelo.ifome.Activity.ShowDetalhesActivity;
import com.marcelo.ifome.Domain.ComidaDomain;
import com.marcelo.ifome.Helper.ManagementCard;
import com.marcelo.ifome.Interface.ChangeNumberItemListener;
import com.marcelo.ifome.R;

import java.util.ArrayList;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder> {

    private ArrayList<ComidaDomain> comidaDomains;
    private ManagementCard managementCard;
    private ChangeNumberItemListener changeNumberItemListener;

    public CarrinhoAdapter(ArrayList<ComidaDomain> ComidaDomains, Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.comidaDomains = ComidaDomains;
        this.managementCard = new ManagementCard(context);
        this.changeNumberItemListener =changeNumberItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_carrinho, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nomeDaComidaCarrinho.setText(comidaDomains.get(position).getTitulo());
        holder.precoItem.setText(String.valueOf(comidaDomains.get(position).getPreco()));
        holder.precoTotalItem.setText(String.valueOf(Math.round((comidaDomains.get(position).getPreco() * comidaDomains.get(position).getNumberInCard()) * 100.0)/100.0));
        holder.quantidadeDeItems.setText(String.valueOf(comidaDomains.get(position).getNumberInCard()));


        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(comidaDomains.get(position).getFoto(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.fotoDaComida);

        holder.btnAdicionarItem.setOnClickListener(v -> {
            managementCard.adicionarComida(comidaDomains, position, () -> {
                notifyDataSetChanged();
                changeNumberItemListener.changed();
            });
        });

        holder.btnRemoverItem.setOnClickListener(v -> {
            managementCard.removerComida(comidaDomains, position, () -> {
                notifyDataSetChanged();
                changeNumberItemListener.changed();
            });
        });

    }


    @Override
    public int getItemCount() {
        return comidaDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeDaComidaCarrinho, precoItem, precoTotalItem, quantidadeDeItems;
        ImageView fotoDaComida, btnAdicionarItem, btnRemoverItem;
        ConstraintLayout mainLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeDaComidaCarrinho = itemView.findViewById(R.id.titulo_comida);
            precoItem = itemView.findViewById(R.id.text_preco_item);
            precoTotalItem = itemView.findViewById(R.id.text_preco_total_item);
            fotoDaComida = itemView.findViewById(R.id.fotoDaComidaCarrinho);
            quantidadeDeItems = itemView.findViewById(R.id.text_quantidade_carrinho);
            btnAdicionarItem = itemView.findViewById(R.id.btnAdicionarItemCarrinho);
            btnRemoverItem = itemView.findViewById(R.id.btnRemoverItemCarrinho);
            mainLayout = itemView.findViewById(R.id.item_layout_carrinho);
        }
    }
}

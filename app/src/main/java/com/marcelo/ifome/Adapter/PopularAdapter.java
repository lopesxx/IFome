package com.marcelo.ifome.Adapter;

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
import com.marcelo.ifome.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<ComidaDomain> comidaDomains;

    public PopularAdapter(ArrayList<ComidaDomain> ComidaDomains) {
        this.comidaDomains = ComidaDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nomeDaComida.setText(comidaDomains.get(position).getTitulo());
        holder.precoDaComida.setText(String.valueOf(comidaDomains.get(position).getPreco()));



        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(comidaDomains.get(position).getFoto(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.fotoDaComida);


        holder.btnAdicionarItem.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetalhesActivity.class);
            intent.putExtra("object", comidaDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return comidaDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeDaComida, precoDaComida, btnAdicionarItem;
        ImageView fotoDaComida;
        ConstraintLayout mainLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeDaComida = itemView.findViewById(R.id.nomeDaComida);
            precoDaComida = itemView.findViewById(R.id.precoDaComida);
            fotoDaComida = itemView.findViewById(R.id.fotoDaComida);
            btnAdicionarItem = itemView.findViewById(R.id.btnAdicionarItem);
            mainLayout = itemView.findViewById(R.id.comidaLayout);
        }
    }
}

package com.marcelo.ifome.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.marcelo.ifome.Domain.CategoriaDomain;
import com.marcelo.ifome.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoriaDomain> categoriaDomains;

    public CategoryAdapter(ArrayList<CategoriaDomain> categoriaDomains) {
        this.categoriaDomains = categoriaDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cat, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nomeDaCategoria.setText(categoriaDomains.get(position).getTitulo());
        String fotoUrl = "";
        switch (position) {
            case 0: {
                fotoUrl = "cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_categoria1));
                break;
            }

            case 1: {
                fotoUrl = "cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_categoria2));
                break;
            }

            case 2: {
                fotoUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_categoria3));
                break;
            }

            case 3: {
                fotoUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_categoria4));
                break;
            }

            case 4: {
                fotoUrl = "cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.background_categoria5));
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(fotoUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.fotoDaCategoria);

    }


    @Override
    public int getItemCount() {
        return categoriaDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeDaCategoria;
        ImageView fotoDaCategoria;
        ConstraintLayout mainLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeDaCategoria = itemView.findViewById(R.id.nomeDaCategoria);
            fotoDaCategoria = itemView.findViewById(R.id.fotoDaCategoria);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

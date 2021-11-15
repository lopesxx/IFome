package com.marcelo.ifome.Helper;

import android.content.Context;
import android.widget.Toast;

import com.marcelo.ifome.Domain.ComidaDomain;
import com.marcelo.ifome.Interface.ChangeNumberItemListener;

import java.util.ArrayList;

public class ManagementCard {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCard(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertComida(ComidaDomain item) {
        ArrayList<ComidaDomain> listaDeComidas = getListaDeComidaDomains();

        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listaDeComidas.size(); i++) {
            if(listaDeComidas.get(i).getTitulo().equals(item.getTitulo())){
                existAlready = true;
                n = i;
                break;
            }
        }

        if(existAlready) {
            listaDeComidas.get(n).setNumberInCard(item.getNumberInCard());
        } else {
          listaDeComidas.add(item);
        }
        tinyDB.putListObject("ListaCarrinho", listaDeComidas);
        Toast.makeText(context, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ComidaDomain> getListaDeComidaDomains(){
        return tinyDB.getListObject("ListaCarrinho");
    }

    public void adicionarComida(ArrayList<ComidaDomain> listaDeComida, int position, ChangeNumberItemListener changeNumberItemListener){
        listaDeComida.get(position).setNumberInCard(listaDeComida.get(position).getNumberInCard() + 1);
        tinyDB.putListObject("ListaCarrinho", listaDeComida);
        changeNumberItemListener.changed();
    }

    public void removerComida(ArrayList<ComidaDomain> listaDeComida, int position, ChangeNumberItemListener changeNumberItemListener) {
        if (listaDeComida.get(position).getNumberInCard() == 1) {
            listaDeComida.remove(position);
        } else {
            listaDeComida.get(position).setNumberInCard(listaDeComida.get(position).getNumberInCard() - 1);
        }
        tinyDB.putListObject("ListaCarrinho", listaDeComida);
        changeNumberItemListener.changed();
    }

    public Double getPrecoTotal() {
        ArrayList<ComidaDomain> listaDomainArrayList = getListaDeComidaDomains();
        double preco = 0;
        for (int i = 0; i < listaDomainArrayList.size(); i++) {
            preco = preco + (listaDomainArrayList.get(i).getPreco()*listaDomainArrayList.get(i).getNumberInCard());
        }

        return preco;
    }

}

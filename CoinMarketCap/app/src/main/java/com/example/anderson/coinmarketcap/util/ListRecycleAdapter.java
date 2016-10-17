package com.example.anderson.coinmarketcap.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.anderson.coinmarketcap.InfoMoeda;
import com.example.anderson.coinmarketcap.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by anderson on 07/10/16.
 */
public class ListRecycleAdapter extends RecyclerView.Adapter<ListRecycleAdapter.MyViewHolder>{

    private List<Moedas> moedas;
    private List<String> favoritas = new ArrayList<>();
    private  Context contexto;

    public ListRecycleAdapter(Context context, List<Moedas> moedas) {
        this.moedas = moedas;
        this.contexto = context;
    }

    @Override
    public ListRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.itens_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        if (moedas.get(position).getFavorito() == true){
            holder.ibtnFavoritos.setImageResource(R.drawable.icon_action_favoritos);
        }
        else {
            holder.ibtnFavoritos.setImageResource(R.drawable.icon_add_favorito);

            holder.tvRank.setText("Rank: " + moedas.get(position).getRank());
            holder.tvNome.setText(moedas.get(position).getNome());
            holder.tvMarket.setText("" + format.format(moedas.get(position).getMarket_cap_usd()));
            holder.tvPrice.setText("" + format.format(moedas.get(position).getPrice_usd()));

            if (moedas.get(position).getPercent_change_24h() <= 0) {
                holder.tvPercentual.setText("% " + moedas.get(position).getPercent_change_24h());
                holder.tvPercentual.setTextColor(Color.parseColor("#ff0000"));
                holder.tvPrice.setTextColor(Color.parseColor("#ff0000"));

            } else {
                holder.tvPercentual.setText("% " + moedas.get(position).getPercent_change_24h());
                holder.tvPercentual.setTextColor(Color.parseColor("#008800"));
                holder.tvPrice.setTextColor(Color.parseColor("#008800"));
            }
            holder.favoritos = false;

        }
    }

    @Override
    public int getItemCount() {
        if (moedas == null)
            return 0;
        return moedas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvRank;
        TextView tvNome;
        TextView tvMarket;
        TextView tvPrice;
        TextView tvPercentual;
        ImageButton ibtnDetalhes;
        ImageButton ibtnFavoritos;
        boolean favoritos;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvRank = (TextView)itemView.findViewById(R.id.tvRank);
            tvNome = (TextView)itemView.findViewById(R.id.tvNome);
            tvMarket = (TextView)itemView.findViewById(R.id.tvMarketCap);
            tvPrice = (TextView)itemView.findViewById(R.id.tvPrice);
            tvPercentual = (TextView)itemView.findViewById(R.id.tvPercentual);
            ibtnDetalhes = (ImageButton)itemView.findViewById(R.id.ibtnDetalhes);
            ibtnFavoritos = (ImageButton)itemView.findViewById(R.id.ibtnFavorito);
            favoritos = false;
            ibtnDetalhes.setOnClickListener(this);
            ibtnFavoritos.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.ibtnDetalhes:
                    loadDetalhes();
                    break;
                case R.id.ibtnFavorito:
                    int m = getAdapterPosition();
                    if (moedas.get(m).getFavorito()==true) {
                        ibtnFavoritos.setImageResource(R.drawable.icon_add_favorito);
                        moedas.get(m).setFavorito(false);
                        //favoritas.remove(moedas.get(m).getId());
                    }
                    else {
                        ibtnFavoritos.setImageResource(R.drawable.icon_action_favoritos);
                        moedas.get(m).setFavorito(true);
                        //favoritas.add(moedas.get(m).getId());
                    }
            }

        }

        private void loadDetalhes() {

            int m = getAdapterPosition();
            Moedas moeda = moedas.get(m);
            Bundle b = new Bundle();
            b.putSerializable("moeda",moeda);

            Intent iAbrirInfo = new Intent(contexto,InfoMoeda.class);
            iAbrirInfo.putExtras(b);
            contexto.startActivity(iAbrirInfo);
        }
    }
}

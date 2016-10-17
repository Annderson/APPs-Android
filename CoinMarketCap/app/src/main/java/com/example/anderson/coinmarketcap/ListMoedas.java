package com.example.anderson.coinmarketcap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.anderson.coinmarketcap.conexao.ConnectionHTTP;
import com.example.anderson.coinmarketcap.conexao.ConversionJson;
import com.example.anderson.coinmarketcap.interfaces.ResponseHTTP;
import com.example.anderson.coinmarketcap.util.ListRecycleAdapter;
import com.example.anderson.coinmarketcap.util.Moedas;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ListMoedas extends AppCompatActivity {

    private RecyclerView rvList;
    private List<Moedas> moedas = new ArrayList<Moedas>();
    private ListRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_list);

        obterIds();
        pegarDadosWeb();

        rvList.setHasFixedSize(true);
        GridLayoutManager grid = new GridLayoutManager(this, 1);
        rvList.setLayoutManager(grid);
        adapter = new ListRecycleAdapter(this, moedas);
        adapter.notifyDataSetChanged();
        rvList.setAdapter(adapter);

    }

    private void obterIds() {
        rvList = (RecyclerView)this.findViewById(R.id.rvListRecycle);
    }


    private void pegarDadosWeb() {
        new ConnectionHTTP(new ResponseHTTP() {
            @Override
            public void transicao(String response) throws JSONException {

                ConversionJson json = new ConversionJson();
                moedas.addAll(json.quebradorJSON(response));
                adapter.notifyDataSetChanged();

            }
        }).execute("https://api.coinmarketcap.com/v1/ticker/");
        //https://api.coinmarketcap.com/v1/ticker/
        //https://api.coinmarketcap.com/v1/ticker?limit=10
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_moedas,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_favoritos:
                loadListFavorito();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadListFavorito() {

        final Intent iAbrirF = new Intent(this,ListFavoritos.class);
        startActivity(iAbrirF);

    }
}

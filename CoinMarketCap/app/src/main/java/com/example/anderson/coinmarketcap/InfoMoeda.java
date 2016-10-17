package com.example.anderson.coinmarketcap;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anderson.coinmarketcap.util.Moedas;

import java.text.NumberFormat;
import java.util.Locale;

public class InfoMoeda extends AppCompatActivity {

    private TextView infoRank;
    private TextView infoNome;
    private TextView infoSymbol;
    private TextView infoPreco;
    private TextView infoVolume;
    private TextView infoValorMercado;
    private TextView infoFornecimento;
    private TextView infoVariacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_moeda);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            obterIds();
            povoandoText(bundle);
        }
        else
            Toast.makeText(this, "Moeda recebida é nula ou vazia", Toast.LENGTH_LONG);

    }

    private void povoandoText(Bundle bundle) {

        Moedas moeda = (Moedas) bundle.getSerializable("moeda");
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

        infoRank.setText(moeda.getRank() + "ª Posição");
        infoNome.setText("Nome: " +  moeda.getNome());
        infoSymbol.setText("Simbolo: " + moeda.getSimbolo());
        infoPreco.setText("Preço: " + format.format(moeda.getPrice_usd()));
        infoValorMercado.setText("Valor de Mercado: " + format.format(moeda.getMarket_cap_usd()));
        infoVolume.setText("Volume: " + format.format(moeda.getVolume_usd_24h()));
        infoFornecimento.setText("Fornecimento disponivel: " + format.format(moeda.getAvailable_supply()));

        if (moeda.getPercent_change_24h() <= 0 ) {
            infoVariacao.setText("Variação da moeda: " + moeda.getPercent_change_24h()+"%");
            infoVariacao.setTextColor(Color.parseColor("#ff0000"));
            infoPreco.setTextColor(Color.parseColor("#ff0000"));

        }else {
            infoVariacao.setText("Variação da moeda: " + moeda.getPercent_change_24h()+"%");
            infoVariacao.setTextColor(Color.parseColor("#008800"));
            infoPreco.setTextColor(Color.parseColor("#008800"));
        }
    }

    private void obterIds() {

        infoRank = (TextView)findViewById(R.id.tvInfoRank);
        infoNome = (TextView)findViewById(R.id.tvInfoNome);
        infoSymbol = (TextView)findViewById(R.id.tvInfoSymbol);
        infoValorMercado = (TextView)findViewById(R.id.tvInfoValorMercado);
        infoVolume = (TextView)findViewById(R.id.tvInfoVolume);
        infoVariacao = (TextView)findViewById(R.id.tvInfoVariacao);
        infoFornecimento = (TextView)findViewById(R.id.tvInfoFornecimento);
        infoPreco = (TextView)findViewById(R.id.tvInfoPrice);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info_menu_moeda,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_volta:
                loadVoltar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadVoltar() {
        Intent iVol = new Intent(this, ListMoedas.class);
        startActivity(iVol);
        this.finish();
    }
}

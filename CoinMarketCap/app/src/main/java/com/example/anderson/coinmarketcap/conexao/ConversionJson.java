package com.example.anderson.coinmarketcap.conexao;

import com.example.anderson.coinmarketcap.util.Moedas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 07/10/16.
 */
public class ConversionJson {

    private List<Moedas> moedas;
    private JSONArray jsonArray;
    private JSONObject unicMoeda;

    public List<Moedas> quebradorJSON(String json) throws JSONException {

        jsonArray = new JSONArray(json);
        moedas = new ArrayList<>();
        double aux = 0;

        for (int i = 0; i < jsonArray.length(); i++){

            Moedas m = new Moedas();
            unicMoeda = jsonArray.getJSONObject(i);

            if (unicMoeda.isNull("id"))
               m.setId("");
            else
               m.setId(unicMoeda.getString("id"));

            if (unicMoeda.isNull("name"))
                m.setNome("");
            else
                m.setNome(unicMoeda.getString("name"));

            if (unicMoeda.isNull("symbol"))
                m.setSimbolo("");
            else
                m.setSimbolo(unicMoeda.getString("symbol"));

            if (unicMoeda.isNull("rank"))
                m.setRank(0);
            else
                m.setRank(unicMoeda.getInt("rank"));

            if (unicMoeda.isNull("price_usd"))
                m.setPrice_usd(0);
            else
                m.setPrice_usd(unicMoeda.getDouble("price_usd"));

            if (unicMoeda.isNull("price_btc"))
                m.setPrice_btc(0);
            else
                m.setPrice_btc(unicMoeda.getDouble("price_btc"));

            if (unicMoeda.isNull("24h_volume_usd"))
                m.setVolume_usd_24h(0);
            else
                m.setVolume_usd_24h(unicMoeda.getDouble("24h_volume_usd"));

            if (unicMoeda.isNull("market_cap_usd"))
                m.setMarket_cap_usd(0);
            else
                m.setMarket_cap_usd(unicMoeda.getDouble("market_cap_usd"));

            if (unicMoeda.isNull("available_supply"))
                m.setAvailable_supply(0);
            else
                m.setAvailable_supply(unicMoeda.getLong("available_supply"));

            if (unicMoeda.isNull("total_supply"))
                m.setTotal_supply(0);
            else
                m.setTotal_supply(unicMoeda.getDouble("total_supply"));

            if (unicMoeda.isNull("percent_change_1h"))
                m.setPercent_change_1h(0);
            else
                m.setPercent_change_1h(unicMoeda.getDouble("percent_change_1h"));

            if (unicMoeda.isNull("percent_change_24h"))
                m.setPercent_change_7d(0);
            else
                m.setPercent_change_7d(unicMoeda.getDouble("percent_change_24h"));

            if (unicMoeda.isNull("percent_change_7d"))
                m.setPercent_change_24h(0);
            else
                m.setPercent_change_24h(unicMoeda.getDouble("percent_change_7d"));

            if (unicMoeda.isNull("last_updated"))
                m.setLast_Updated(0);
            else
                m.setLast_Updated(unicMoeda.getInt("last_updated"));

            m.setFavorito(false);

            moedas.add(m);
        }

        return moedas;
    }


}

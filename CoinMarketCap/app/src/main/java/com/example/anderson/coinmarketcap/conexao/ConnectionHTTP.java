package com.example.anderson.coinmarketcap.conexao;

import android.os.AsyncTask;
import android.util.Log;

import com.example.anderson.coinmarketcap.interfaces.ResponseHTTP;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by anderson on 07/10/16.
 */
public class ConnectionHTTP extends AsyncTask<String,String,String> {

    private String coinJson = null;
    private ResponseHTTP trs = null;


    public  ConnectionHTTP (ResponseHTTP callback){
        this.trs = callback;
    }

    @Override
    protected String doInBackground(String... paran) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(paran[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer buffer = new StringBuffer();
            String linha = "";

            while ((linha = reader.readLine()) != null) {
                buffer.append(linha);
            }
            return buffer.toString();

        } catch (MalformedURLException e) {
            Log.e("HTTP", "Erro na chamada HTTP");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            trs.transicao(s);
        } catch (JSONException e) {
            Log.e("JSON ","Erro ao retorna o JSON");
        }
    }
}

package com.example.anderson.coinmarketcap.interfaces;

import org.json.JSONException;

/**
 * Created by anderson on 07/10/16.
 */
public interface ResponseHTTP {

    public void transicao(String response) throws JSONException;

}

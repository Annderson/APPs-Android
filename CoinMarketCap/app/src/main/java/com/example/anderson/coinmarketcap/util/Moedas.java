package com.example.anderson.coinmarketcap.util;

import java.io.Serializable;

/**
 * Created by anderson on 07/10/16.
 */
public class Moedas implements Serializable {

    private String id;
    private String nome;
    private String simbolo;
    private int rank;
    private double price_usd;
    private double price_btc;
    private double volume_usd_24h;
    private  double market_cap_usd;
    private long available_supply;
    private  double total_supply;
    private double percent_change_1h;
    private double percent_change_24h;
    private double percent_change_7d;
    private int last_updated;
    private boolean favorito;

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    public double getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(double price_btc) {
        this.price_btc = price_btc;
    }

    public double getVolume_usd_24h() {
        return volume_usd_24h;
    }

    public void setVolume_usd_24h(double volume_usd_24h) {
        this.volume_usd_24h = volume_usd_24h;
    }

    public double getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(double market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public double getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(long available_supply) {
        this.available_supply = available_supply;
    }

    public double getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(double total_supply) {
        this.total_supply = total_supply;
    }

    public double getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(double percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public double getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(double percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public int getLast_Updated() {
        return last_updated;
    }

    public void setLast_Updated(int last_updated) {
        this.last_updated = last_updated;
    }

}

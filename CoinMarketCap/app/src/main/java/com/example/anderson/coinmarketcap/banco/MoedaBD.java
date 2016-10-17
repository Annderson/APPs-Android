package com.example.anderson.coinmarketcap.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.anderson.coinmarketcap.util.Constantes;

/**
 * Created by anderson on 16/10/16.
 */
public class MoedaBD extends SQLiteOpenHelper {

    public MoedaBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Constantes.NOME_BD, null, Constantes.VS_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE TB_MOEDA(");
        query.append(" ID_MOEDA TEXT PRIMARY KEY,");
        query.append(" NOME TEXT NOT NULL,");
        query.append(" SIMBOLO TEXT(5) NOT NULL,");
        query.append(" RANK INT NOT NULL,");
        query.append(" PRICE_USD REAL,");
        query.append(" PRICE_BTC REAL,");
        query.append(" VOLUME REAL,");
        query.append(" MARKET REAL,");
        query.append(" AVALIACAO INT,");
        query.append(" VARIACAO_1H REAL,");
        query.append(" VARIACAO_24H REAL,");
        query.append(" VARIACAO_7D REAL,");
        query.append(" ULTIMA_ATUALIZACAO INT,");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

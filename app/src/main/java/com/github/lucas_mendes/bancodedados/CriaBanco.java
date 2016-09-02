package com.github.lucas_mendes.bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    protected static final String TABELA = "livros";
    protected static final String TABELA_ANIME = "anime";
    protected static final String TABELA_ANIME_TEMPORADA = "animeTemporada";
    protected static final String ID = "_id";
    protected static final String ID_ANIME_TEMPORADA = "_id";
    protected static final String ANIME_ID = "_id";
    protected static final String TITULO = "titulo";
    protected static final String AUTOR = "autor";
    protected static final String EDITORA = "editora";
    protected static final String TEMPORADA = "temporada";
    protected static final String EPISODIOS_TOTAL = "episodios";
    protected static final String EPISODIOS_ASSISTIDOS = "assistidos";
    protected static final String NOTA = "nota";
    private static final int VERSAO = 1;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + AUTOR + " text,"
                + EDITORA + " text"
                +")";

        String tabelaAnime = "CREATE TABLE "+TABELA_ANIME+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text"
                +")";

        String tabelaAnimeTemporada = "CREATE TABLE "+TABELA_ANIME_TEMPORADA+"("
                + ID_ANIME_TEMPORADA + " integer primary key autoincrement,"
                + ANIME_ID + " integer,"
                + TEMPORADA + " integer,"
                + EPISODIOS_TOTAL + " integer,"
                + EPISODIOS_ASSISTIDOS + " integer,"
                + NOTA + " integer,"
                + "FOREIGN KEY("+ANIME_ID+") REFERENCES "+TABELA_ANIME_TEMPORADA+"("+ID+")"
                +")";

        db.execSQL(sql);
//        db.execSQL(tabelaAnime);
//        db.execSQL(tabelaAnimeTemporada);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
//        db.execSQL("DROP TABLE IF EXISTS" + TABELA_ANIME);
//        db.execSQL("DROP TABLE IF EXISTS" + TABELA_ANIME_TEMPORADA);
        onCreate(db);
    }
}

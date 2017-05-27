package com.example.gabriel.apptodolist.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gabriel on 27/05/17.
 */

public class BaseHelper  extends SQLiteOpenHelper{

        private static String nomeBD = "tarefabd.db";
        private static String createTable = "CREATE TABLE tarefas" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tarefa VARCHAR(30));";


        public BaseHelper(Context context) {
            super(context, nomeBD, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(createTable);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE tarefas");
            db.execSQL(createTable);
        }

}

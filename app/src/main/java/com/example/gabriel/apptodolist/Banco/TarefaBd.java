package com.example.gabriel.apptodolist.Banco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gabriel.apptodolist.Models.Tarefa;
import com.example.gabriel.apptodolist.TarefaInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 27/05/17.
 */

public class TarefaBd implements TarefaInterface {

    private BaseHelper bdOpenHelper;


    public TarefaBd(Context contexto) {
        bdOpenHelper = new BaseHelper(contexto);
    }

    @Override
    public void Inserir(Tarefa t) {

        try {

            SQLiteDatabase bancoDeDados = bdOpenHelper.getWritableDatabase();
            bancoDeDados.execSQL("INSERT INTO tarefas (tarefa) VALUES('" + t.getTarefa() + "') ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Remover(Tarefa t) {

        try {
            SQLiteDatabase bancoDeDados = bdOpenHelper.getWritableDatabase();
            bancoDeDados.execSQL("DELETE FROM tarefas WHERE id=" + t.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Tarefa> GetList() {

        List<Tarefa> lista = new ArrayList<>();

        try {
            SQLiteDatabase bancoDeDados = bdOpenHelper.getWritableDatabase();

            //recupera as tarefas
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);


            //listar as tarefas
            while (cursor.moveToNext()) {

                Tarefa t = new Tarefa(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("tarefa")));
                lista.add(t);
                Log.i("Resultado - ", "Tarefa: " + t.getTarefa());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void Editar(Tarefa t) {

        try {
            SQLiteDatabase bancoDeDados = bdOpenHelper.getWritableDatabase();
            bancoDeDados.execSQL("UPDATE tarefas SET tarefa=" + t.getTarefa() + " WHERE id=" + t.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.example.gabriel.apptodolist;

import com.example.gabriel.apptodolist.Models.Tarefa;

import java.util.List;

/**
 * Created by Gabriel on 27/05/17.
 */

public interface TarefaInterface {
    void Inserir(Tarefa t);
    void Remover(Tarefa t);
    void Editar(Tarefa t);
    List<Tarefa> GetList();

}

package com.example.gabriel.apptodolist.Models;

import java.io.Serializable;

/**
 * Created by Gabriel on 27/05/17.
 */

public class Tarefa implements Serializable {
    private int id;
    private String tarefa;

    public Tarefa(int id, String tarefa) {
        this.id = id;
        this.tarefa = tarefa;
    }


    public Tarefa(String tarefa) {
        this.tarefa = tarefa;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}

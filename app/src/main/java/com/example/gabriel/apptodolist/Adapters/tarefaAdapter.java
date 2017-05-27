package com.example.gabriel.apptodolist.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabriel.apptodolist.Models.Tarefa;
import com.example.gabriel.apptodolist.R;

import java.util.List;

/**
 * Created by Gabriel on 27/05/17.
 */

public class tarefaAdapter extends BaseAdapter {

    public tarefaAdapter(List<Tarefa> tarefas, Context context) {
        this.tarefas = tarefas;
        this.context = context;
    }

    private List<Tarefa> tarefas;
    private Context context;
    private Button btnExcluir;



    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Object getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Tarefa t = tarefas.get(position);
        LayoutInflater inf = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inf.inflate(R.layout.activity_tarefa_template,null);
        ((TextView)v.findViewById(R.id.txtTarefa)).setText(t.getTarefa());
        return v;
    }


}

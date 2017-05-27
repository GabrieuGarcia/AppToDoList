package com.example.gabriel.apptodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gabriel.apptodolist.Adapters.tarefaAdapter;
import com.example.gabriel.apptodolist.Banco.TarefaBd;
import com.example.gabriel.apptodolist.Models.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtTarefa;
    private Button btnOk;
    private ListView listTarefas;

    private tarefaAdapter adapter;
    private List<Tarefa> tarefas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Recupera componentes
            edtTarefa = (EditText) findViewById(R.id.edt_tarefa);
            btnOk = (Button) findViewById(R.id.btn_ok);

            //Lista
            listTarefas = (ListView) findViewById(R.id.list_tarefas);
            adapter = new tarefaAdapter(tarefas, this);
            listTarefas.setAdapter(adapter);

            recuperarTarefas();

            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Recupera o text digitado...
                    String textoDigitado = edtTarefa.getText().toString();
                    salvarTarefa(new Tarefa(textoDigitado));
                    recuperarTarefas();

                }
            });

            listTarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Tarefa t = tarefas.get(position);
                    removerTarefa(t);
                    tarefas.remove(t);
                    adapter.notifyDataSetChanged();

                    //int pos = ids.get(position);
                    //removerTarefa(pos);
                    //itensAdaptador.remove(String.);
                    Toast.makeText(MainActivity.this, "Tarefa removida com sucesso", Toast.LENGTH_SHORT).show();
                }
            });

            //Recupera tarefas
            recuperarTarefas();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void salvarTarefa(Tarefa t) {

        TarefaBd tarefa = new TarefaBd(this);
        tarefa.Inserir(t);
        Toast.makeText(MainActivity.this, "Tarefa salva com sucesso", Toast.LENGTH_SHORT).show();
        edtTarefa.setText("");

    }

    private void recuperarTarefas() {

        tarefas.clear();
        TarefaBd tarefa = new TarefaBd(this);
        tarefas.addAll(tarefa.GetList());
        adapter.notifyDataSetChanged();


    }

    private void removerTarefa(Tarefa t) {
        TarefaBd tarefa = new TarefaBd(this);
        tarefa.Remover(t);
        Toast.makeText(MainActivity.this, "Tarefa removida com sucesso", Toast.LENGTH_SHORT).show();
        edtTarefa.setText("");

    }

}


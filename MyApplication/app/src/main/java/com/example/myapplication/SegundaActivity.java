package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;
    RadioGroup radioGroup;
    ListView listView;
    EditText editText;
    Button regresar;
    Button botonMostrarNumero;

    String[] saludos = {"Hola", "Buenos días", "Buenas tardes", "Buenas noches"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radioGroup);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editTextNumero);
        regresar = findViewById(R.id.regresar);
        botonMostrarNumero = findViewById(R.id.botonMostrarNumero);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, saludos);
        spinner.setAdapter(adapter);

        // Spinner Item Selected Listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SegundaActivity.this, saludos[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            Toast.makeText(SegundaActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
        });

        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, saludos));
        listView.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(SegundaActivity.this, saludos[position], Toast.LENGTH_SHORT).show());

        regresar.setOnClickListener(this);

        botonMostrarNumero.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.regresar) {
            finish();
        } else if (v.getId() == R.id.botonMostrarNumero) {
            String numero = editText.getText().toString();
            Toast.makeText(SegundaActivity.this, "Número ingresado: " + numero, Toast.LENGTH_SHORT).show();
        }
    }
}
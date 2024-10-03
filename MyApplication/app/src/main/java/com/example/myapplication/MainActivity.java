package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editadito1;
    EditText editadito2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editadito1 = findViewById(R.id.editTextNumero1);
        editadito2 = findViewById(R.id.editTextNumero2);

        Button suma = findViewById(R.id.botonSuma);
        Button resta = findViewById(R.id.botonResta);
        Button multiplica = findViewById(R.id.botonMultiplica);
        Button divide = findViewById(R.id.botonDivide);
        Button irSegunda = findViewById(R.id.botonIrSegunda);

        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multiplica.setOnClickListener(this);
        divide.setOnClickListener(this);
        irSegunda.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String cadenita = ((Button) v).getText().toString();
        Operaciones objetito = new Operaciones();
        try {
            int valor1 = Integer.parseInt(editadito1.getText().toString());
            int valor2 = Integer.parseInt(editadito2.getText().toString());
            objetito.setDatito1(valor1);
            objetito.setDatito2(valor2);

            if (cadenita.equals("suma")) {
                Toast.makeText(this, "Resultado suma: " + objetito.sumita(), Toast.LENGTH_LONG).show();
            } else if (cadenita.equals("resta")) {
                Toast.makeText(this, "Resultado resta: " + objetito.restita(), Toast.LENGTH_LONG).show();
            } else if (cadenita.equals("multiplica")) {
                Toast.makeText(this, "Resultado multiplicación: " + objetito.multiplicadita(), Toast.LENGTH_LONG).show();
            } else if (cadenita.equals("dividir")) {
                Toast.makeText(this, "Resultado división: " + objetito.divisioncita(), Toast.LENGTH_LONG).show();
            } else if (cadenita.equals("Ir a Segunda")) {
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                startActivity(intent);

            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor ingresa números válidos", Toast.LENGTH_LONG).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Error: División por cero", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
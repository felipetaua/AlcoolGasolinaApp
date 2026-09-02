package com.example.alcoolgasolinaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoAlcool;
    private EditText editPrecoGasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editPrecoAlcool = findViewById(R.id.editAlcool);
        editPrecoGasolina = findViewById(R.id.editGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {
        Double precoAlcool = Double.parseDouble(editPrecoAlcool.getText().toString());
        Double precoGasolina = Double.parseDouble(editPrecoGasolina.getText().toString());


        /* Faz calculo ( precoAlcool / precoGasolina)
            se resultado >= 0.7 melhor utilizar gasolina
            senão melhor utilizar alcool
        */

        Double resultado = precoAlcool / precoGasolina;

        if (resultado >= 0.7) {
            textResultado.setText("Melhor utilizar Gasolina");
        } else {
            textResultado.setText("Melhor utilizar Alcool");
        }
    }
}
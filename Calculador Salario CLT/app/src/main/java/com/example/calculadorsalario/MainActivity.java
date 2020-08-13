package com.example.calculadorsalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.CacheRequest;

public class MainActivity extends AppCompatActivity {
    private EditText outrosDescontos;
    private EditText numDependetes;
    private EditText SalarioBruto;
    private Button Calcular;
    private TextView txtSalarioLiquido;
    private double salarioLiquido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SalarioBruto = (EditText) findViewById(R.id.salarioBruto);
        numDependetes = (EditText) findViewById(R.id.numDependentes);
        outrosDescontos = (EditText) findViewById(R.id.outrosDescontos);
        txtSalarioLiquido = (TextView) findViewById((R.id.txtSalarioLiquido));
        Calcular = (Button) findViewById(R.id.btnCalcular);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salarioLiquido = Double.parseDouble(SalarioBruto.getText().toString());
                if(salarioLiquido <= 1045.00){
                    double desconto = (7.5 * salarioLiquido) / 100;
                    salarioLiquido = salarioLiquido - desconto;
                } else if (salarioLiquido >= 1045.01 && salarioLiquido <= 2089.60){
                    double desconto = (9 * salarioLiquido) / 100;
                    desconto = desconto - 15.67;
                    salarioLiquido = salarioLiquido - desconto;
                } else if (salarioLiquido >= 2089.60 && salarioLiquido <= 3134.40) {
                    double desconto = (12 * salarioLiquido) / 100;
                    desconto = desconto - 78.36;
                    salarioLiquido = salarioLiquido - desconto;
                } else if(salarioLiquido >= 3134.41 && salarioLiquido <= 6101.06){
                    double desconto = (14 * salarioLiquido) / 100;
                    desconto = desconto - 141.05;
                    salarioLiquido = salarioLiquido - desconto;
                }

                String stringdouble = Double.toString(salarioLiquido);
                txtSalarioLiquido.setText(stringdouble);

            }
        });
    }
}

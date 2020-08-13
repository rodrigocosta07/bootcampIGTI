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
    private TextView txtINNS;
    private TextView txtIRRF;
    private double salarioLiquido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SalarioBruto = (EditText) findViewById(R.id.salarioBruto);
        numDependetes = (EditText) findViewById(R.id.numDependentes);
        outrosDescontos = (EditText) findViewById(R.id.outrosDescontos);
        txtSalarioLiquido = (TextView) findViewById((R.id.txtSalarioLiquido));
        txtINNS = (TextView) findViewById((R.id.txtINNS));
        txtIRRF = (TextView) findViewById((R.id.txtIRRF));
        Calcular = (Button) findViewById(R.id.btnCalcular);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salarioLiquido = Double.parseDouble(SalarioBruto.getText().toString());
                double desconto = 0;
                if(salarioLiquido <= 1045.00){
                     desconto = (7.5 * salarioLiquido) / 100;
                    salarioLiquido = salarioLiquido - desconto;
                } else if (salarioLiquido >= 1045.01 && salarioLiquido <= 2089.60){
                     desconto = (9 * salarioLiquido) / 100;
                    desconto = desconto - 15.67;
                    salarioLiquido = salarioLiquido - desconto;
                } else if (salarioLiquido >= 2089.60 && salarioLiquido <= 3134.40) {
                     desconto = (12 * salarioLiquido) / 100;
                    desconto = desconto - 78.36;
                    salarioLiquido = salarioLiquido - desconto;
                } else if(salarioLiquido >= 3134.41 && salarioLiquido <= 6101.06){
                     desconto = (14 * salarioLiquido) / 100;
                    desconto = desconto - 141.05;
                    salarioLiquido = salarioLiquido - desconto;
                } else if (salarioLiquido >= 6101.07) {
                    desconto = 713.10;
                    salarioLiquido -= desconto;
                }
                String inss = Double.toString(desconto);
                txtINNS.setText(inss);

                double numDep = Double.parseDouble(numDependetes.getText().toString());
                double baseCalculo = Double.parseDouble(SalarioBruto.getText().toString());
                baseCalculo = baseCalculo - desconto - numDep;
                if(baseCalculo >= 1903.98 && baseCalculo <= 2826.65  ){
                     desconto = (7.5 * salarioLiquido) / 100;
                    desconto -= 142.80;
                    salarioLiquido = salarioLiquido - desconto;
                } else if (baseCalculo >=  2826.66 && baseCalculo <=  3751.05){
                     desconto = (15 * salarioLiquido) / 100;
                    desconto -=  354.80;
                    salarioLiquido = salarioLiquido - desconto;
                } else if (baseCalculo >=  3751.06 && baseCalculo <=  4664.68) {
                     desconto = (12 * salarioLiquido) / 100;
                    desconto -= 636.13;
                    salarioLiquido = salarioLiquido - desconto;
                } else if(baseCalculo >= 4664.68) {
                     desconto = (27.5 * salarioLiquido) / 100;
                    desconto -= 869.36;
                    salarioLiquido = salarioLiquido - desconto;
                }
                String irrf = Double.toString(desconto);
                txtIRRF.setText(irrf);
                double outrosDesc = Double.parseDouble(outrosDescontos.getText().toString());
                if(outrosDescontos.getText().toString().isEmpty() == false){
                    salarioLiquido -= outrosDesc;
                }
                String stringdouble = Double.toString(salarioLiquido);
                txtSalarioLiquido.setText(stringdouble);

            }
        });
    }
}

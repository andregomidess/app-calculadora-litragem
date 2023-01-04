package com.example.calculadoradelitragem;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textLitros;
    private EditText editDiametro;
    private EditText editCm;

    private TextView textCm;
    private EditText editLitros;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLitros = findViewById(R.id.textLitros);
        editDiametro = findViewById(R.id.editDiametro);
        editCm = findViewById(R.id.editCm);

        textCm = findViewById(R.id.textCm);
        editLitros = findViewById(R.id.editLitros);


    }

    public void calc_qtd_litros(View view){
        if (editDiametro.getText().toString().isEmpty() || editCm.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Preencha os campos!", Toast.LENGTH_SHORT).show();
        } else {
            double diametro = Double.parseDouble(editDiametro.getText().toString());
            double cm = Double.parseDouble(editCm.getText().toString());
            double raio = diametro/2;
            double area_base = (raio*raio) * 3.14;
            double cada_cm = area_base/1000;
            double qtdL = cada_cm*cm;
            textLitros.setText(String.format("%.2fL", qtdL));
        }


    }

    public void calc_qtd_cm(View view){
        if (editDiametro.getText().toString().isEmpty() || editLitros.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Preencha os campos!", Toast.LENGTH_SHORT).show();
        } else {
            double diametro = Double.parseDouble(editDiametro.getText().toString());
            double litros = Double.parseDouble(editLitros.getText().toString());
            double raio = diametro/2;
            double area_base = (raio*raio) * 3.14;
            double cada_cm = area_base/1000;
            double cada_L= 1/cada_cm;
            double qtdCm = litros*cada_L;
            textCm.setText(String.format("%.2fcm", qtdCm));
        }


    }
}
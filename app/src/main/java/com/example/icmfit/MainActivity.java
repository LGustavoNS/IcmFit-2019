package com.example.icmfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText txtIdade;
    private EditText txtPeso;
    private EditText txtAltura;
    private EditText txtResultado;
    private Spinner opcSexo;
    private ImageView imgResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtIdade = findViewById(R.id.txtIdade);
        this.txtPeso = findViewById(R.id.txtPeso);
        this.txtAltura = findViewById(R.id.txtAltura);
        this.txtResultado = findViewById(R.id.txtResultado);
        this.opcSexo = findViewById(R.id.opcSexo);
        this.imgResultado = findViewById(R.id.ImgResultado);

    }

    public void calcIMC(View view) {
        double peso = 0.0;
        double altura = 0.0;
        double resultado = 0.0;
        int sexo = 0;
        peso = Double.parseDouble(this.txtPeso.getText().toString());
        altura = Double.parseDouble(this.txtAltura.getText().toString());
        resultado = peso / (altura * altura);
        sexo = this.opcSexo.getSelectedItemPosition();
        if (sexo == 0) {

            if (resultado < 18.5) {

                this.txtResultado.setText("MAGRELO!!");
                this.imgResultado.setImageResource(R.drawable.magro);
            } else if (resultado >= 18.5 && resultado < 24.9) {
                this.txtResultado.setText("Ta de boa!");
                this.imgResultado.setImageResource(R.drawable.normal);
            } else if (resultado >= 24.9 && resultado < 29.9) {
                this.txtResultado.setText("Ta Gordo!!");
                this.imgResultado.setImageResource(R.drawable.sobrepeso);
            } else {
                this.txtResultado.setText("TA OBESO CARA!!!!!!!!");
                this.imgResultado.setImageResource(R.drawable.obesidade);
            }
        } else {

        }
    }
}


package br.edu.unis.atividade_ihc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtAltura, edtMassa;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoCalcular();
    }

    protected void carregaComponentes() {
        edtAltura = findViewById(R.id.edtAltura);
        edtMassa = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoCalcular() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaClassificacao();
                exibiClassificacao(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaClassificacao() {
        float altura = float.parseFloat(edtAltura.getText().toString());
        float massa = float.parseFloat(edtMassa.getText().toString());
        float imc = (massa / (altura * altura));
        String resultado = "Magreza grave";
        if ((imc >= 16) && (imc <17))  {
            resultado = "Magreza moderada";
        } else if ((imc >= 17) && (imc <18.5)) {
            resultado = "Magreza leve";
        } else if ((imc >= 18.5) && (imc <25)) {
            resultado = "Saudável";
        } else if ((imc >= 25) && (imc <30)) {
            resultado = "Sobrepeso";
        } else if ((imc >= 30) && (imc <35)) {
            resultado = "Obesidade Grau I";
        } else if ((imc >= 35) && (imc <40)) {
            resultado = "Obesidade Grau II";
        } else {
            resultado = "Obesidade Grau III (mórbida)";
        }
            return resultado;
    }

    protected void exibiClassificacao(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtAltura.setText("");
        edtAltura.requestFocus();
        edtMassa.setText("");
        edtMassa.requestFocus();
    }
}
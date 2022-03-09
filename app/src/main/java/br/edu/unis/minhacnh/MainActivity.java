package br.edu.unis.minhacnh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtIdade;
    Button btnVerificar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoVerificar();
    }

    protected void carregaComponentes() {
        edtIdade = findViewById(R.id.edtIdade);
        btnVerificar = findViewById(R.id.btnVerificarIdade);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoVerificar() {
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        int idade = Integer.parseInt(edtIdade.getText().toString());
        String resultado = "Que Pena! Aguarde seus 18 anos";
        if (idade >= 18) {
            resultado = "Parabéns! Você já pode tirar sua CNH";
        }
        return resultado;
    }

    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtIdade.setText("");
        edtIdade.requestFocus();
    }
}
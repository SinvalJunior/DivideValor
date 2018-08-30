package com.example.opet.dividevalor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
//Comentario

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editComanda, editPessoas;
    private TextView textRateio;
    private CheckBox checkServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editComanda = findViewById(R.id.editComanda);
        editPessoas = findViewById(R.id.editPessoas);
        textRateio = findViewById(R.id.textRateio);
        checkServico = findViewById(R.id.checkServico);

        checkServico.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                //Toast.makeText(MainActivity.this, String.valueOf(isChecked),Toast.LENGTH_SHORT).show();

                double comanda = Double.parseDouble(editComanda.getText().toString());
                comanda *= 1.1;
                editComanda.setText(new DecimalFormat(".00").format(comanda));


            }
        });
    }

    public void calculaRateio(View view) {
        double comanda = Double.parseDouble(editComanda.getText().toString());
        double pessoas = Double.parseDouble(editPessoas.getText().toString());

        double rateio = comanda / pessoas;

        DecimalFormat mFormat = new DecimalFormat(".00");

        String resultado = " Valor do Rateio: " + mFormat.format(rateio);

        textRateio.setText(resultado);
    }
}



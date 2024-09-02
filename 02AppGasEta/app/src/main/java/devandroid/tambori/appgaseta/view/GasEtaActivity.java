package devandroid.tambori.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.tambori.appgaseta.R;
import devandroid.tambori.appgaseta.apoio.UtilGasEta;
import devandroid.tambori.appgaseta.controller.CombustivelController;
import devandroid.tambori.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView textResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        controller =  new CombustivelController(GasEtaActivity.this);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        textResultado = findViewById(R.id.textResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;
                if(TextUtils.isEmpty(editGasolina.getText())){
                    editGasolina.setError(" *Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(editEtanol.getText())){
                    editEtanol.setError(" *Obrigatório");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }
                if(isDadosOk){
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol);
                    textResultado.setText(recomendacao);
                    btnSalvar.setEnabled(true);
                }else{
                    Toast.makeText(GasEtaActivity.this, "Digite os dados em branco", Toast.LENGTH_LONG).show();
                    btnSalvar.setEnabled(false);
                }
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Todo: EditText inputType

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

                controller.salvar(combustivelGasolina);
                controller.salvar(combustivelEtanol);

                int parada = 0;
            }
        });
         btnLimpar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 editGasolina.setText("");
                 editEtanol.setText("");

                 btnSalvar.setEnabled(false);
                 controller.limpar();
             }
         });

         btnFinalizar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(GasEtaActivity.this, "Boa Economia...", Toast.LENGTH_LONG).show();
                 finish();
             }
         });

        Toast.makeText(GasEtaActivity.this,UtilGasEta.calcularMelhorOpcao(5.12,3.99),Toast.LENGTH_LONG).show();



    }
}

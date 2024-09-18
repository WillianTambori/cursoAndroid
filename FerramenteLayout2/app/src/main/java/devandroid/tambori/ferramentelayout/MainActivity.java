package devandroid.tambori.ferramentelayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    EditText editNomeCompleto;
    Button btnConfirmar;
    ToggleButton tbLigado;
    SwitchCompat swMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        btnConfirmar =findViewById(R.id.btnConfirmar);
        tbLigado = findViewById(R.id.tbLigado);
        swMostrar = findViewById(R.id.swMostrar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast


                if(TextUtils.isEmpty(editNomeCompleto.getText().toString())){

                    Toast.makeText(getBaseContext(), "Digite o nome completo ",Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(getBaseContext(), "você digitou "+editNomeCompleto.getText(),Toast.LENGTH_LONG).show();

                }
            }
        });

        tbLigado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tbLigado.isChecked())
                    editNomeCompleto.setEnabled(false);
                else editNomeCompleto.setEnabled(true);
            }
        });

        swMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(swMostrar.isChecked())
                    txtTitulo.setVisibility(View.GONE);
                else {
                    txtTitulo.setVisibility(View.VISIBLE);
                    String novoTitulo = txtTitulo.getText().toString().toUpperCase();
                    txtTitulo.setText(novoTitulo);
                }
            }
        });


        txtTitulo.setText("Retratinho");

    }
}
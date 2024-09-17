package devandroid.tambori.ferramentelayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    EditText editNomeCompleto;
    Button btnConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);
        btnConfirmar =findViewById(R.id.btnConfirmar);

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


        txtTitulo.setText("Retratinho");

    }
}
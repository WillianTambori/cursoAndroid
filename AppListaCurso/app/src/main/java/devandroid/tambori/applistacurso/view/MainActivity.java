package devandroid.tambori.applistacurso.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.tambori.applistacurso.R;
import devandroid.tambori.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    String dadosPessoa;
    EditText editPrimeiroNome;
    EditText editSobreNomeAluno;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            pessoa = new Pessoa();
            pessoa.setPrimeiroNome("willian");
            pessoa.setSobreNome("Tambori");
            pessoa.setCursoDesejado("android");
            pessoa.setTelefoneContato("1899999");

            editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
            editSobreNomeAluno = findViewById(R.id.editSobreNomeAluno);
            editNomeCurso = findViewById(R.id.editNomeCurso);
            editTelefoneContato = findViewById(R.id.editTelefoneContato);

            btnLimpar = findViewById(R.id.btnLimpar);
            btnSalvar = findViewById(R.id.btnSalvar);
            btnFinalizar = findViewById(R.id.btnFinalizar);

            editPrimeiroNome.setText(pessoa.getPrimeiroNome());
            editSobreNomeAluno.setText(pessoa.getSobreNome());
            editNomeCurso.setText(pessoa.getCursoDesejado());
            editTelefoneContato.setText(pessoa.getTelefoneContato());




            dadosPessoa = " Primeiro nome: ";
            dadosPessoa += pessoa.getPrimeiroNome();
            dadosPessoa = " Sobrenome: ";
            dadosPessoa += pessoa.getSobreNome();
            dadosPessoa += " Curso Desejado: ";
            dadosPessoa += pessoa.getCursoDesejado();
            dadosPessoa += " telefone de Contato: ";
            dadosPessoa += pessoa.getTelefoneContato();

        Log.i("POOAndroid"," Objeto Pessoa: "+pessoa.toString());

            //int parada = 0;


    }
}
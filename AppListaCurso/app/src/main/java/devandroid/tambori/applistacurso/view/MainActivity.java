package devandroid.tambori.applistacurso.view;

import android.os.Bundle;

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

            dadosPessoa = " Primeiro nome: ";
            dadosPessoa += pessoa.getPrimeiroNome();
            dadosPessoa = " Sobrenome: ";
            dadosPessoa += pessoa.getSobreNome();
            dadosPessoa += " Curso Desejado: ";
            dadosPessoa += pessoa.getCursoDesejado();
            dadosPessoa += " telefone de Contato: ";
            dadosPessoa += pessoa.getTelefoneContato();

            int parada = 0;


    }
}
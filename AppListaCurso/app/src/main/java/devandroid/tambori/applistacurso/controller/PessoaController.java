package devandroid.tambori.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.tambori.applistacurso.database.ListaVipDB;
import devandroid.tambori.applistacurso.model.Pessoa;
import devandroid.tambori.applistacurso.view.MainActivity;

public class PessoaController extends ListaVipDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";


    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "controller Iniciado...");

        return super.toString();
    }


    public void salvar(Pessoa pessoa) {

        ContentValues dados = new ContentValues();
        Log.i("MVC_Controller", "Salvo: " + pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();

        dados.put("primeiroNome",pessoa.getPrimeiroNome());
        dados.put("sobrenome",pessoa.getSobreNome());
        dados.put("cursoDesejado",pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());

        salvarObjeto("Pessoa",dados);
    }

    public Pessoa buscarDadosSharedPreferences(Pessoa pessoa) {

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobreNome(preferences.getString("sobreNome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));

        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }

    public void alterar(Pessoa pessoa) {

        ContentValues dados = new ContentValues();
        dados.put("id", pessoa.getId());
        dados.put("primeiroNome",pessoa.getPrimeiroNome());
        dados.put("sobrenome",pessoa.getSobreNome());
        dados.put("cursoDesejado",pessoa.getCursoDesejado());
        dados.put("telefoneContato",pessoa.getTelefoneContato());
        alterarObjeto("Pessoa",dados);
    }

    public void deletar(int id){
        deletarObjeto("Pessoa",id);
    }
}

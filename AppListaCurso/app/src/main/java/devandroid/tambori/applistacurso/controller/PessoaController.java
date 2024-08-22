package devandroid.tambori.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.tambori.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller","controller Iniciado...");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller","Salvo: " + pessoa.toString());
    }
}

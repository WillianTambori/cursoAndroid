package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteCardsFragment extends Fragment {

    View view;
    TextView txtTitulo;
    EditText editNomeCompleto;
    EditText editTelefone;
    EditText editEmail;
    EditText editCep;
    EditText editLogradouro;
    EditText editNumero;
    EditText editBairro;
    EditText editCidade;
    EditText editEstado;
    CheckBox chkTermosDeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteCardsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_adicionar_cliente_card, container, false);

        iniciarComponentesDeLayout();

        escutarEventosDoBotoes();


        return view;
    }


    /**
     * INICIALIZAR OS COMPONENTES DA TELA/LAYOUT
     * para adicionar os clientes
     */
    private void iniciarComponentesDeLayout() {
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.fragmento_adicionar_cliente_cards);
        editNomeCompleto = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosDeUso = view.findViewById(R.id.chkTermosDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();
        clienteController = new ClienteController(getContext());
    }
    private void escutarEventosDoBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editNomeCompleto.getText())){
                    isDadosOk =false;
                    editNomeCompleto.setError("Digite o nome completo");
                    editNomeCompleto.requestFocus();
                }
                if(TextUtils.isEmpty(editTelefone.getText())){
                    isDadosOk =false;
                    editTelefone.setError("Digite o campo");
                    editTelefone.requestFocus();
                }
                if(TextUtils.isEmpty(editEmail.getText())){
                    isDadosOk =false;
                    editEmail.setError("Digite o campo");
                    editEmail.requestFocus();
                }
                if(TextUtils.isEmpty(editCep.getText())){
                    isDadosOk =false;
                    editCep.setError("Digite o campo");
                    editCep.requestFocus();
                }
                if(TextUtils.isEmpty(editLogradouro.getText())){
                    isDadosOk =false;
                    editLogradouro.setError("Digite o campo");
                    editLogradouro.requestFocus();
                }
                if(TextUtils.isEmpty(editNumero.getText())){
                    isDadosOk =false;
                    editNumero.setError("Digite o campo");
                    editNumero.requestFocus();
                }
                if(TextUtils.isEmpty(editBairro.getText())){
                    isDadosOk =false;
                    editBairro.setError("Digite o campo");
                    editBairro.requestFocus();
                }
                if(TextUtils.isEmpty(editCidade.getText())){
                    isDadosOk =false;
                    editCidade.setError("Digite o campo");
                    editCidade.requestFocus();
                }
                if(TextUtils.isEmpty(editEstado.getText())){
                    isDadosOk =false;
                    editEstado.setError("Digite o campo");
                    editEstado.requestFocus();
                }

                if(isDadosOk){

                    novoCliente.setNome(editNomeCompleto.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));
                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(editNumero.getText().toString());
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());

                    novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());



                    clienteController.incluir(novoCliente);
                    Log.i("log_add_cliente","onClick:Dados Salvos...");

                }else{

                    Log.e("log_add_cliente","onClick:Dados Incorreto...");
                }



            }
        });
    }


}

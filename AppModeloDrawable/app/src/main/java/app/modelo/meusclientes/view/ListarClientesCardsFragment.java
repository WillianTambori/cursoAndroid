package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class ListarClientesCardsFragment extends Fragment {

    View view;

    EditText editPesquisarNome;
    ListView listView;

    List<Cliente> clienteList;

    List<String> clientes;

    ArrayAdapter<String> clienteAdapter;

    ArrayList<HashMap<String,String>> filtroClientes;
    ClienteController clienteController;

    Cliente objCliente;

    public ListarClientesCardsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_listar_clientes_cards, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setText( R.string.fragmento_listar_clientes_cards);

        txtTitulo.setTextColor(ColorStateList.valueOf(Color.CYAN));


        clienteController = new ClienteController(getContext());

        listView = (ListView)  view.findViewById(R.id.listView);

        editPesquisarNome = view.findViewById(R.id.editPesquisarNome);


        clienteList = clienteController.listar();

        //clientes = new ArrayList<>();

        clientes = clienteController.gerarListaDeClientesListView();

        clienteAdapter = new ArrayAdapter<>(getContext(), R.layout.listar_cliente_item, R.id.txtItemLista, clientes);

        listView.setAdapter(clienteAdapter);

        editPesquisarNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int i, int i1, int i2) {

                ListarClientesCardsFragment.this.clienteAdapter.getFilter().filter(filtro);

                Log.i("add_listView","beforeTextchanged"+filtro);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }


}

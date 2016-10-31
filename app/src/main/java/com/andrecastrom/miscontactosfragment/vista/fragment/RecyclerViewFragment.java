package com.andrecastrom.miscontactosfragment.vista.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrecastrom.miscontactosfragment.R;
import com.andrecastrom.miscontactosfragment.adapter.ContactoAdaptador;
import com.andrecastrom.miscontactosfragment.pojo.Contacto;
import com.andrecastrom.miscontactosfragment.presentador.IRecycleViewFragmentPresenter;
import com.andrecastrom.miscontactosfragment.presentador.RecycleViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by 47369176d on 26/10/2016.
 */

public class RecyclerViewFragment extends Fragment implements IRecycleViewFragmentView{

    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecycleViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new RecycleViewFragmentPresenter(this, getContext());
        presenter.obtenerContactosBaseDatos();

//        inicializarListaContactos();



        return v;
    }

    /*
    public void inicializarListaContactos() {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.lollipop, "Pepito Grillo","666777888", "pepito@gmail.com"));
        contactos.add(new Contacto(R.drawable.mushroom, "Caperucita Roja","61234567", "caperu@gmail.com"));
        contactos.add(new Contacto(R.drawable.shock_rave, "Blanca Nieves","652123456", "blanca@gmail.com"));
        contactos.add(new Contacto(R.drawable.banana, "Lobo Feroz","698745623", "lobito@gmail.com"));
        //contactos.add(new Contacto("Santa Claus","699888555", "noelsanta@gmail.com"));
    }
    */

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}

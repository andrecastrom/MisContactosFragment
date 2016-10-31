package com.andrecastrom.miscontactosfragment.presentador;

import android.content.Context;

import com.andrecastrom.miscontactosfragment.db.ConstructorContactos;
import com.andrecastrom.miscontactosfragment.pojo.Contacto;
import com.andrecastrom.miscontactosfragment.vista.fragment.IRecycleViewFragmentView;

import java.util.ArrayList;

/**
 * Created by 47369176d on 31/10/2016.
 */

public class RecycleViewFragmentPresenter implements IRecycleViewFragmentPresenter {

    private IRecycleViewFragmentView iRecycleViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecycleViewFragmentPresenter(IRecycleViewFragmentView iRecycleViewFragmentView, Context context) {
        this.iRecycleViewFragmentView = iRecycleViewFragmentView;
        this.context = context;
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecycleViewFragmentView.inicializarAdaptadorRV(iRecycleViewFragmentView.crearAdaptador(contactos));
        iRecycleViewFragmentView.generarLinearLayoutVertical();
    }
}

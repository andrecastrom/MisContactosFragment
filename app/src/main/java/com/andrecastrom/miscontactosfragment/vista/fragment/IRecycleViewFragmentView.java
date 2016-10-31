package com.andrecastrom.miscontactosfragment.vista.fragment;

import com.andrecastrom.miscontactosfragment.adapter.ContactoAdaptador;
import com.andrecastrom.miscontactosfragment.pojo.Contacto;

import java.util.ArrayList;

public interface IRecycleViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);


}

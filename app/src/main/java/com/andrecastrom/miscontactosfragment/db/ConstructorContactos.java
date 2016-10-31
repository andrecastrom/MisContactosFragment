package com.andrecastrom.miscontactosfragment.db;

import android.content.Context;;

import com.andrecastrom.miscontactosfragment.R;
import com.andrecastrom.miscontactosfragment.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.lollipop, "Pepito Grillo","666777888", "pepito@gmail.com",1));
        contactos.add(new Contacto(R.drawable.mushroom, "Caperucita Roja","61234567", "caperu@gmail.com",5));
        contactos.add(new Contacto(R.drawable.shock_rave, "Blanca Nieves","652123456", "blanca@gmail.com",8));
        contactos.add(new Contacto(R.drawable.banana, "Lobo Feroz","698745623", "lobito@gmail.com",3));

        return contactos;
    }

}

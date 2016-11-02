package com.andrecastrom.miscontactosfragment.db;

import android.content.ContentValues;
import android.content.Context;;

import com.andrecastrom.miscontactosfragment.R;
import com.andrecastrom.miscontactosfragment.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
//        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
//
//        contactos.add(new Contacto(R.drawable.lollipop, "Pepito Grillo","666777888", "pepito@gmail.com",1));
//        contactos.add(new Contacto(R.drawable.mushroom, "Caperucita Roja","61234567", "caperu@gmail.com",5));
//        contactos.add(new Contacto(R.drawable.shock_rave, "Blanca Nieves","652123456", "blanca@gmail.com",8));
//        contactos.add(new Contacto(R.drawable.banana, "Lobo Feroz","698745623", "lobito@gmail.com",3));
//
//        return contactos;

        BaseDatos db = new BaseDatos(context);
        insertarContactos(db);
        return db.obtenerTodosLosContactos();

    }

    public void insertarContactos(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Pepito Grillo");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "666777888");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "pepito@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.lollipop);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Caperucita Roja");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "61234567");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "caperu@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mushroom);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Blanca Nieves");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "652123456");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "blanca@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.shock_rave);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }


    public int obtenerLikesContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }

}

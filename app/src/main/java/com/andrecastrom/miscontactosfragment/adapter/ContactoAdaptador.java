package com.andrecastrom.miscontactosfragment.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andrecastrom.miscontactosfragment.db.ConstructorContactos;
import com.andrecastrom.miscontactosfragment.pojo.Contacto;
import com.andrecastrom.miscontactosfragment.DetalleContacto;
import com.andrecastrom.miscontactosfragment.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by 47369176d on 25/10/2016.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }


    //Infla el layout y lo pasa al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        //contactoViewHolder.imgFoto.setImageResource(contacto.getUrlFoto());
        Picasso.with(activity)
                .load(contacto.getUrlFoto())
                .placeholder(R.drawable.shock_rave_2)
                .into(contactoViewHolder.imgFoto);
//        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
//        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()));

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
//                intent.putExtra("nombre", contacto.getNombre());
//                intent.putExtra("telefono", contacto.getTelefono());
//                intent.putExtra("email", contacto.getEmail());
                intent.putExtra("url", contacto.getUrlFoto());
                intent.putExtra("like", contacto.getLikes());
                activity.startActivity(intent);
            }
        });

//        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
//                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
//                constructorContactos.darLikeContacto(contacto);
//                int likes = constructorContactos.obtenerLikesContacto(contacto);
//                contactoViewHolder.tvLikes.setText(String.valueOf(likes) + " Likes");
//            }
//        });

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
//        private TextView tvNombreCV;
//        private TextView tvTelefonoCV;
//        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
//            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
//            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
//            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }

}

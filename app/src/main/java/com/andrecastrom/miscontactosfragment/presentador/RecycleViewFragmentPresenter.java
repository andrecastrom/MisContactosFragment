package com.andrecastrom.miscontactosfragment.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.andrecastrom.miscontactosfragment.db.ConstructorContactos;
import com.andrecastrom.miscontactosfragment.pojo.Contacto;
import com.andrecastrom.miscontactosfragment.restApi.EndpointApi;
import com.andrecastrom.miscontactosfragment.restApi.adapter.RestApiAdapter;
import com.andrecastrom.miscontactosfragment.restApi.model.ContactoResponse;
import com.andrecastrom.miscontactosfragment.vista.fragment.IRecycleViewFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        obtenerMediosRecietnes();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMediosRecietnes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointApi endpointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall =  endpointApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Fallo de conexion. Intentalo de nuevo", Toast.LENGTH_SHORT).show();
                Log.e("Fallo de conexion", t.toString());
            }
        });
    }

    @Override
    public void mostrarContactosRV() {
        iRecycleViewFragmentView.inicializarAdaptadorRV(iRecycleViewFragmentView.crearAdaptador(contactos));
        iRecycleViewFragmentView.generarGridLayoutVertical();
    }
}

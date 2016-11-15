package com.andrecastrom.miscontactosfragment.restApi.adapter;

import com.andrecastrom.miscontactosfragment.restApi.ConstantesRestApi;
import com.andrecastrom.miscontactosfragment.restApi.EndpointApi;
import com.andrecastrom.miscontactosfragment.restApi.deserializador.ContactoDeserializador;
import com.andrecastrom.miscontactosfragment.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 47369176d on 15/11/2016.
 */

public class RestApiAdapter {

    public EndpointApi establecerConexionRestApiInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());
        return gsonBuilder.create();
    }

}

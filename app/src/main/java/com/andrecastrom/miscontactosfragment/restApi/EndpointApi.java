package com.andrecastrom.miscontactosfragment.restApi;

import com.andrecastrom.miscontactosfragment.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();

}

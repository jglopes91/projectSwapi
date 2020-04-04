package com.crosoften.projetoswapi.data;

import com.crosoften.projetoswapi.data.responses.PaginadoListaPersonagensReponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("people/")
    Call<PaginadoListaPersonagensReponse> getAllPersonagens(@Query(value = "page") Integer page);
}

package com.crosoften.projetoswapi.activiy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.crosoften.projetoswapi.data.RetrofitAPI;
import com.crosoften.projetoswapi.data.RetrofitRequest;
import com.crosoften.projetoswapi.data.responses.PaginadoListaPersonagensReponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaPersonagensViewModel extends ViewModel {
    RetrofitRequest api ;
    MutableLiveData<PaginadoListaPersonagensReponse> mutableLiveData;
    public ListaPersonagensViewModel() {
        api = new RetrofitRequest();
        mutableLiveData = new MutableLiveData<>();
    }

    LiveData<PaginadoListaPersonagensReponse> getAllPersonagensPaginado(Integer page) {
        Call<PaginadoListaPersonagensReponse> reponseCall = api.getServices().getAllPersonagens(page);
        reponseCall.enqueue(new Callback<PaginadoListaPersonagensReponse>() {
            @Override
            public void onResponse(Call<PaginadoListaPersonagensReponse> call, Response<PaginadoListaPersonagensReponse> response) {
                if(response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PaginadoListaPersonagensReponse> call, Throwable t) {
                //faz nada.
            }
        });
        return mutableLiveData;
    }
}

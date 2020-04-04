package com.crosoften.projetoswapi.data;

import com.crosoften.projetoswapi.data.APIService;
import com.crosoften.projetoswapi.data.RetrofitAPI;

public class RetrofitRequest extends RetrofitAPI {
    public RetrofitRequest() {getRetrofitInstance();}
    public APIService getServices(){
        return retrofit.create(APIService.class);
    }

}

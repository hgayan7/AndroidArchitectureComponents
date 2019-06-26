package com.aidev.him.employee_architecturecomponents.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static final String BASE_URL = "http://www.mocky.io/";

    private static Retrofit retrofit=null;
    public static Retrofit getRetroInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static APIService getAPIService(){
        return getRetroInstance().create(APIService.class);
    }
}

package com.devtoledo.conversorbtc.remote.repository;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by smyle.toledo on 20/04/2017.
 */

public class BitcoinClient {


    public BitcoinClient.Client getClient() {
        String API_BASE_URL = "https://blockchain.info/";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.client(
                httpClient.build()
        ).build();

        return retrofit.create(BitcoinClient.Client.class);
    }


    public interface Client {
        @GET("pt/ticker")
        Call<Map<String, PriceList>> getPriceList();
    }
}

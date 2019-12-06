package com.example.nytimesdemo.di.module;



import com.example.nytimesdemo.BuildConfig;
import com.example.nytimesdemo.model.remote.APIInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    @Provides
    @Singleton
    APIInterface providesApiInterface(){
        //Create Logger
        HttpLoggingInterceptor loggingInterceptor;
        loggingInterceptor = new HttpLoggingInterceptor().
                setLevel(HttpLoggingInterceptor.Level.BODY);


        //Create Okhttp Client
        OkHttpClient.Builder okHttpClient= new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor);


        //Create Retrofit Builder
        Retrofit.Builder builder= new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build());
        Retrofit retrofit= builder.build();
        return retrofit.create(APIInterface.class);
    }
}

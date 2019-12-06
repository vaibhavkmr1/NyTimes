package com.example.nytimesdemo;

import android.app.Application;

import com.example.nytimesdemo.di.component.AppComponent;
import com.example.nytimesdemo.di.component.DaggerAppComponent;
import com.example.nytimesdemo.di.module.AppModule;

public class NyDemoApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

package com.example.nytimesdemo.di.module;

import com.example.nytimesdemo.NyDemoApplication;

import dagger.Module;

@Module
public class AppModule {
      NyDemoApplication nyDemoApplication;

      public AppModule(NyDemoApplication nyDemoApplication){
          this.nyDemoApplication=nyDemoApplication;
      }


}

package br.com.ligeiro.cs.dagger.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Fernando on 02/11/16.
 */

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharePreferences() {
        return mApplication.getSharedPreferences("pk", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.mApplication;
    }


}

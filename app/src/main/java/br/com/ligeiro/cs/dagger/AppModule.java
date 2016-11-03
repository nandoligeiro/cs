package br.com.ligeiro.cs.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import br.com.ligeiro.cs.data.repository.IRepoRepository;
import br.com.ligeiro.cs.data.repository.RetrofitRest;

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

    @Provides @Singleton Context provideApplicationContext() {
        return this.mApplication;
    }


    @Provides @Singleton
    IRepoRepository provideIRepoRepository(RetrofitRest retrofitRest) {
        return  retrofitRest;
    }

}

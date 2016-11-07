package br.com.ligeiro.cs.dagger.component;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import br.com.ligeiro.cs.dagger.module.AppModule;
import br.com.ligeiro.cs.dagger.module.NetModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    Retrofit retrofit();

    SharedPreferences sharePreferences();

    Context provideApplicationContext();


}

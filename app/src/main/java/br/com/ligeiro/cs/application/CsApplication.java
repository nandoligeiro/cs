package br.com.ligeiro.cs.application;

import android.app.Application;

import br.com.ligeiro.cs.dagger.component.AppComponent;
import br.com.ligeiro.cs.dagger.component.DaggerAppComponent;
import br.com.ligeiro.cs.dagger.module.AppModule;
import br.com.ligeiro.cs.dagger.module.NetModule;


/**
 * Created by Fernando on 02/11/16.
 */

public class CsApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/"))
                .build();
    }

    public AppComponent getNetComponent() {
        return appComponent;
    }
}

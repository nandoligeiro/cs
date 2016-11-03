package br.com.ligeiro.cs.application;

import android.app.Application;

import br.com.ligeiro.cs.dagger.DaggerNetComponent;
import br.com.ligeiro.cs.dagger.NetComponent;
import br.com.ligeiro.cs.dagger.AppModule;
import br.com.ligeiro.cs.dagger.NetModule;


/**
 * Created by Fernando on 02/11/16.
 */

public class CsApplication extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}

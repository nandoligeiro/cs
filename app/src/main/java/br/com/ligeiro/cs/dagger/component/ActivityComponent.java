
package br.com.ligeiro.cs.dagger.component;

import android.app.Activity;
import android.app.ActivityManager;

import br.com.ligeiro.cs.dagger.module.ActivityModule;
import br.com.ligeiro.cs.dagger.scope.PerActivity;
import dagger.Component;


@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  //Exposed to sub-graphs.
  Activity activity();
}

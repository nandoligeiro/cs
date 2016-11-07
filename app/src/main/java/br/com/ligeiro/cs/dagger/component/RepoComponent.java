package br.com.ligeiro.cs.dagger.component;



import br.com.ligeiro.cs.dagger.module.ActivityModule;
import br.com.ligeiro.cs.dagger.module.RepoModule;
import br.com.ligeiro.cs.dagger.scope.PerActivity;

import br.com.ligeiro.cs.presentation.view.fragments.ReposFragment;
import dagger.Component;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, RepoModule.class})
public interface RepoComponent extends ActivityComponent {

    void inject(ReposFragment reposFragment);
    void inject (RepoModule repoModule);

}

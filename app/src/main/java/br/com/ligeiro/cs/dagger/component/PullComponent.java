package br.com.ligeiro.cs.dagger.component;


import br.com.ligeiro.cs.dagger.module.ActivityModule;
import br.com.ligeiro.cs.dagger.module.PullModule;
import br.com.ligeiro.cs.dagger.scope.PerActivity;

import br.com.ligeiro.cs.data.repository.pulls.IPullRepository;
import br.com.ligeiro.cs.presentation.view.fragments.PullsFragment;
import dagger.Component;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, PullModule.class})
public interface PullComponent extends ActivityComponent {

    void inject(PullsFragment pullsFragment);

    IPullRepository iPullRepository();
}

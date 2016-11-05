package br.com.ligeiro.cs.dagger.component;


import br.com.ligeiro.cs.dagger.PageRepoModule;
import br.com.ligeiro.cs.dagger.scope.PerActivity;
import br.com.ligeiro.cs.data.repository.repo.IRepoRepository;
import br.com.ligeiro.cs.presentation.view.fragments.ReposFragment;
import dagger.Component;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {PageRepoModule.class})
public interface RepoComponent {

    void inject(ReposFragment reposFragment);
    IRepoRepository iRepoRepository();

}

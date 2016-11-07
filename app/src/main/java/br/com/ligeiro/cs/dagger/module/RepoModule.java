package br.com.ligeiro.cs.dagger.module;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import br.com.ligeiro.cs.dagger.scope.PerActivity;
import br.com.ligeiro.cs.dagger.scope.PerFragment;
import br.com.ligeiro.cs.data.repository.repo.IRepoRepository;
import br.com.ligeiro.cs.data.repository.repo.RetrofitRest;
import br.com.ligeiro.cs.domain.interactor.GetRepositoryUseCase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */

@Module
public class RepoModule {

    private String page = "1";

    public RepoModule() {

    }


    public RepoModule(String page) {
        this.page = page;

    }

    @Provides
    @PerActivity
    IRepoRepository provideIRepoRepository(RetrofitRest retrofitRest) {
        return retrofitRest;
    }


    @Provides
    @PerActivity
    @Named("page")
    public GetRepositoryUseCase provideGetRepositoryUseCase(IRepoRepository iRepoRepository) {
        return new GetRepositoryUseCase(iRepoRepository, this.page );
    }

}

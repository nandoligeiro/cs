package br.com.ligeiro.cs.dagger;

import br.com.ligeiro.cs.data.repository.repo.IRepoRepository;
import br.com.ligeiro.cs.data.repository.repo.RetrofitRest;
import br.com.ligeiro.cs.domain.interactor.GetRepositoryUseCase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */

@Module
public class PageRepoModule {

    private String page = "9";

    public PageRepoModule() {

    }

    public PageRepoModule(String page) {
        this.page = page;

    }


    @Provides
    IRepoRepository provideIRepoRepository(RetrofitRest retrofitRest) {
        return retrofitRest;
    }


    @Provides
    public GetRepositoryUseCase provideGetRepositoryUseCase(IRepoRepository iRepoRepository) {
        return new GetRepositoryUseCase(iRepoRepository, page);
    }

}

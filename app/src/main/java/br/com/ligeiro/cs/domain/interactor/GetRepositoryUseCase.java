package br.com.ligeiro.cs.domain.interactor;

import javax.inject.Inject;

import br.com.ligeiro.cs.data.repository.repo.IRepoRepository;
import br.com.ligeiro.cs.domain.model.Repository;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */
public class GetRepositoryUseCase extends UseCase<Repository> {

    private IRepoRepository repoRepository;
    private String page;

    @Inject
    public GetRepositoryUseCase(IRepoRepository repoRepository, String page) {

        this.repoRepository = repoRepository;
        this.page = page;
    }



    @Override
    Observable<Repository> createObservable() {
        return repoRepository.getRepositories(this.page);
    }
}

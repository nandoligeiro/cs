package br.com.ligeiro.cs.domain.interactor;

import javax.inject.Inject;

import br.com.ligeiro.cs.data.repository.IRepoRepository;
import br.com.ligeiro.cs.domain.model.Repository;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */
public class GetRepositoryUseCase extends UseCase<Repository> {

    private IRepoRepository repoRepository;


    @Inject
    protected GetRepositoryUseCase(IRepoRepository repoRepository) {

        this.repoRepository = repoRepository;
    }



    @Override
    Observable<Repository> createObservable() {
        return repoRepository.getRepositories();
    }
}

package br.com.ligeiro.cs.domain.interactor;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.ligeiro.cs.data.repository.repo.IRepoRepository;
import br.com.ligeiro.cs.domain.model.RepoAndUser;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */
public class GetRepositoryUseCase extends UseCase<RepoAndUser> {

    private IRepoRepository repoRepository;
    private String page;

    @Inject
    public GetRepositoryUseCase(IRepoRepository repoRepository, String page) {

        this.repoRepository = repoRepository;
    }



    @Override
    Observable<RepoAndUser> createObservable() {
        return repoRepository.getRepositories(page);
    }
}

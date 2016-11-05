package br.com.ligeiro.cs.domain.interactor;

import javax.inject.Inject;

import br.com.ligeiro.cs.data.repository.pulls.IPullRepository;
import br.com.ligeiro.cs.domain.model.PullAndUser;
import rx.Observable;

/**
 * Created by fernando.c.moreira on 03/11/2016.
 */

public class GetPullUseCase extends UseCase<PullAndUser> {


    private IPullRepository iPullRepository;
    private final String owner;
    private final String repo;


    @Inject
    public GetPullUseCase(IPullRepository iPullRepository, String owner, String repo) {
        this.iPullRepository = iPullRepository;
        this.owner = owner;
        this.repo = repo;
    }

    @Override
    Observable<PullAndUser> createObservable() {
        return iPullRepository.getPulls(owner,repo);
    }
}

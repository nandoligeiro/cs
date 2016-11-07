package br.com.ligeiro.cs.domain.interactor;

import javax.inject.Inject;

import br.com.ligeiro.cs.data.repository.user.IUserRepository;

import br.com.ligeiro.cs.domain.model.repo.User;
import rx.Observable;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */

public class GetUserUseCase extends UseCase<User> {

    private final IUserRepository iUserRepository;
    private final String user;

    @Inject
    public GetUserUseCase(IUserRepository iUserRepository, String user) {
        this.iUserRepository = iUserRepository;
        this.user = user;
    }


    @Override
    Observable<User> createObservable() {
        return iUserRepository.getUser(user);
    }
}

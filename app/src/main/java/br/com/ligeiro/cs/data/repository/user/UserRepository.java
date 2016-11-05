package br.com.ligeiro.cs.data.repository.user;

import br.com.ligeiro.cs.domain.model.User;
import rx.Observable;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */

public class UserRepository implements IUserRepository {

    @Override
    public Observable<User> getUser(String user) {
        return null;
    }
}

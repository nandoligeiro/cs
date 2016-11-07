package br.com.ligeiro.cs.data.repository.repo;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.ligeiro.cs.data.rest.Api;
import br.com.ligeiro.cs.domain.model.RepoAndUser;
import br.com.ligeiro.cs.domain.model.repo.Item;
import br.com.ligeiro.cs.domain.model.repo.User;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Fernando on 03/11/16.
 */

public class RetrofitRest implements IRepoRepository {

    private Api api;

    @Inject
    public RetrofitRest(Retrofit retrofit) {

        api = retrofit.create(Api.class);


    }


    @Override
    public Observable<RepoAndUser> getRepositories(String page) {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Item> items = new ArrayList<>();

        return api.getJavaRepositories("language:Java", "stars", page)
                .flatMap(repository -> Observable.from(repository.getItems())
                        .flatMap(item -> api.getUser(item.getOwner().getLogin())
                                .map(user -> {
                                    items.add(item);
                                    users.add(user);
                                    return new RepoAndUser(items, users);
                                })));


    }
}

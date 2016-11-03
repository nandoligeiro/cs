package br.com.ligeiro.cs.data.repository;

import javax.inject.Inject;
import br.com.ligeiro.cs.data.rest.Api;
import br.com.ligeiro.cs.domain.model.Repository;
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
    public Observable<Repository> getRepositories() {
        return api.getJavaRepositories("language:Java", "stars", "1");
    }
}

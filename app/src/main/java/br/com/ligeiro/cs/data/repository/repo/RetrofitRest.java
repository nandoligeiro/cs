package br.com.ligeiro.cs.data.repository.repo;

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
    public Observable<Repository> getRepositories(String page) {
//      return Observable.zip(api.getJavaRepositories("language:Java", "stars", page), api.getUser("facebook"), new Func2<Repository, User, RepoAndUser>() {
//          @Override
//          public RepoAndUser call(Repository repository, User user) {
//              return new RepoAndUser(repository, user);
//          }
//      });

        return api.getJavaRepositories("language:Java", "stars", page);


    }
}

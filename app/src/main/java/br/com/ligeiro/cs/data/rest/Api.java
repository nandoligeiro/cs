package br.com.ligeiro.cs.data.rest;

import java.util.List;

import br.com.ligeiro.cs.domain.model.repo.Repository;
import br.com.ligeiro.cs.domain.model.pulls.Pull;
import br.com.ligeiro.cs.domain.model.repo.User;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    @GET("/search/repositories")
    Observable<Repository> getJavaRepositories(@Query("q")String q,
                                               @Query("sort") String sort,
                                               @Query("page") String page);


    @GET("repos/{owner}/{repo}/pulls")
    Observable<List<Pull>> getPulls(@Path("owner") String owner, @Path("repo") String repo);

    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String user);

}

package br.com.ligeiro.cs.data.rest;

import br.com.ligeiro.cs.domain.model.Repository;
import br.com.ligeiro.cs.domain.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    String API_BASE_URL = "https://api.github.com/";

    @GET("/search/repositories")
    Observable<Repository> getJavaRepositories(@Query("q")String q,
                                               @Query("sort") String sort,
                                               @Query("page") String page);


    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

}

package br.com.ligeiro.cs.data.repository.pulls;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.ligeiro.cs.data.rest.Api;
import br.com.ligeiro.cs.domain.model.PullAndUser;
import br.com.ligeiro.cs.domain.model.User;
import br.com.ligeiro.cs.domain.model.pulls.Pull;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Fernando on 03/11/16.
 */

public class RetrofitPullRepository implements IPullRepository {

    private Api api;

    @Inject
    public RetrofitPullRepository(Retrofit retrofit) {

        api = retrofit.create(Api.class);


    }

    @Override
    public Observable<PullAndUser> getPulls(String owner, String repo) {

        ArrayList<User> userArrayList = new ArrayList();
        ArrayList<Pull> pullArrayList = new ArrayList<>();
        return api.getPulls(owner, repo)
                .flatMap(pulls -> Observable.from(pulls))
                .flatMap(pull -> api.getUser(pull.getUser().getLogin())
                        .map(user -> {
                            userArrayList.add(user);
                            pullArrayList.add(pull);
                            return new PullAndUser(pullArrayList, userArrayList);
                        }));

    }


}

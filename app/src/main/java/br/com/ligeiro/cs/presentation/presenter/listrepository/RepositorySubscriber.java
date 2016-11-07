package br.com.ligeiro.cs.presentation.presenter.listrepository;

import android.util.Log;

import br.com.ligeiro.cs.domain.model.RepoAndUser;
import br.com.ligeiro.cs.domain.model.repo.Repository;
import rx.Subscriber;

/**
 * Created by Fernando on 02/11/16.
 */
public final class RepositorySubscriber extends Subscriber<RepoAndUser> {

    IRepositoryView view;


    public RepositorySubscriber(IRepositoryView view) {

        this.view = view;

    }

    @Override
    public void onCompleted() {

        Log.d("onComplete", "on");

    }

    @Override
    public void onError(Throwable e) {

        view.displayError(e.toString());
        Log.d("onError", e.toString());

    }

    @Override
    public void onNext(RepoAndUser repoAndUser) {
        view.displayRepositories(repoAndUser);

    }

}

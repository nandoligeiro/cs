package br.com.ligeiro.cs.presentation.presenter.listrepository;

import android.util.Log;

import br.com.ligeiro.cs.domain.model.Repository;
import rx.Subscriber;

/**
 * Created by Fernando on 02/11/16.
 */
public final class RepositorySubscriber<T> extends Subscriber<Repository> {

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

    }

    @Override
    public void onNext(Repository repository) {

        view.displayRepositories(repository);

    }


}

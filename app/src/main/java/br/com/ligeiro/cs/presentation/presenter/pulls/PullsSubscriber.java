package br.com.ligeiro.cs.presentation.presenter.pulls;

import android.util.Log;

import br.com.ligeiro.cs.domain.model.PullAndUser;
import rx.Subscriber;

/**
 * Created by Fernando on 02/11/16.
 */
public final class PullsSubscriber extends Subscriber<PullAndUser> {

    IPullView view;


    public PullsSubscriber(IPullView view) {

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
    public void onNext(PullAndUser pullAndUser) {
        view.displayPulls(pullAndUser);
    }

}

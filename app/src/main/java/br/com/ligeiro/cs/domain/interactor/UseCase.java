package br.com.ligeiro.cs.domain.interactor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by Fernando on 02/11/16.
 */

public abstract class UseCase<T> implements Interactor<T> {


    private Subscription subscription = Subscriptions.empty();


    abstract Observable<T> createObservable();

    @Override
    public void execute(Subscriber<T> subscriber) {

        this.subscription = createObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    @Override
    public Observable<T> execute() {
        return createObservable();
    }


    public void unSubscribe(){

        if(!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }

    }

}

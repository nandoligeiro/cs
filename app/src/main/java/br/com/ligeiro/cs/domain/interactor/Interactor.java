package br.com.ligeiro.cs.domain.interactor;


import rx.Observable;
import rx.Subscriber;

/**
 * Created by Fernando on 02/11/16.
 */

public interface Interactor<T> {

    void execute(Subscriber<T> subscriber);
    Observable<T> execute();

}

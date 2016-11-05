package br.com.ligeiro.cs.presentation.presenter;

/**
 * Created by fernando.c.moreira on 03/11/2016.
 */

public abstract class AbstPresenter<T> {

    public abstract void onBind(T view);
}

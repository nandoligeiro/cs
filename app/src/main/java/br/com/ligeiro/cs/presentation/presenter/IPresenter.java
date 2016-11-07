package br.com.ligeiro.cs.presentation.presenter;



import br.com.ligeiro.cs.presentation.view.View;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IPresenter<T extends View> {

    void onCreate();

    void onStart();

    void onStop();

    void onPause();

    void onRefreshPage();

}

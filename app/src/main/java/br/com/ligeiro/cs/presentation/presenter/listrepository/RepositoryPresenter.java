package br.com.ligeiro.cs.presentation.presenter.listrepository;



import android.content.Context;

import javax.inject.Inject;

import br.com.ligeiro.cs.R;
import br.com.ligeiro.cs.domain.interactor.GetRepositoryUseCase;
import br.com.ligeiro.cs.domain.model.Item;
import br.com.ligeiro.cs.presentation.presenter.IPresenter;
import br.com.ligeiro.cs.presentation.view.activities.MainActivity;
import br.com.ligeiro.cs.presentation.view.fragments.RepoDetailFragment;
import br.com.ligeiro.cs.presentation.view.uicomponents.FragmentUtils;


/**
 * Created by Fernando on 02/11/16.
 */

public class RepositoryPresenter implements IPresenter<IRepositoryView> {

    private final GetRepositoryUseCase useCase;

    private IRepositoryView repositoryView;

    @Inject
    public RepositoryPresenter(GetRepositoryUseCase useCase) {
        this.useCase = useCase;
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

        useCase.unSubscribe();

    }

    @Override
    public void onPause() {

    }


    public void showLoading() {


    }


    public void hideLoading() {

    }

    @Override
    public void onRefreshPage() {

       // useCase.execute(new RepositorySubscriber());

    }



    @Override
    public void onBind(IRepositoryView view) {

        this.repositoryView = view;
        useCase.execute(new RepositorySubscriber(view));

    }
}

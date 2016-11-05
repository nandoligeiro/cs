package br.com.ligeiro.cs.presentation.presenter.pulls;

import javax.inject.Inject;

import br.com.ligeiro.cs.domain.interactor.GetPullUseCase;
import br.com.ligeiro.cs.presentation.presenter.AbstPresenter;

/**
 * Created by fernando.c.moreira on 03/11/2016.
 */

public class PullPresenter extends AbstPresenter<IPullView> implements IPullPresenterView {


    private final GetPullUseCase pullUseCase;


    private IPullView iPullView;

    @Inject
    public PullPresenter(GetPullUseCase pullUseCase) {
        this.pullUseCase = pullUseCase;

    }


    @Override
    public void onBind(IPullView view) {

        this.iPullView = view;

    }

    @Override
    public void onRefresh() {
        pullUseCase.execute(new PullsSubscriber(iPullView));

    }

}

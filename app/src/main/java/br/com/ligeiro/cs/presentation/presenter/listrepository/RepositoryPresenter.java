package br.com.ligeiro.cs.presentation.presenter.listrepository;


import javax.inject.Inject;
import javax.inject.Named;

import br.com.ligeiro.cs.dagger.component.RepoComponent;
import br.com.ligeiro.cs.domain.interactor.GetRepositoryUseCase;
import br.com.ligeiro.cs.domain.model.repo.Repository;
import br.com.ligeiro.cs.presentation.presenter.AbstPresenter;


/**
 * Created by Fernando on 02/11/16.
 */

public class RepositoryPresenter extends AbstPresenter<IRepositoryView> implements IRepositoryPresenterView {

    private final GetRepositoryUseCase useCase;

    private IRepositoryView repositoryView;



    @Inject
    public RepositoryPresenter(@Named("page")GetRepositoryUseCase useCase) {
        this.useCase = useCase;
    }


    @Override
    public void onBind(IRepositoryView view) {

        this.repositoryView = view;

    }


    @Override
    public void onRefresh() {
        useCase.execute(new RepositorySubscriber(repositoryView));

    }

    @Override
    public void onRepoSelected(Repository repository) {

    }


}

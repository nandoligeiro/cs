package br.com.ligeiro.cs.presentation.presenter.listrepository;

import br.com.ligeiro.cs.domain.model.Repository;

/**
 * Created by fernando.c.moreira on 03/11/2016.
 */

public interface IRepositoryPresenterView {

    void onRefresh();
    void onRepoSelected(Repository repository);
}

package br.com.ligeiro.cs.presentation.presenter.listrepository;

import br.com.ligeiro.cs.domain.model.RepoAndUser;
import br.com.ligeiro.cs.domain.model.repo.Repository;
import br.com.ligeiro.cs.presentation.view.View;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IRepositoryView extends View {

    void displayError(String msg);

    void displayRepositories(RepoAndUser repoAndUser);

}

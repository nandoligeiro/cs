package br.com.ligeiro.cs.presentation.presenter.listrepository;

import br.com.ligeiro.cs.domain.model.Repository;
import br.com.ligeiro.cs.presentation.view.View;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IRepositoryView extends View {

    void displayError(String msg);

    void displayRepositories(Repository repository);

}

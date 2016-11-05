package br.com.ligeiro.cs.presentation.presenter.pulls;

import br.com.ligeiro.cs.domain.model.PullAndUser;
import br.com.ligeiro.cs.presentation.view.View;

/**
 * Created by fernando.c.moreira on 03/11/2016.
 */

public interface IPullView extends View {

    void displayError(String msg);

    void displayPulls(PullAndUser pullAndUser);


}

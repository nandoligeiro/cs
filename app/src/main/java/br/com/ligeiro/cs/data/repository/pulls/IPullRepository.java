package br.com.ligeiro.cs.data.repository.pulls;

import java.util.List;

import br.com.ligeiro.cs.domain.model.PullAndUser;
import br.com.ligeiro.cs.domain.model.User;
import br.com.ligeiro.cs.domain.model.pulls.Pull;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IPullRepository {

    Observable<PullAndUser> getPulls(String owner, String repo);


}

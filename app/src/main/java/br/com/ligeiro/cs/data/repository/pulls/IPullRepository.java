package br.com.ligeiro.cs.data.repository.pulls;

import br.com.ligeiro.cs.domain.model.PullAndUser;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IPullRepository {

    Observable<PullAndUser> getPulls(String owner, String repo);


}

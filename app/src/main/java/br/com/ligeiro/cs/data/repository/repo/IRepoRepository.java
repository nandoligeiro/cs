package br.com.ligeiro.cs.data.repository.repo;

import br.com.ligeiro.cs.domain.model.RepoAndUser;
import br.com.ligeiro.cs.domain.model.repo.Repository;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IRepoRepository {

    Observable<RepoAndUser> getRepositories(String page);
}

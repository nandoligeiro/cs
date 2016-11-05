package br.com.ligeiro.cs.data.repository.repo;

import br.com.ligeiro.cs.domain.model.Repository;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IRepoRepository {

    Observable<Repository> getRepositories(String page);
}

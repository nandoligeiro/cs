package br.com.ligeiro.cs.data.repository;

import javax.inject.Singleton;

import br.com.ligeiro.cs.domain.model.Repository;
import rx.Observable;

/**
 * Created by Fernando on 02/11/16.
 */

public interface IRepoRepository {

    Observable<Repository> getRepositories();
}

package br.com.ligeiro.cs.dagger.module;

import javax.inject.Named;

import br.com.ligeiro.cs.dagger.scope.PerActivity;

import br.com.ligeiro.cs.data.repository.pulls.IPullRepository;
import br.com.ligeiro.cs.data.repository.pulls.RetrofitPullRepository;
import br.com.ligeiro.cs.domain.interactor.GetPullUseCase;
import br.com.ligeiro.cs.domain.interactor.UseCase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando.c.moreira on 04/11/2016.
 */
@Module
public class PullModule {

    private String owner = "facebook";
    private String repo = "react-native";


    public PullModule(){

    }

    public PullModule(String owner, String repo){
        this.owner = owner;
        this.repo = repo;

    }


    @Provides
    IPullRepository provideIPullRepository(RetrofitPullRepository retrofitPullRepository) {
        return  retrofitPullRepository;
    }


    @Provides
    public GetPullUseCase provideGetPullUseCase(IPullRepository iPullRepository){
        return new GetPullUseCase(iPullRepository,owner, repo);
    }
}

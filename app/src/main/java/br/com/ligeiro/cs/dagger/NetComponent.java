package br.com.ligeiro.cs.dagger;


import javax.inject.Singleton;


import br.com.ligeiro.cs.data.repository.IRepoRepository;

import br.com.ligeiro.cs.presentation.view.activities.MainActivity;
import br.com.ligeiro.cs.presentation.view.adapters.ReposAdapter;
import br.com.ligeiro.cs.presentation.view.fragments.ReposFragment;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Fernando on 02/11/16.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();

    ReposFragment inject(ReposFragment fragment);
    ReposAdapter inject(ReposAdapter reposAdapter);
    MainActivity inject(MainActivity mainActivity);

    IRepoRepository iRepoRepository();


}

package br.com.ligeiro.cs.presentation.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import br.com.ligeiro.cs.R;
import br.com.ligeiro.cs.application.CsApplication;
import br.com.ligeiro.cs.dagger.PageRepoModule;
import br.com.ligeiro.cs.dagger.component.DaggerRepoComponent;
import br.com.ligeiro.cs.dagger.component.RepoComponent;
import br.com.ligeiro.cs.domain.model.Repository;
import br.com.ligeiro.cs.presentation.presenter.listrepository.IRepositoryView;
import br.com.ligeiro.cs.presentation.presenter.listrepository.RepositoryPresenter;
import br.com.ligeiro.cs.presentation.view.adapters.ReposAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReposFragment extends Fragment implements IRepositoryView {


    private Unbinder unbinder;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ReposAdapter reposAdapter;

    @Inject
    RepositoryPresenter repositoryPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeInjector();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repos, container, false);
        unbinder = ButterKnife.bind(this, view);
        setRepos();
        setAdapter();

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setPresenter() {

        repositoryPresenter.onBind(this);

    }

    private void initializeInjector() {
        RepoComponent repoComponent = DaggerRepoComponent.builder()
                .appComponent(((CsApplication) getActivity().getApplicationContext()).getNetComponent())
                .pageRepoModule(new PageRepoModule("1"))
                .build();

        repoComponent.inject(this);
        setPresenter();
    }

    private void setRepos() {
        repositoryPresenter.onRefresh();
    }

    @Override
    public void displayError(String msg) {

    }

    @Override
    public void displayRepositories(Repository repository) {
        reposAdapter.notifyAdapter(repository);

    }


    public void setAdapter() {

        reposAdapter = new ReposAdapter(getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(reposAdapter);
    }

}

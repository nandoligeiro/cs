package br.com.ligeiro.cs.presentation.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import br.com.ligeiro.cs.R;
import br.com.ligeiro.cs.application.CsApplication;
import br.com.ligeiro.cs.dagger.component.DaggerRepoComponent;
import br.com.ligeiro.cs.dagger.component.RepoComponent;
import br.com.ligeiro.cs.dagger.module.RepoModule;
import br.com.ligeiro.cs.domain.model.RepoAndUser;
import br.com.ligeiro.cs.presentation.presenter.listrepository.IRepositoryView;
import br.com.ligeiro.cs.presentation.presenter.listrepository.RepositoryPresenter;
import br.com.ligeiro.cs.presentation.view.activities.MainActivity;
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

    @Nullable
    @BindView(R.id.progressBar)
    View progressBar;

    ReposAdapter reposAdapter;
    RepoComponent repoComponent;
    LinearLayoutManager linearLayoutManager;


    @Inject
    RepositoryPresenter repositoryPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeInjector();
        setPresenter();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repos, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setRepositories();
        onScrollListener();
        setAdapter();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void displayError(String msg) {

    }

    @Override
    public void displayRepositories(RepoAndUser repoAndUser) {
        reposAdapter.notifyAdapter(repoAndUser);

    }

    private void setPresenter() {

        repositoryPresenter.onBind(this);

    }

    private void initializeInjector() {
        repoComponent = DaggerRepoComponent.builder()
                .appComponent(((CsApplication) getActivity().getApplicationContext()).getNetComponent())
                .activityModule(((MainActivity)getContext()).getActivityModule())
                .repoModule(new RepoModule())
                .build();

        repoComponent.inject(this);
    }

    private void setRepositories() {
        repositoryPresenter.onRefresh();
    }

    public void onScrollListener() {


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {

                    if ((linearLayoutManager.getChildCount() + linearLayoutManager.findFirstVisibleItemPosition())
                            >= linearLayoutManager.getItemCount()) {
                        Log.d("Scroll", "Fimmmmm");


                    }
                }
            }
        });


    }

    public void setAdapter() {

        reposAdapter = new ReposAdapter(getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(reposAdapter);
    }


}

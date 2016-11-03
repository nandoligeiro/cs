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
public class RepoDetailFragment extends Fragment implements IRepositoryView {


    private Unbinder unbinder;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    RepositoryPresenter repositoryPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

       // ((CsApplication) getActivity().getApplicationContext()).getNetComponent().inject(this);
        super.onCreate(savedInstanceState);

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



    }

    private void setPresenter() {

        repositoryPresenter.onBind(this);

    }


    public void showLoading() {

    }


    public void hideLoading() {

    }

    @Override
    public void displayError(String msg) {

    }


    @Override
    public void displayRepositories(Repository repository) {
        setAdapter(repository);

    }


    public void setAdapter(Repository repository) {

        ReposAdapter reposAdapter = new ReposAdapter(getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(reposAdapter);
    }

}

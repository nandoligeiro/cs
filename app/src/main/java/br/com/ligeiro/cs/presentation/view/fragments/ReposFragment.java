package br.com.ligeiro.cs.presentation.view.fragments;


import android.content.Context;
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

import br.com.ligeiro.cs.application.CsApplication;
import br.com.ligeiro.cs.R;
import br.com.ligeiro.cs.domain.model.Item;
import br.com.ligeiro.cs.domain.model.Repository;
import br.com.ligeiro.cs.presentation.presenter.listrepository.IRepositoryView;
import br.com.ligeiro.cs.presentation.presenter.listrepository.RepositoryPresenter;
import br.com.ligeiro.cs.presentation.view.activities.MainActivity;
import br.com.ligeiro.cs.presentation.view.adapters.ReposAdapter;
import br.com.ligeiro.cs.presentation.view.uicomponents.FragmentUtils;
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

        ((CsApplication) getActivity().getApplicationContext()).getNetComponent().inject(this);

        super.onCreate(savedInstanceState);

        showLoading();




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

        setPresenter();
        setAdapter();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setPresenter() {

        repositoryPresenter.onBind(this);

    }




    @Override
    public void displayError(String msg) {

        hideLoading();
    }


    @Override
    public void displayRepositories(Repository repository) {

        reposAdapter.notifyAdapter(repository);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    public void setAdapter() {

        reposAdapter = new ReposAdapter(getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(reposAdapter);
    }

}

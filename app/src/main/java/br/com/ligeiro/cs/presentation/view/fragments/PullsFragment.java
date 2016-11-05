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
import br.com.ligeiro.cs.dagger.component.DaggerPullComponent;
import br.com.ligeiro.cs.dagger.component.PullComponent;
import br.com.ligeiro.cs.dagger.module.PullModule;
import br.com.ligeiro.cs.domain.model.Item;
import br.com.ligeiro.cs.domain.model.PullAndUser;
import br.com.ligeiro.cs.presentation.presenter.pulls.IPullView;
import br.com.ligeiro.cs.presentation.presenter.pulls.PullPresenter;
import br.com.ligeiro.cs.presentation.view.adapters.PullsAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by fernando.c.moreira on 03/11/2016.
 */

public class PullsFragment extends Fragment implements IPullView {


    private Unbinder unbinder;

    @BindView(R.id.pullRecycleView)
    RecyclerView recyclerView;

    PullsAdapter pullsAdapter;

    Item item = new Item();
    String user;


    @Inject
    PullPresenter pullPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ((CsApplication) getActivity().getApplicationContext()).getNetComponent().inject(this);
        Bundle args = getArguments();
        item = (Item) args.getSerializable("item");
        user = args.getString("user");
        initializeInjector();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pulls, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setPulls();
        setAdapter();

    }

    private void initializeInjector() {
        PullComponent pullComponent = DaggerPullComponent.builder()
                .appComponent(((CsApplication) getActivity().getApplicationContext()).getNetComponent())
                .pullModule(new PullModule(item.getOwner().getLogin(), item.getName()))
                .build();

        pullComponent.inject(this);
        setPresenter();
    }

    private void setPresenter() {

        pullPresenter.onBind(this);

    }

    private void setPulls() {
        pullPresenter.onRefresh();
    }


    @Override
    public void displayError(String msg) {

    }

    @Override
    public void displayPulls(PullAndUser pullAndUser) {
        pullsAdapter.notifyAdapter(pullAndUser);

    }


    public void setAdapter() {

        pullsAdapter = new PullsAdapter(getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(pullsAdapter);
    }

}

package br.com.ligeiro.cs.presentation.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.ligeiro.cs.application.CsApplication;
import br.com.ligeiro.cs.R;
import br.com.ligeiro.cs.domain.model.Item;
import br.com.ligeiro.cs.domain.model.Repository;

import br.com.ligeiro.cs.presentation.presenter.listrepository.IRepositoryView;
import br.com.ligeiro.cs.presentation.presenter.listrepository.RepositoryPresenter;
import br.com.ligeiro.cs.presentation.view.activities.MainActivity;
import br.com.ligeiro.cs.presentation.view.fragments.RepoDetailFragment;
import br.com.ligeiro.cs.presentation.view.uicomponents.CircleTransform;
import br.com.ligeiro.cs.presentation.view.uicomponents.FragmentUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Fernando on 8/28/16.
 */
public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {

    Context context;
    private Unbinder unbinder;
    Repository repository;
    ArrayList<Item> items = new ArrayList<>();


    public ReposAdapter(Context context) {
        this.context = context;

    }


    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_repos, parent, false);
        return new ReposViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {

        if(items.size() > 0){
            holder.repoName.setText(repository.getItems().get(position).getName());
            holder.description.setText(repository.getItems().get(position).getDescription());
            holder.fullName.setText(repository.getItems().get(position).getFullName());
            holder.userName.setText(repository.getItems().get(position).getOwner().getLogin());

            Picasso.with(context).load(repository.getItems().get(position).getOwner().getAvatarUrl())
                    .transform(new CircleTransform()).into(holder.avatar);

        }


    }

    public void notifyAdapter(Repository repository){
        this.repository = repository;
        items = (ArrayList<Item>) repository.getItems();
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ReposViewHolder extends RecyclerView.ViewHolder {

        public ReposViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        @OnClick(R.id.cardRepo)
        public void onClickRepo(){

            FragmentUtils.getOrCreate((MainActivity) context,"repoDetail", new RepoDetailFragment(), R.id.fragment_container);

        }




        @BindView(R.id.avatar)
        ImageView avatar;

        @BindView(R.id.fullName)
        TextView fullName;

        @BindView(R.id.username)
        TextView userName;

        @BindView(R.id.repoName)
        TextView repoName;

        @BindView(R.id.description)
        TextView description;


    }
}

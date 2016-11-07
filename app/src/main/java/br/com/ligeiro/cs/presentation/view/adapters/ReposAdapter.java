package br.com.ligeiro.cs.presentation.view.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.ligeiro.cs.R;
import br.com.ligeiro.cs.domain.model.RepoAndUser;
import br.com.ligeiro.cs.domain.model.repo.Item;
import br.com.ligeiro.cs.domain.model.repo.User;
import br.com.ligeiro.cs.presentation.view.activities.MainActivity;
import br.com.ligeiro.cs.presentation.view.fragments.PullsFragment;
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
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();


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


        if (items.size() > 0) {
            holder.repoName.setText(items.get(position).getName());
            holder.description.setText(items.get(position).getDescription());
            holder.fullName.setText(users.get(position).getName());
            holder.userName.setText(items.get(position).getOwner().getLogin());
            holder.stars.setText(items.get(position).getStargazersCount().toString());
            holder.forks.setText(items.get(position).getForks().toString());

            Picasso.with(context).load(items.get(position).getOwner().getAvatarUrl())
                    .transform(new CircleTransform()).into(holder.avatar);

        }


    }

    public void notifyAdapter(RepoAndUser repoAndUser) {

        items = repoAndUser.items;
        users = repoAndUser.users;
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
        public void onClickRepo() {

            Bundle args = new Bundle();
            PullsFragment pullsFragment = new PullsFragment();
            args.putSerializable("item", items.get(getLayoutPosition()));
            pullsFragment.setArguments(args);
            FragmentUtils.getOrCreate((MainActivity) context, "repoDetail", pullsFragment, R.id.fragment_container);

        }


        @BindView(R.id.avatar)
        ImageView avatar;

        @BindView(R.id.fullName)
        TextView fullName;

        @BindView(R.id.username)
        TextView userName;

        @BindView(R.id.title)
        TextView repoName;

        @BindView(R.id.pullDescription)
        TextView description;

        @BindView(R.id.stars)
        TextView stars;

        @BindView(R.id.forks)
        TextView forks;


    }
}

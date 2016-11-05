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
import java.util.LinkedHashMap;

import br.com.ligeiro.cs.R;
import br.com.ligeiro.cs.domain.model.PullAndUser;
import br.com.ligeiro.cs.domain.model.User;
import br.com.ligeiro.cs.domain.model.pulls.Pull;
import br.com.ligeiro.cs.presentation.view.uicomponents.CircleTransform;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Fernando on 8/28/16.
 */
public class PullsAdapter extends RecyclerView.Adapter<PullsAdapter.PullsViewHolder> {

    Context context;
    private Unbinder unbinder;
    ArrayList<Pull> pulls = new ArrayList<>();
    ArrayList<User> user = new ArrayList<>();
    LinkedHashMap<User, Pull> hash = new LinkedHashMap<>();

    public PullsAdapter(Context context) {
        this.context = context;

    }


    @Override
    public PullsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_pulls, parent, false);
        return new PullsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PullsViewHolder holder, int position) {

        if (pulls.size() > 0) {

            holder.title.setText(pulls.get(position).getTitle());
            holder.description.setText(pulls.get(position).getBody());
            holder.userName.setText(pulls.get(position).getUser().getLogin());

            Picasso.with(context).load(pulls.get(position).getUser().getAvatarUrl())
                    .transform(new CircleTransform()).into(holder.avatar);

            holder.fullName.setText(user.get(position).getName());

        }


    }

    public void notifyAdapter(PullAndUser pullAndUser) {

        this.pulls = pullAndUser.pulls;
        this.user = pullAndUser.users;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return pulls.size();
    }


    public class PullsViewHolder extends RecyclerView.ViewHolder {

        public PullsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        @BindView(R.id.avatar)
        ImageView avatar;

        @BindView(R.id.fullName)
        TextView fullName;

        @BindView(R.id.username)
        TextView userName;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.pullDescription)
        TextView description;


    }
}

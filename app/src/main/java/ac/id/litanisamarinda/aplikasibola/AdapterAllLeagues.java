package ac.id.litanisamarinda.aplikasibola;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ac.id.litanisamarinda.aplikasibola.model.League;

public class AdapterAllLeagues extends RecyclerView.Adapter<AdapterAllLeagues.LeagueViewHolder> {

    List<League> leagueList=new ArrayList<>();
    private final Activity activity;
    public final String DATA_LEAGUE="data_league";

    public AdapterAllLeagues(Activity activity) {
        this.activity = activity;
    }

    public void setLeagueList(List<League> leagueList) {
        this.leagueList = leagueList;
        notifyDataSetChanged(); //memberi notif jika ada data baru dalam list
    }

    @NonNull
    @Override
    public LeagueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_league,parent, false);
        return new LeagueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeagueViewHolder holder, int position) {
        holder.tvNamaLiga.setText(leagueList.get(position).getStrLeague());

        Picasso.get().load(leagueList.get(position).getStrBadge())
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return leagueList.size();
    }

    class LeagueViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivLogo;
        public TextView tvNamaLiga;

        public LeagueViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogo=itemView.findViewById(R.id.iv_logo);
            tvNamaLiga=itemView.findViewById(R.id.tvNamaLiga);
        }
    }


}

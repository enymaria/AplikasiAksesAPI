package ac.id.litanisamarinda.aplikasibola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ac.id.litanisamarinda.aplikasibola.httpclient.ApiClient;
import ac.id.litanisamarinda.aplikasibola.httpclient.ApiInterface;
import ac.id.litanisamarinda.aplikasibola.model.ResponseAllLeagues;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvLeague;
    private AdapterAllLeagues adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvLeague = findViewById(R.id.rv_league);
        adapter = new AdapterAllLeagues(this);
        rvLeague.setHasFixedSize(true);
        rvLeague.setLayoutManager(new GridLayoutManager(this,2));
        rvLeague.setAdapter(adapter);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        getApiAllLeague();
    }

    public void getApiAllLeague(){
        Call<ResponseAllLeagues> api=apiInterface.getAllLeague();
        api.enqueue(new Callback<ResponseAllLeagues>() {
            @Override
            public void onResponse(Call<ResponseAllLeagues> call, Response<ResponseAllLeagues> response) {

                if(response.isSuccessful()){
                    adapter.setLeagueList(response.body().getAllLeagues());
                }

            }

            @Override
            public void onFailure(Call<ResponseAllLeagues> call, Throwable t) {

            }
        });
    }
}

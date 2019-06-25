package ac.id.litanisamarinda.aplikasibola.httpclient;


import ac.id.litanisamarinda.aplikasibola.model.ResponseAllLeagues;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search_all_leagues.php?s=Soccer")
    Call<ResponseAllLeagues> getAllLeague();
}

package io.github.gothwski.mygithubprofile.data;

import io.github.gothwski.mygithubprofile.Constants;
import io.github.gothwski.mygithubprofile.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ariana on 13/07/15.
 */
public interface RetrofitUserApi {

    @GET(Constants.Api.URL_USER)
    Call<User> getUserProfile(@Path("user") String user);
}

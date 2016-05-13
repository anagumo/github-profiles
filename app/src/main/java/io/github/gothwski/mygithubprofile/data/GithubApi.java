package io.github.gothwski.mygithubprofile.data;

import io.github.gothwski.mygithubprofile.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public interface GithubApi {

    @GET(GithubConstants.URL_USER)
    Call<User> getUserProfile(@Path("user") String user);
}
package io.github.gothwski.mygithubprofile.io;

import io.github.gothwski.mygithubprofile.io.model.User;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public interface GithubService {

    @GET(ApiConstants.URL_USER)
    void getGithubProfile(@Path("user") String user, Callback<User> callback);
}

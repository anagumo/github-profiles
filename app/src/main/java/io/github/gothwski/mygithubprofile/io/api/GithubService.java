package io.github.gothwski.mygithubprofile.io.api;

import io.github.gothwski.mygithubprofile.io.api.GithubConstants;
import io.github.gothwski.mygithubprofile.io.domain.User;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public interface GithubService {

    @GET(GithubConstants.URL_USER)
    void getGithubProfile(@Path("user") String user, Callback<User> callback);
}

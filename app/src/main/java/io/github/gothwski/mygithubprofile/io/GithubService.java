package io.github.gothwski.mygithubprofile.io;

import io.github.gothwski.mygithubprofile.domain.User;
import io.github.gothwski.mygithubprofile.io.GithubConstants;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ariana on 13/07/15.
 */
public interface GithubService {

    @GET(GithubConstants.URL_USER)
    void getGithubProfile(@Path("user") String user, Callback<User> callback);
}

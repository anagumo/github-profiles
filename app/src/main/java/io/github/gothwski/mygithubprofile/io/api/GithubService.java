package io.github.gothwski.mygithubprofile.io.api;

import io.github.gothwski.mygithubprofile.io.domain.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public interface GithubService {

    @GET(GithubConstants.URL_USER)
    Call<User> getGithubProfile(@Path("user") String user);
}

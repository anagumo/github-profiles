package io.github.gothwski.mygithubprofile.data;

import io.github.gothwski.mygithubprofile.data.GithubApi;
import io.github.gothwski.mygithubprofile.data.GithubConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public class GithubService {

    private static GithubApi GITHUB_API;

    public static GithubApi getApi() {

        if (GITHUB_API == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(GithubConstants.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GITHUB_API = retrofit.create(GithubApi.class);
        }

        return GITHUB_API;
    }
}

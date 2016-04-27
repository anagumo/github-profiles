package io.github.gothwski.mygithubprofile.io.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public class GitHubAdapter {

    private static GithubService API_SERVICE;

    public static GithubService getApiService() {

        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(GithubConstants.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_SERVICE = retrofit.create(GithubService.class);
        }

        return API_SERVICE;
    }
}

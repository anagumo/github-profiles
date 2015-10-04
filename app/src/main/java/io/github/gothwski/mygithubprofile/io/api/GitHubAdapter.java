package io.github.gothwski.mygithubprofile.io.api;

import retrofit.RestAdapter;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public class GitHubAdapter {

    private static GithubService API_SERVICE;

    public static GithubService getApiService() {

        if (API_SERVICE == null) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(GithubConstants.URL_BASE)
                    .build();

            API_SERVICE = adapter.create(GithubService.class);
        }

        return API_SERVICE;
    }
}

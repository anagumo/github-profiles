package io.github.gothwski.mygithubprofile.user;

import io.github.gothwski.mygithubprofile.data.GithubService;
import io.github.gothwski.mygithubprofile.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ariana on 13/05/16.
 */
public class UserProfilePresenter implements Callback<User> {

    private UserProfileContract.View mView;


    public UserProfilePresenter(UserProfileContract.View view) {
        mView = view;
    }

    //TODO: Add Repository pattern
    public void fetchUserProfile() {
        GithubService
                .getApi()
                .getUserProfile("android10")
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        User user = response.body();
        mView.showUserProfile(user);
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {

    }
}

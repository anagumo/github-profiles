package io.github.gothwski.mygithubprofile.data;

import io.github.gothwski.mygithubprofile.model.User;

/**
 * Created by Ariana on 13/05/16.
 */
public class UserRepositoryImpl implements UserRepository {

    private UserServerService mService;

    public UserRepositoryImpl(UserServerService service) {
        mService = service;
    }

    @Override
    public void fetchUserProfile(String user, final Callback<User> callback) {
        mService.fetchUserProfile(user, new UserServerService.UserServerCallback<User>() {
            @Override
            public void onSuccess(User response) {
                callback.onSuccess(response);
            }

            @Override
            public void onError(Throwable error) {
                callback.onError(error);
            }
        });
    }
}

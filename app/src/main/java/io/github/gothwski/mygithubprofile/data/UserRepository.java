package io.github.gothwski.mygithubprofile.data;

import io.github.gothwski.mygithubprofile.model.User;

/**
 * Created by Ariana on 13/05/16.
 */
public interface UserRepository {

    interface Callback<T> {
        void onSuccess(T response);

        void onError(Throwable error);
    }

    void fetchUserProfile(String user, Callback<User> callback);
}

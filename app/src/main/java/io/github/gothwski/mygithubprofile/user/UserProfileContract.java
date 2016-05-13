package io.github.gothwski.mygithubprofile.user;

import io.github.gothwski.mygithubprofile.model.User;

/**
 * Created by Ariana on 13/05/16.
 */

public interface UserProfileContract {

    interface View {
        void showUserProfile(User user);
    }

    interface UserActionListener {

    }
}

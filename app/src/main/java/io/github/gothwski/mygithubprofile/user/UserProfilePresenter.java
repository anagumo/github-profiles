package io.github.gothwski.mygithubprofile.user;

import io.github.gothwski.mygithubprofile.data.UserRepository;
import io.github.gothwski.mygithubprofile.model.User;

/**
 * Created by Ariana on 13/05/16.
 */
public class UserProfilePresenter {

    private UserProfileContract.View mView;
    private UserRepository mUserRepository;


    public UserProfilePresenter(UserProfileContract.View view, UserRepository userRepository) {
        mView = view;
        mUserRepository = userRepository;
    }

    public void fetchUserProfile(String user) {
        mUserRepository.fetchUserProfile(user, new UserRepository.Callback<User>() {
            @Override
            public void onSuccess(User response) {
                mView.showUserProfile(response);
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }
}

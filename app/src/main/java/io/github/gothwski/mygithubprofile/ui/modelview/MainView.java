package io.github.gothwski.mygithubprofile.ui.modelview;

import io.github.gothwski.mygithubprofile.domain.User;

/**
 * Created by ariana on 7/10/15.
 */
public interface MainView {

    void showDataProfile(User user);
    void showNetworkError(String message);
}

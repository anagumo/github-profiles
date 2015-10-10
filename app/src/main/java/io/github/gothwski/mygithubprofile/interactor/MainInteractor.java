package io.github.gothwski.mygithubprofile.interactor;

import io.github.gothwski.mygithubprofile.io.GitHubAdapter;
import io.github.gothwski.mygithubprofile.domain.User;
import io.github.gothwski.mygithubprofile.presenter.MainPresenterImpl;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ariana on 7/10/15.
 */
public class MainInteractor implements Callback<User> {

    private MainPresenterImpl mainPresenterImpl;

    public MainInteractor(MainPresenterImpl mainPresenterImpl) {
        this.mainPresenterImpl = mainPresenterImpl;
    }

    public void requestUser(String user){
        GitHubAdapter.getApiService()
                .getGithubProfile(user, this);
    }

    @Override
    public void success(User user, Response response) {
        mainPresenterImpl.onSuccess(user);
    }

    @Override
    public void failure(RetrofitError error) {
        mainPresenterImpl.onError(error);
    }
}

package io.github.gothwski.mygithubprofile.presenter;

import io.github.gothwski.mygithubprofile.domain.User;
import io.github.gothwski.mygithubprofile.interactor.MainInteractor;
import io.github.gothwski.mygithubprofile.ui.modelview.MainView;
import retrofit.RetrofitError;

/**
 * Created by ariana on 7/10/15.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    MainInteractor mainInteractor;


    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mainInteractor = new MainInteractor(this);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    public void onSearchUser(String query){
        mainInteractor.requestUser(query);
    }

    public void onSuccess(User user){
        mainView.showDataProfile(user);
    }

    public void onError(RetrofitError error){
        mainView.showNetworkError(error.toString());
    }
}

package io.github.gothwski.mygithubprofile.data;

import io.github.gothwski.mygithubprofile.Constants;
import io.github.gothwski.mygithubprofile.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ariana on 13/07/15.
 */
public class UserServerServiceImpl implements UserServerService {

    private static RetrofitUserApi userApi;

    public static RetrofitUserApi getUserApi() {

        if (userApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.Api.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            userApi = retrofit.create(RetrofitUserApi.class);
        }

        return userApi;
    }

    @Override
    public void fetchUserProfile(String user, final UserServerCallback<User> callback) {
        userApi.getUserProfile(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}

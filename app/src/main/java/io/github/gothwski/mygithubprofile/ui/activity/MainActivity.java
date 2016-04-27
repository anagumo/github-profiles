package io.github.gothwski.mygithubprofile.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import io.github.gothwski.mygithubprofile.R;
import io.github.gothwski.mygithubprofile.io.api.GitHubAdapter;
import io.github.gothwski.mygithubprofile.io.domain.User;
import io.github.gothwski.mygithubprofile.ui.commons.BaseActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements Callback<User> {

    @Bind(R.id.textUsername)
    TextView mUsername;
    @Bind(R.id.textCompany)
    TextView mCompany;
    @Bind(R.id.textMail)
    TextView mMail;
    @Bind(R.id.textBlog)
    TextView mBlog;
    @Bind(R.id.imgAvatar)
    ImageView mAvatar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchUserProfile();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    private void fetchUserProfile() {
        GitHubAdapter
                .getApiService()
                .getGithubProfile("android10")
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        User user = response.body();
        setDataProfile(user);
        setAvatarProfile(user);
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        //TODO: Log error here since request failed
    }

    public void setDataProfile(User user) {
        collapsingToolbar.setTitle(user.getName());
        mUsername.setText(user.getUsername());
        mCompany.setText(user.getCompany());
        mMail.setText(user.getEmail());
        mBlog.setText(user.getBlog());
    }

    public void setAvatarProfile(User user) {
        Glide.with(getBaseContext())
                .load(user.getAvatarURL())
                .into(mAvatar);
    }
}

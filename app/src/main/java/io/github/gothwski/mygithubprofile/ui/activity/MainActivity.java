package io.github.gothwski.mygithubprofile.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import io.github.gothwski.mygithubprofile.R;
import io.github.gothwski.mygithubprofile.io.api.GitHubAdapter;
import io.github.gothwski.mygithubprofile.io.domain.User;
import io.github.gothwski.mygithubprofile.ui.commons.BaseActivity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity implements Callback<User> {

    @Bind(R.id.textName)
    TextView mName;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
        GitHubAdapter.getApiService()
                .getGithubProfile("josevalim", this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void success(User user, Response response) {
        setDataProfile(user);
        setAvatarProfile(user);
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }

    public void setDataProfile(User user) {
        //TODO: Clean Code
        mName.setText(user.getName());
        mUsername.setText(user.getUsername());
        mCompany.setText(user.getCompany());
        mMail.setText(user.getEmail());
        mBlog.setText(user.getBlog());
    }

    public void setAvatarProfile(User user){
        Picasso.with(getBaseContext())
                .load(user.getAvatarURL())
                .into(mAvatar);
    }
}

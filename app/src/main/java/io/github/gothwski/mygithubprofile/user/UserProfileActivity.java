package io.github.gothwski.mygithubprofile.user;

import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import io.github.gothwski.mygithubprofile.R;
import io.github.gothwski.mygithubprofile.common.BaseActivity;
import io.github.gothwski.mygithubprofile.data.Injection;
import io.github.gothwski.mygithubprofile.model.User;

public class UserProfileActivity extends BaseActivity implements UserProfileContract.View {

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
    private UserProfilePresenter mPresenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter = new UserProfilePresenter(this, Injection.provideUserRepository());
        mPresenter.fetchUserProfile("android10");
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

    @Override
    public void showUserProfile(User user) {
        setDataProfile(user);
        setAvatarProfile(user);
    }
}

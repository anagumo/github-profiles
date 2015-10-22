package io.github.gothwski.mygithubprofile.ui.activity;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import io.github.gothwski.mygithubprofile.R;
import io.github.gothwski.mygithubprofile.domain.User;
import io.github.gothwski.mygithubprofile.presenter.MainPresenterImpl;
import io.github.gothwski.mygithubprofile.ui.commons.BaseActivity;
import io.github.gothwski.mygithubprofile.ui.modelview.MainView;

public class MainActivity extends BaseActivity implements MainView {

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

    MainPresenterImpl mainPresenterImpl;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenterImpl = new MainPresenterImpl(this);
        mainPresenterImpl.onSearchUser(getString(R.string.user));
    }

    @Override
    public void showDataProfile(User user) {
        collapsingToolbar.setTitle(user.getName());
        mUsername.setText(user.getUsername());
        mCompany.setText(user.getCompany());
        mMail.setText(user.getEmail());
        mBlog.setText(user.getBlog());
        setAvatarProfile(user);
    }

    public void setAvatarProfile(User user) {
        Picasso.with(getBaseContext())
                .load(user.getAvatarURL())
                .into(mAvatar);
    }

    @Override
    public void showNetworkError(String message) {
        Snackbar.make(mBlog, message, Snackbar.LENGTH_LONG)
                .show();
    }
}

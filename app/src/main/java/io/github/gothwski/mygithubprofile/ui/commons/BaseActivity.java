package io.github.gothwski.mygithubprofile.ui.commons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.gothwski.mygithubprofile.R;

/**
 * Created by ariana on 3/10/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        injectViews();
        setupToolbar();
    }

    protected abstract int getLayout();

    public void setupToolbar(){
        setSupportActionBar(toolbar);
    }

    private void injectViews(){
        ButterKnife.bind(this);
    }
}

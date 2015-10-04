package io.github.gothwski.mygithubprofile.ui.commons;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by gothwski on 3/10/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        injectViews();
    }

    protected abstract int getLayout();

    private void injectViews(){
        ButterKnife.bind(this);
    }
}

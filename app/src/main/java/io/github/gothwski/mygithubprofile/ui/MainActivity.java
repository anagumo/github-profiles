package io.github.gothwski.mygithubprofile.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.github.gothwski.mygithubprofile.R;
import io.github.gothwski.mygithubprofile.io.GitHubAdapter;
import io.github.gothwski.mygithubprofile.io.model.User;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements Callback<User> {

    private TextView mGithubName;
    private ImageView mGithubAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGithubName = (TextView) findViewById(R.id.name);
        mGithubAvatar = (ImageView) findViewById(R.id.avatar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        GitHubAdapter.getApiService()
                .getGithubProfile("JakeWharton", this);
    }

    @Override
    public void success(User user, Response response) {
        mGithubName.setText(user.getName() + "\n"
                + user.getUsername() + "\n"
                + user.getCompany() + "\n"
                + user.getEmail() + "\n"
                + user.getBlog() + "\n");

        Picasso.with(getBaseContext())
                .load(user.getAvatarURL())
                .into(mGithubAvatar);
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}

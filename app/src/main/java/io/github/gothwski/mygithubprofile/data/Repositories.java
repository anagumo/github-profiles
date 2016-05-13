package io.github.gothwski.mygithubprofile.data;

import android.support.annotation.NonNull;

/**
 * Created by Ariana on 13/05/16.
 */
public class Repositories {

    public static UserRepository userRepository = null;

    public static UserRepository getUserRepository(@NonNull UserServerService userServerService) {
        if (userRepository == null)
            userRepository = new UserRepositoryImpl(userServerService);

        return userRepository;
    }
}

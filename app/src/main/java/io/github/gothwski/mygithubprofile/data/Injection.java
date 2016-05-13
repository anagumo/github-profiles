package io.github.gothwski.mygithubprofile.data;

/**
 * Created by Ariana on 13/05/16.
 */
public class Injection {

    public static UserRepository provideUserRepository() {
        return Repositories.getUserRepository(new UserServerServiceImpl());
    }
}

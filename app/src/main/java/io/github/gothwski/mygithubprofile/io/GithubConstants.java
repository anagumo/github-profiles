package io.github.gothwski.mygithubprofile.io;

/**
 * Created by ariana on 13/07/15.
 */
public class GithubConstants {

    public static final String URL_BASE = "https://api.github.com";

    public static final String PATH_USERS = "users";

    public static final String PATH_USER = "{user}";

    //https://api.github.com/users/user
    public static final String URL_USER = "/" + PATH_USERS + "/" + PATH_USER;
}

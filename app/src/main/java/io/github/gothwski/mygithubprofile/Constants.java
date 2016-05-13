package io.github.gothwski.mygithubprofile;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public class Constants {

    public class Api {
        public static final String URL_BASE = "https://api.github.com";
        public static final String PATH_USERS = "users";
        public static final String PATH_USER = "{user}";

        //https://api.github.com/users/user
        public static final String URL_USER = "/" + PATH_USERS + "/" + PATH_USER;
    }

    public class UserJsonKeys {
        public static final String USERNAME = "login";
        public static final String NAME = "name";
        public static final String AVATAR_URL = "avatar_url";
        public static final String COMPANY = "company";
        public static final String BLOG = "blog";
        public static final String EMAIL = "email";
    }
}

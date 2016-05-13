package io.github.gothwski.mygithubprofile.model;

import com.google.gson.annotations.SerializedName;

import io.github.gothwski.mygithubprofile.Constants;

/**
 * Created by ariana gothwski on 13/07/15.
 */
public class User {

    @SerializedName(Constants.UserJsonKeys.USERNAME)
    private String username;

    @SerializedName(Constants.UserJsonKeys.NAME)
    private String name;

    @SerializedName(Constants.UserJsonKeys.AVATAR_URL)
    private String avatarURL;

    @SerializedName(Constants.UserJsonKeys.COMPANY)
    private String company;

    @SerializedName(Constants.UserJsonKeys.BLOG)
    private String blog;

    @SerializedName(Constants.UserJsonKeys.EMAIL)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package io.github.gothwski.mygithubprofile.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ariana on 13/07/15.
 */
public class User {

    @SerializedName(JsonKeys.USERNAME)
    private String username;

    @SerializedName(JsonKeys.NAME)
    private String name;

    @SerializedName(JsonKeys.AVATAR_URL)
    private String avatarURL;

    @SerializedName(JsonKeys.COMPANY)
    private String company;

    @SerializedName(JsonKeys.BLOG)
    private String blog;

    @SerializedName(JsonKeys.EMAIL)
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

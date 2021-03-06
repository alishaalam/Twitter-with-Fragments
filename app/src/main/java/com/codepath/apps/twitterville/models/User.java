package com.codepath.apps.twitterville.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel(analyze={User.class})
public class User extends Model {

    @Column(name = "Name")
    public String name;

    @Column(name = "Uid", unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    public Long uid;

    public String screenName;
    public String profileImageUrl;
    public String profileBackgroundImageUrl;
    public String description;
    public boolean following;
    public boolean favorite;
    public long friends_count;
    public long followers_count;


    public User(){ super(); }

    public static User fromJSON(JSONObject json) {
        User u = new User();
        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");

            u.save();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return u;
    }


    public static User fromUserJSON(JSONObject json) {
        User u = new User();
        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.description = json.getString("description");
            u.profileImageUrl = json.getString("profile_image_url");
            u.profileBackgroundImageUrl = json.getString("profile_banner_url");
            u.following = json.getBoolean("following");
            u.favorite = json.getJSONObject("status").getBoolean("favorited");
            u.friends_count=json.getLong("friends_count");
            u.followers_count=json.getLong("followers_count");

            u.save();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return u;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFollowing() {
        return following;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public long getFriends_count() {
        return friends_count;
    }

    public long getFollowers_count() {
        return followers_count;
    }

    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }

    public String getFormattedScreenName() {
        return String.format("@%s", screenName);
    }

    public String getScreenName() {
        return screenName;
    }

    public static User fromUserId(Long userId) {
        return new Select()
                .from(User.class)
                .where("Uid = ?", userId)
                .limit(1).executeSingle();
    }

}

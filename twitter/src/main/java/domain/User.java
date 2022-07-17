package domain;

import base.BaseDomain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User extends BaseDomain<Long> {
    private String firstname;
    private String lastName;

    public User() {
    }

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Tweet> tweetsList;
    @OneToMany(mappedBy = "user")
    private List<UserLikes> userLikes;

    public User(String firstname, String lastName, String username, String phoneNumber) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public User(Long aLong, String firstname, String lastName, String username, String phoneNumber) {
        super(aLong);
        this.firstname = firstname;
        this.lastName = lastName;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Tweet> getTweetsList() {
        return tweetsList;
    }

    public List<UserLikes> getUserLikes() {
        return userLikes;
    }
}

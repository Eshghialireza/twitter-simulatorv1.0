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
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String firstname, String lastName, String password, String username) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
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

package com.codeup.springblog.model;

import javax.persistence.*;

@Entity
//@Table(name="spring_ads")
public class Post {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id; // set the field for id

    @Column(nullable = false, length = 50) // NOT NULL , LENGTH 100 ,VARCHAR 100
    private String  title;

    @Column (nullable = false) // NOT NULL and no other customization.
    private String description;

     @ManyToOne
     @JoinColumn( name = "user_id")
     private User user;

    public Post(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Post(String title, String description){
        this.title =title;
        this.description = description;
    }

    public Post(User user, String title, String description){
        this.user = user;
        this.title = title;
        this.description =description;
    }


public Post(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

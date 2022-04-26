package com.codeup.springblog.repositories;

import com.codeup.springblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {


    // trying to authenticate users, we need to find users by username

    User findByUsername (String username);

}



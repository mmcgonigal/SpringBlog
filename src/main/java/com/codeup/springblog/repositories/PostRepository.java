package com.codeup.springblog.repositories;

import com.codeup.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {
    // < typeof entity, type of data that identify the data , usually it is Long >
    //this is my  DAO ..


}

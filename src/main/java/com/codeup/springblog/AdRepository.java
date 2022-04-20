package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository <Ad, Long> {
    // < typeof entity, type of data that identify the data , usually it is Long >
}

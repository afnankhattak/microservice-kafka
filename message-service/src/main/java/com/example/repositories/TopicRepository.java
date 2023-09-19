package com.example.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Topic;


@Repository
public interface TopicRepository extends JpaRepository<Topic,Long>{

}

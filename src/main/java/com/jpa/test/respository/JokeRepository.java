package com.jpa.test.respository;

import com.jpa.test.entity.Jokes;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends JpaRepository<Jokes, Integer> {
}

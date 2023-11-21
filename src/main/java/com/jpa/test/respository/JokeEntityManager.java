package com.jpa.test.respository;

import com.jpa.test.entity.Jokes;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public class JokeEntityManager {
    private final EntityManager entityManager;

    public JokeEntityManager(@Autowired  EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(String joke) {
        Jokes newJoke = new Jokes(joke, new Date());
        entityManager.persist(newJoke);
    }

    public void saveAll(Set<String> allJokes){
        for (String joke: allJokes) {
            Jokes newJoke = new Jokes(joke,new Date());
            entityManager.persist(newJoke);
        }

    }
    public Jokes findById(int id){
        return entityManager.find(Jokes.class,id);
    }

    public void deleteById(Integer id) {
        entityManager.remove(findById(id));
        //System.out.println();
    }

    public void deleteAll() {
        entityManager.createQuery("delete from Jokes").executeUpdate();
    }
}

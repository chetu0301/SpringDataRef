package com.jpa.test.service;

import com.jpa.test.entity.Jokes;
import com.jpa.test.respository.JokeEntityManager;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JokeService {
    private final ChuckNorrisQuotes chuckNorrisQuotes;
    private final JokeEntityManager jokeEntityManager;

    public JokeService(@Autowired ChuckNorrisQuotes chuckNorrisQuotes, JokeEntityManager jokeEntityManager) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
        this.jokeEntityManager = jokeEntityManager;
    }

    @Transactional
    public String getRandomJoke() {
        String joke = chuckNorrisQuotes.getRandomQuote();
        jokeEntityManager.save(joke);
        return joke;
    }
    @Transactional
    public Set<String> getAllJokes() {
        Set<String> allJokes = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            String joke= chuckNorrisQuotes.getRandomQuote();
            allJokes.add(joke);

        }
        jokeEntityManager.saveAll(allJokes);
        return allJokes;

    }

    public String findById(int id) {
        Jokes jokes = jokeEntityManager.findById(id);
        return jokes.getJoke();
    }
    @Transactional
    public void deleteById(Integer id){
        jokeEntityManager.deleteById(id);
    }
    @Transactional

    public void deleteAll() {
        jokeEntityManager.deleteAll();
    }
}

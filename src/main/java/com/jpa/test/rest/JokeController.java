package com.jpa.test.rest;

import com.jpa.test.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
public class JokeController {
    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService){
        this.jokeService = jokeService;
    }



    @GetMapping("/joke")
    public String getAJoke(){
        String joke = jokeService.getRandomJoke();
        return joke;
    }
    @GetMapping("/getAllJokes")
    public Set<String> getAllJokes(){
        Set<String> allJokes = jokeService.getAllJokes();
        return  allJokes;
    }
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") Integer id){

        return jokeService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        jokeService.deleteById(id);
    }
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        jokeService.deleteAll();
    }

}

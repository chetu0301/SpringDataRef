package com.jpa.test.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="jokes")
public class Jokes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "joke")
    private String joke;
    @Column(name = "date")
    private Date date;

    public Jokes(String joke, Date date) {
        this.joke = joke;
        this.date = date;
    }

    public Jokes() {

    }


    public int getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "JokeEntity" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                ", date='" + date + '\''
                ;
    }
}

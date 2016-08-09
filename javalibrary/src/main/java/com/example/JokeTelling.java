package com.example;

import java.util.Random;

public class JokeTelling {
    private String[] jokes;
    private Random random;

    public JokeTelling() {
        jokes = new String[4];
        jokes[0] = "Joke 1 - haha";
        jokes[1] = "Joke 2 - haha";
        jokes[2] = "Joke 3 - haha";
        jokes[3] = "Joke 4 - haha";
        random = new Random();
    }

    public String[] getJokes(){

        return jokes;
        }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }

}

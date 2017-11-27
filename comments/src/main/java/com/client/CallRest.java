package com.client;

import com.model.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRest implements CommandLineRunner {

    private static void callRestService(){
        printAll(getAll());
    }

    /**
     * returns a vector with comments
     * @return
     */
    private static Comment [] getAll(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment [].class);
    }


    /**
     * Prints all comments from vector
     * @param comments
     */
    private static void printAll(Comment[] comments){
        System.out.println("comment list");
        for (int i = 0; i<comments.length; i++){
            System.out.println("Mail: "+ comments[i].getEmail()+ " " + "Name:"+ comments[i].getName() + " " + comments[i].getBody());
        }
    }

    /**
     * Runs the system
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {
        callRestService();
    }
}

package com.example.concurrency.services;

import com.example.concurrency.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        CompletableFuture<User> user1 = userService.findUser("PivotalSoftware");
        CompletableFuture<User> user2 = userService.findUser("CloudFoundry");
        CompletableFuture<User> user3 = userService.findUser("Spring-Projects");

        CompletableFuture.allOf(user1, user2, user3).join();

        System.out.println(user1.get());
        System.out.println(user2.get());
        System.out.println(user3.get());
    }

}

package com.swift.fusers.handler;

import com.mongodb.MongoClient;
import com.networknt.handler.LightHttpHandler;
import com.swift.fusers.repository.UserRepository;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class UsersDeleteHandler implements LightHttpHandler {
    private UserRepository repository;

    public UsersDeleteHandler() {
        repository = new UserRepository(new MongoClient());
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        exchange.setStatusCode(200);
        repository.deleteAllUsers();
        exchange.getResponseSender().send("All Users Deleted");
    }
}

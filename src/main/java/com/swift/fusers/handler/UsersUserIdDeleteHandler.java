package com.swift.fusers.handler;

import com.mongodb.MongoClient;
import com.networknt.handler.LightHttpHandler;
import com.swift.fusers.repository.UserRepository;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class UsersUserIdDeleteHandler implements LightHttpHandler {
    private UserRepository repository;

    public UsersUserIdDeleteHandler() {
        repository = new UserRepository(new MongoClient());
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        try {
            repository.deleteUser(Integer.parseInt(exchange.getPathParameters().get("userId").getFirst()));
            exchange.setStatusCode(200);
            exchange.getResponseSender().send("User Deleted");
        } catch (Exception e) {
            exchange.setStatusCode(401);
            exchange.getResponseSender().send("No such user found");
        }
    }
}

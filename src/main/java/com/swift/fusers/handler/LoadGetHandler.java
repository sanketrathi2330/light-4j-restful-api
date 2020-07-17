package com.swift.fusers.handler;

import com.mongodb.MongoClient;
import com.networknt.handler.LightHttpHandler;
import com.swift.fusers.repository.UserRepository;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class LoadGetHandler implements LightHttpHandler {
    private UserRepository repository;

    public LoadGetHandler() {
        repository = new UserRepository(new MongoClient());
        repository.setBasicData();
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        try {
            repository.setBasicData();
            exchange.setStatusCode(200);
            exchange.getResponseSender().send("Data Added");
        } catch (Exception e ) {
            exchange.setStatusCode(500);
            exchange.getResponseSender().send("Data Already Present");
        }
    }
}

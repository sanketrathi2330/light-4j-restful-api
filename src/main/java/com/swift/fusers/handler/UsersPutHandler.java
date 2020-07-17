package com.swift.fusers.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.networknt.body.BodyHandler;
import com.networknt.handler.LightHttpHandler;
import com.swift.fusers.model.User;
import com.swift.fusers.repository.UserRepository;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

import java.util.Map;

public class UsersPutHandler implements LightHttpHandler {
    private ObjectMapper mapper;
    private UserRepository repository;

    public UsersPutHandler() {
        this.mapper = new ObjectMapper();
        repository = new UserRepository(new MongoClient());
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        try {
            Map map = (Map) exchange.getAttachment(BodyHandler.REQUEST_BODY);
            repository.addUser(mapper.readValue(mapper.writeValueAsString(map), User.class));
            exchange.setStatusCode(201);
            exchange.getResponseSender().send("User Added");
        } catch (Exception e) {
            exchange.setStatusCode(401);
            exchange.getResponseSender().send("Invalid data fields were sent");
        }
    }
}

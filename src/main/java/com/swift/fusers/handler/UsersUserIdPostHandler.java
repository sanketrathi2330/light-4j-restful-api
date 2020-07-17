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

public class UsersUserIdPostHandler implements LightHttpHandler {
    private ObjectMapper mapper;
    private UserRepository repository;

    public UsersUserIdPostHandler() {
        mapper = new ObjectMapper();
        repository = new UserRepository(new MongoClient());
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        try {
            Map map = (Map) exchange.getAttachment(BodyHandler.REQUEST_BODY);
            int id = Integer.parseInt(exchange.getPathParameters().get("userId").getFirst());
            repository.updateUser(mapper.readValue(mapper.writeValueAsString(map), User.class), id);
            exchange.setStatusCode(201);
            exchange.getResponseSender().send("User Modified");
        } catch (Exception e) {
            exchange.setStatusCode(400);
            exchange.getResponseSender().send("Some of the properties provided are incorrect");
        }
    }
}

package com.swift.fusers.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.networknt.handler.LightHttpHandler;
import com.swift.fusers.model.User;
import com.swift.fusers.repository.UserRepository;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class UsersUserIdGetHandler implements LightHttpHandler {
    private ObjectMapper mapper;
    private UserRepository repository;

    public UsersUserIdGetHandler() {
        mapper = new ObjectMapper();
        repository = new UserRepository(new MongoClient());
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        exchange.setStatusCode(200);
        User user = repository.getUser(Integer.parseInt(exchange.getPathParameters().get("userId").getFirst()));
        String response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        if (!response.equals("null")) {
            exchange.getResponseSender().send(response);
        } else {
            exchange.getResponseSender().send("User not present");
        }
    }
}

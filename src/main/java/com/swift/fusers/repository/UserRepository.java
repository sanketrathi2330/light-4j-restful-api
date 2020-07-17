package com.swift.fusers.repository;

import com.mongodb.MongoClient;
import com.mongodb.QueryOperators;
import com.swift.fusers.model.Address;
import com.swift.fusers.model.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;
import java.util.Objects;

public class UserRepository implements IUserRepository {
	private String dbName = "users";
	private Datastore datastore;
	private DataFetcher fetcher = new DataFetcher();

	public UserRepository(MongoClient client) {
		Morphia morphia = new Morphia();
		this.datastore = morphia.createDatastore(client, dbName);
	}

	public void setBasicData() {
		List<User> users = fetcher.getUsersFromPlaceHolder();

		for (User user : users) {
			addUser(user);
		}
	}

	@Override
	public User getUser(int id) {
		return datastore.get(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		return datastore.createQuery(User.class).asList();
	}

	@Override
	public void addUser(User user) {
		datastore.save(user);
	}

	@Override
	public void deleteUser(int id) {
		datastore.delete(getUser(id));
	}

	@Override
	public void deleteAllUsers() {
		datastore.delete(datastore.createQuery(User.class));
	}

	@Override
	public void updateUser(User user, int id) {
		User oldUser = getUser(id);
		UpdateOperations<User> operations = datastore.createUpdateOperations(User.class)
				.set("username", getValue(user.getUsername(), oldUser.getUsername()))
				.set("phone", getValue(user.getPhone(), oldUser.getPhone()))
				.set("website", getValue(user.getWebsite(), oldUser.getWebsite()))
				.set("email", getValue(user.getEmail(), oldUser.getEmail()))
				.set("address.suite", getValue(user.getAddress().getSuite(), oldUser.getAddress().getSuite()))
				.set("address.city", getValue(user.getAddress().getCity(), oldUser.getAddress().getCity()))
				.set("address.street", getValue(user.getAddress().getStreet(), oldUser.getAddress().getStreet()))
				.set("address.zipcode", getValue(user.getAddress().getZipcode(), oldUser.getAddress().getZipcode()))
				.set("address.geo.lat", getValue(user.getAddress().getGeo().getLat(), oldUser.getAddress().getGeo().getLat()))
				.set("address.geo.lng", getValue(user.getAddress().getGeo().getLng(), oldUser.getAddress().getGeo().getLng()))
				.set("company.name", getValue(user.getCompany().getName(), oldUser.getCompany().getName()))
				.set("company.bs", getValue(user.getCompany().getBs(), oldUser.getCompany().getBs()))
				.set("company.catchPhrase", getValue(user.getCompany().getCatchPhrase(), oldUser.getCompany().getCatchPhrase()));
		datastore.update(oldUser, operations);
	}

	private String getValue(String newValue, String oldValue) {
		return (newValue != null && !newValue.isEmpty()) ? newValue : oldValue;
	}
}

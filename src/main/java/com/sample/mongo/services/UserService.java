package com.sample.mongo.services;

import java.util.Collection;
import java.util.List;

import com.sample.mongo.model.User;

public interface UserService {

	User addUser(User u);

	User updateUser(User u);

	List<User> getAllUser();

	void deleteUser(String name);

	List<User> findUsersByName(String name);

	List<User> findUsersByAgeBetween(int ageGT, int ageLT);

	List<User> findUsersByRegexpName(String regexp);

	List<User> findByName(String name);

	List<User> findByNameLikeOrderByAgeAsc(String name);

	List<User> findByAgeBetween(int ageGT, int ageLT);

	List<User> findByNameStartingWith(String regexp);

	List<User> findByNameEndingWith(String regexp);

	List<User> findNameAndId();

	List<User> findNameAndAgeExcludeId();

}

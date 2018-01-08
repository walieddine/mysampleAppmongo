package com.sample.mongo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.mongo.model.User;
import com.sample.mongo.repository.UserRepository;
import com.sample.mongo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Resource
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody User user) {
		// userRepository.save(user);
		System.out.println("User u"+user.getEmailAddress()+" "+user.toString());
		userService.addUser(user);
	}

	@RequestMapping(value = "/{id}")
	public User read(@PathVariable String id) {
		return userRepository.findOne(id);
	}

	@RequestMapping(value = "/findByAgeBetween/{ageGT}/{ageLT}", method = RequestMethod.GET)
	public List<User> findByAgeBetween(@PathVariable int ageGT, @PathVariable int ageLT) {

		return userService.findByAgeBetween(ageGT, ageLT);
	}

	@RequestMapping(value = "/findName")
	public List<User> findName() {
		return userRepository.findNameAndAgeExcludeId();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> readAll() {
		return userService.findNameAndId();
	}

	// @RequestMapping(method = RequestMethod.PUT, consumes =
	// MediaType.APPLICATION_JSON_VALUE)
	// public void update(@RequestBody User user) {
	// userRepository.save(user);
	// }

	// @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	// public void delete(@PathVariable String id) {
	// userRepository.delete(id);
	// }

}

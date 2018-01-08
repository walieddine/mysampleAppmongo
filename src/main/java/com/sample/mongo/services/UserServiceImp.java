package com.sample.mongo.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mongo.model.User;
import com.sample.mongo.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImp implements UserService {

	@Resource
	UserRepository userRepository;

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return this.userRepository.save(u);
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return this.userRepository.save(u);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Autowired(required = false)
	@Override
	public void deleteUser(String name) {
		// TODO Auto-generated method stub
        this.userRepository.delete(name);
	}

	@Override
	public List<User> findUsersByName(String name) {
		// TODO Auto-generated method stub
		return this.userRepository.findUsersByName(name);
	}

	@Override
	public List<User> findUsersByAgeBetween(int ageGT, int ageLT) {
		// TODO Auto-generated method stub
		return this.userRepository.findUsersByAgeBetween( ageGT,  ageLT);
	}

	@Override
	public List<User> findUsersByRegexpName(String regexp) {
		// TODO Auto-generated method stub
		return this.userRepository.findUsersByRegexpName(regexp);
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return this.userRepository.findByName(name);
	}

	@Override
	public List<User> findByNameLikeOrderByAgeAsc(String name) {
		// TODO Auto-generated method stub
		return this.userRepository.findByNameLikeOrderByAgeAsc(name);
	}

	@Override
	public List<User> findByAgeBetween(int ageGT, int ageLT) {
		// TODO Auto-generated method stub
		return this.userRepository.findByAgeBetween(ageGT, ageLT);
	}

	@Override
	public List<User> findByNameStartingWith(String regexp) {
		// TODO Auto-generated method stub
		return this.userRepository.findByNameStartingWith(regexp);
	}

	@Override
	public List<User> findByNameEndingWith(String regexp) {
		// TODO Auto-generated method stub
		return this.userRepository.findByNameEndingWith(regexp);
	}

	@Override
	public List<User> findNameAndId() {
		// TODO Auto-generated method stub
		return this.userRepository.findNameAndId();
	}

	@Override
	public List<User> findNameAndAgeExcludeId() {
		// TODO Auto-generated method stub
		return this.userRepository.findNameAndAgeExcludeId();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}

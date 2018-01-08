package com.sample.mongo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.querydsl.core.annotations.QueryEntity;
import com.sample.mongo.annotation.CascadeSave;

@QueryEntity
@Document
@CompoundIndexes({ @CompoundIndex(name = "email_age", def = "{'email.id' : 1, 'age': 1}") })
public class User {
	@Id
	private String id;
	@Indexed(direction = IndexDirection.ASCENDING)
	private String name;
	@Indexed(direction = IndexDirection.ASCENDING)
	private int age;

	@DBRef
	@Field("email")
	@CascadeSave
	private EmailAddress emailAddress;

	@Transient
	private int yearOfBirth;

	@DBRef
	@CascadeSave
  	private List<Claim> claims;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceConstructor
	public User(String name, @Value("#root.age ?: 0") Integer age, @Value("#root.yearOfBirth ?: 0") Integer yearOfBirth,
			List<Claim> claims, EmailAddress emailAddress) {
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
		this.yearOfBirth = yearOfBirth;
		this.claims = claims;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}

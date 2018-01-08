package com.sample.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document(collection = "Claim")
public class Claim {
	@Id
	private String id;
	
	private String claimName;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getClaimName() {
		return claimName;
	}

	public void setClaimName(final String claimName) {
		this.claimName = claimName;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(String id, String claimName) {
		super();
		this.id = id;
		this.claimName = claimName;
	}

	public Claim(String claimName) {
		super();
		this.claimName = claimName;
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

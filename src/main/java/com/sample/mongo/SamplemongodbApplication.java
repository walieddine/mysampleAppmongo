package com.sample.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.sample.mongo.model.Claim;
import com.sample.mongo.model.EmailAddress;
import com.sample.mongo.model.User;
import com.sample.mongo.repository.UserRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class SamplemongodbApplication {
	//
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SamplemongodbApplication.class, args);
	}

	/*
	 * private List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();
	 * // //
	 * 
	 * @Override public CustomConversions customConversions(){ converters.add(new
	 * UserWriterConverter()); return new CustomConversions(converters); }
	 * 
	 * 
	 * @Bean public UserCascadeSaveMongoEventListener
	 * userCascadingMongoEventListener() { return new
	 * UserCascadeSaveMongoEventListener(); }
	 * 
	 * @Bean public CascadeSaveMongoEventListener cascadingMongoEventListener() {
	 * return new CascadeSaveMongoEventListener(); }
	 */

/*	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
		System.out.println("***************************");
		Claim claim1 = new Claim();
		claim1.setId("1");
		claim1.setClaimName("aaaa");
		Claim claim2 = new Claim();
		claim2.setId("2");
		claim2.setClaimName("bbbbb");
		Claim claim3 = new Claim();
		claim3.setId("3");
		claim3.setClaimName("cccc");
		Claim claim4 = new Claim();
		claim4.setId("4");
		claim4.setClaimName("dddddd");
		EmailAddress emailAddress = new EmailAddress();
		emailAddress.setId("1");
		emailAddress.setValue("walieddine.sghaier@gmail.com");

		User u1 = new User();
		u1.setName("walie");
		u1.setAge(30);
		u1.setYearOfBirth(new Integer(1988));
		u1.setEmailAddress(emailAddress);
		List<Claim> claims1= new ArrayList<>();
		claims1.add(claim1);
		claims1.add(claim4);
		u1.setClaims(Arrays.asList(claim4));
		userRepository.save(u1);

		EmailAddress emailAddress1 = new EmailAddress();
		emailAddress1.setId("2");
		emailAddress1.setValue("walieddine.sghaier@softparadigm.com");

		User u2 = new User();
		u2.setName("walieddine sghaier");
		u2.setAge(10);
		u2.setYearOfBirth(new Integer("1989"));
		u2.setEmailAddress(emailAddress1);
		List<Claim> claims2= new ArrayList<>();
		claims2.add(claim1);
		claims2.add(claim2);
		claims2.add(claim4);
		u2.setClaims(Arrays.asList(claim1));
		userRepository.save(u2);

		System.out.println("create user with constructeur");

		User user = new User();
		user.setName("Alex");
		userRepository.save(user);
		System.out.println("------");
		System.out.println("find all---------------- ");
		userRepository.findAll().forEach(System.out::println);
	}*/

	// @Override
	// protected String getDatabaseName() {
	// return "test3";
	// }
	//
	// @Override
	// public Mongo mongo() throws Exception {
	// return new MongoClient("127.0.0.1", 27017);
	// }

}

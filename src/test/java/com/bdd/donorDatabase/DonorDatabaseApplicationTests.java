package com.bdd.donorDatabase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DonorDatabaseApplicationTests {

	ApplicationContext context;
	DonorController donorController;//= new DonorController();
	Donor d1;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setup(){
		context = new ClassPathXmlApplicationContext("beans.xml");
		donorController = context.getBean("donorController",DonorController.class);
		d1 = new Donor("Rohini",1234);}

	@AfterEach
	void cleanUp(){
		context = null;
		d1 = null;
		donorController = null;
	}

	@Test
	void whenGetBeans_ReturnsBeans(){
		assertNotNull(donorController);
	}

	@Test
	void checkAddDonorReturnsTrue(){
		assertEquals("added",donorController.addDonor(d1));
	}

	@Test
	void checkAddDonorReturnsFalseWhenDuplicateDonor(){
		donorController.addDonor(d1);
		assertEquals("existing",donorController.addDonor(d1));
	}

	@Test
	void checkFindDonorUsingNameReturnsTrue(){
		assertNotNull(donorController.findDonorUsingName("hello"));
	}
}

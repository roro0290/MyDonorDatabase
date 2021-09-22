package com.bdd.donorDatabase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DonorDatabaseApplicationTests {

	DonorController donorController = new DonorController();
	Donor d1;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setup(){ d1 = new Donor("Rohini",1234);}

	@AfterEach
	void cleanUp(){ d1 = null;}

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
		assertNotNull(donorController.findDonorUsingName("ro"));
	}
}

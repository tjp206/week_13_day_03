package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findAllWhiskiesByYear() {
		List<Whisky> foundWhiskies = whiskyRepository.findAllWhiskiesByYear(2018);
		assertEquals(6, foundWhiskies.size());
	}

	@Test
	public void findAllDistilleriesByRegion() {
		List<Distillery> foundDistilleries = distilleryRepository.findAllDistilleriesByRegion("Highland");
		assertEquals(3, foundDistilleries.size());
	}

	@Test
	public void findAllWhiskiesFromADistilleryByAge() {
		List<Whisky> foundWhiskies = whiskyRepository.findAllWhiskiesByDistilleryNameAndAge("Glendronach", 12);
		assertEquals(1,foundWhiskies.size());
	}


}

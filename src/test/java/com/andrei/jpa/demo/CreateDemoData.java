package com.andrei.jpa.demo;

import com.andrei.jpa.demo.util.DemoDataCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ${TODO} Klassenbeschreibung
 *
 * @author DVM5CLT
 * @version $Id: CreateDemoData.java 31604 2014-10-30 08:03:19Z DVM5CLT $$
 * @since 30.07.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateDemoData {

	@Autowired
	private DemoDataCreator demoDataCreator;

	@Test
	public void createTestData() {
		demoDataCreator.createDemoData();
	}
}

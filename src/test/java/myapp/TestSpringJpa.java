package myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myapp.dao.DaoClient;
import myapp.entities.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestSpringJpa {
	@Autowired
	DaoClient daoC;
	@Test
	public void addClient() {
	Client c = new Client();
	c.setNom("GERMAIN");
	c.setPrenom("Christophe");
	daoC.addClient(c);
	
}}

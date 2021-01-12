package lkv.app.bootload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lkv.app.model.UserCredential;
import lkv.app.model.Users;
import lkv.app.service.UsersService;
import lkv.app.zException.CustomeException;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsersService service;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Data Loading...");
		UserCredential c = new UserCredential();
		Users lkv = new Users();
		lkv.setFirstName("Lavkush");
		lkv.setLastName("Verma");
		lkv.setEmail("lavkush123@example.com");
		lkv.setGender("Male");
		lkv.setMobNo("09876543210");
			c.setUserName("lavkush123@example.com");
			c.setPassword("abcd1234");
			c.setConfirmPassword("abcd1234");
		lkv.setUserCredential(c);
		
		try {
			service.create(lkv);
		} catch (CustomeException e) {
			System.out.println("DataLoader error :failed to create user ");
		}
		
		System.out.println("..........done.");
		
	}
	

}

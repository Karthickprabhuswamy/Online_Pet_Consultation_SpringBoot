package com.ty.onlinepetconsultation.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ty.onlinepetconsultation.dao.UserDao;
import com.ty.onlinepetconsultation.dto.User;
import com.ty.onlinepetconsultation.repository.UserRepository;

@SpringBootTest
public class TestUserDao {
	
	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserDao userDao;
	
	static Optional<User> optional;
	
	@BeforeAll
	public static void set() {
		User user = new User();
		user.setId(0);
		user.setName("Santriya");
		user.setAddress("BTM");
		user.setEmail("san@mail.com");
		user.setPassword("san123");
		user.setPhone(998877665);
		
		optional = Optional.of(user);
	}
	
	@Test
	public void testSave() {
		User user = optional.get();
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userDao.saveUser(user));
		
	}
	
	@Test
	public void testFindUserById() {
		when(userRepository.findById(0)).thenReturn(optional);
		assertEquals(optional.get(),userDao.getUserById(0));
		
	}
	
	@Test
	public void testGetAllUser() {
		List<User> user= new ArrayList<>();
		user.add(optional.get());
		user.add(optional.get());
		
		when(userRepository.findAll()).thenReturn(user);
		assertEquals(user,userDao.getAllUser());
		
	}
	
	@Test
	public void testFindUserByEmail() {
		when(userRepository.findByEmail("san@mail.com")).thenReturn(optional);
		assertEquals(optional.get(),userDao.findUserByEmail("san@mail.com"));
		
	}
	
	@Test
	public void testFindUserByPhone() {
		when(userRepository.findByPhone(998877665)).thenReturn(optional);
		assertEquals(optional.get(),userDao.findUserByPhone(998877665));
		
	}
	
	

}

package com.Gabriel.project;

import com.Gabriel.project.demo.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class LibraryApplicationTests {

	@Test
	void contextLoads() {
		UserFactory userFactory = new UserFactory();
		BasicUser basicUser = userFactory.createUser(UserType.EMPLOYEE);
		Employee expectedEmployeeUser = new Employee("Matei", "Grigore");
		assertEquals(basicUser.getName(), expectedEmployeeUser.getName());


	}



}

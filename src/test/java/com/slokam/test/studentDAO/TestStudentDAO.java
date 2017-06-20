package com.slokam.test.studentDAO;

import org.junit.Assert;
import org.junit.Test;

import com.slokam.StudentDAO.StudentDAO;



public class TestStudentDAO {

	@Test
	public void testValidateUser(){
		String username = "syam";
		String password = "123";
		boolean result = true;
		
		boolean acutualResult = StudentDAO.validateUser(username, password);
		Assert.assertEquals(result, acutualResult);
	}
}

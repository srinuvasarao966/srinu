package com.slokam.test.studentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.slokam.StudentDAO.StudentDAO;
import com.slokam.stumgt.pojo.StudentPojo;

public class TestSignUp {

	static Connection con = null;
	@BeforeClass
	public static void init() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/F15", "root", "user123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testSignup1() {
		StudentPojo pojo1 = new StudentPojo();
		String name = "bharath";
		pojo1.setName(name);
		pojo1.setAge(123);
		pojo1.setPhone(1232.23);
		pojo1.setQual("Btech");
		StudentDAO.signupUser(pojo1);

		PreparedStatement ps;
		boolean result = false;
		try {
			ps = con.prepareStatement("select * from student where Name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(result);
	}

	@Test
	public void testSignup2() {
		StudentPojo pojo1 = new StudentPojo();
		String name = "bharath1";
		pojo1.setName(name);
		pojo1.setAge(12);
		pojo1.setPhone(1232.23);
		pojo1.setQual("Btech");
		StudentDAO.signupUser(pojo1);

		PreparedStatement ps;
	
		boolean result = false;
		try {
			ps = con.prepareStatement("select * from student where Name=?");
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		Assert.assertTrue(result);
	}

}

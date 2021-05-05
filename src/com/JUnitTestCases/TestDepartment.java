package com.JUnitTestCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;

import com.dept.dao.exception.DepartmentAlreadyExistsException;
import com.dept.dao.*;
import com.mydept.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class TestDepartment
{
	Connection conn;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	@ParameterizedTest
	public void testInsert(Department dRef) throws DepartmentAlreadyExistsException
	{
		try
		{
			PreparedStatement pst = conn.prepareStatement("insert into dept values (?,?,?)"); // this is for DML
			pst.setInt(1, dRef.getDepartmentNumber());	
			pst.setString(2, dRef.getDepartmentName()); 
			pst.setString(3, dRef.getDepartmentLocation());
			System.out.println("PrepareStatement made....for DML");
			
			System.out.println("Trying to fire it... ");	//4th step : fire the statement and acquire result if any
			int rows = pst.executeUpdate(); //fire the pst associated insert query
			System.out.println("Record inserted..."+rows);
		}
		catch(SQLIntegrityConstraintViolationException e)
		{// generic for pk
			DepartmentAlreadyExistsException daee = new DepartmentAlreadyExistsException("Department already existes please enter another number");
			throw daee;//throwing daee to DepartmentServlet,since its calling one
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

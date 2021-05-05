<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.IOException,
    			java.io.PrintWriter,
    			java.util.Iterator,
    			java.util.List,
    			com.dept.dao.Department,
    			com.dept.dao.DepartmentDAOImpl,
    			com.dept.dao.exception.ChildRecordFoundException,
    			com.dept.dao.exception.DepartmentAlreadyExistsException,
    			com.dept.dao.exception.DepartmentNotFoundException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Servlet</title>
</head>
<body>
<%!DepartmentDAOImpl ddi = new DepartmentDAOImpl(); %>
<% 	String buttonValue = request.getParameter("submit");%>
	<!--  //PrintWriter pw = response.getWriter();
	//pw.println("Button clicked value is "+buttonValue);-->
	<h5> Button clicked value is <%=buttonValue %></h5>
	<% if(buttonValue.equals("Add Dept")) 
	{ 
		int dno = Integer.parseInt(request.getParameter("v_deptno")); //to read html variable name's values 
		String dnm = request.getParameter("v_dname");
		String dloc = request.getParameter("v_loc");
		
		Department deptObj = new Department(); //blank object
		deptObj.setDepartmentNumber(dno);// fill up html value
		deptObj.setDepartmentName(dnm); //fill up html value
		deptObj.setDepartmentLocation(dloc); //fill up html value
	
		try {
			ddi.addDepartment(deptObj);
			//pw.println("<h4>Department is added to the database</h4>");
	 %>
			<h4>Department added to the database</h4>
		<% } 
		catch (DepartmentAlreadyExistsException e)
		{
			//e is catching the daee
			//pw.println("<h4>Department add issue : "+e.getMessage()+"</h4>");
			String error = e.getMessage();%>
			<h4>Department add issue : <%=error %></h4>
		<%}
		}%>
	<%if (buttonValue.equals("Find Dept"))
	{
		int dno = Integer.parseInt(request.getParameter("v_deptno")); //to read html variable name's values
		try {
			Department deptObj = ddi.findDepartment(dno);
			
			int deptnum = deptObj.getDepartmentNumber();
			String deptname = deptObj.getDepartmentName();
			String deptloc = deptObj.getDepartmentLocation();
	%>
			<% //pw.println("<table border=5 cellpadding=10 cellspacing=10>");
			//pw.println("<tr>");
			//	pw.println("<td>"+deptObj.getDepartmentNumber()+"</td>");
			//	pw.println("<td>"+deptObj.getDepartmentName()+"</td>");
			//	pw.println("<td>"+deptObj.getDepartmentLocation()+"</td>");
			//pw.println("</tr>");
			//pw.println("</table>");
			%>
			<table border=5 cellpadding=10 cellspacing=10>
			<tr>
				<td> <%=deptnum %> </td>
				<td> <%=deptname %> </td>
				<td> <%=deptloc %> </td>
			</tr>
			</table>
		<% } catch (DepartmentNotFoundException e)
		{
			// TODO Auto-generated catch block
			//pw.println("<h4>Department find issue : "+e.getMessage()+"</h4>");
			String error = e.getMessage();%>
			<h4>Department not found issue : <%=error %></h4>
		<% }
	} %>
	 <%if(buttonValue.equals("Find All Depts")) 
		{
			//pw.println("<table border=1 cellspacing=10 cellpadding=10>");
			//pw.println("<th>");		pw.println("DEPT NO");	pw.println("</th>");
			//pw.println("<th>");		pw.println("DEPT NAME");pw.println("</th>");
			//pw.println("<th>");		pw.println("LOCATION"); pw.println("</th>");
		%>
		<table border=1 cellspacing=10 cellpadding=10>
			<th> DEPT NO</th>
			<th> DEPT NAME </th>
			<th> LOCATION </th>
				<% List<Department> deptList = ddi.findDepartments();
				Iterator<Department> deptIter = deptList.iterator();
				while(deptIter.hasNext())
				{
					Department deptObj = deptIter.next();
					int deptnum = deptObj.getDepartmentNumber();
					String deptname = deptObj.getDepartmentName();
					String deptloc = deptObj.getDepartmentLocation();
					/*pw.println("<tr>");
							pw.println("<td>");
								pw.println(deptObj.getDepartmentNumber());
							pw.println("</td>");
					
							pw.println("<td>");
								pw.println(deptObj.getDepartmentName());
							pw.println("</td>");

							pw.println("<td>");
								pw.println(deptObj.getDepartmentLocation());
							pw.println("</td>");
							
					pw.println("</tr>");*/
				%>
				<tr>
					<td><%=deptnum %></td>
					<td><%=deptname %></td>
					<td><%=deptloc %></td>
				</tr>
				<%}
			//pw.println("</table>");
			%>
			</table>
		<%}
	 %>
	 <%if (buttonValue.equals("Modify Dept"))
		{
			int dno = Integer.parseInt(request.getParameter("v_deptno")); //to read html variable name's values 
			String dnm = request.getParameter("v_dname");
			String dloc = request.getParameter("v_loc");
			Department deptObj = new Department(); //blank one
			deptObj.setDepartmentNumber(dno);
			deptObj.setDepartmentName(dnm);
			deptObj.setDepartmentLocation(dloc);
			
			try 
			{
				ddi.modifyDepartment(deptObj);
				//pw.println("<h4> Department is modified</h4>");
		%>		<h4>Department is modified</h4>
		<% 
			} catch (DepartmentNotFoundException e)
			{
				// TODO Auto-generated catch block
				//pw.println("<h4>Department Modify issue : "+e.getMessage()+"</h4>");
				String error = e.getMessage();
		%>
		<h4>Department modify issue : <%= error%></h4>
			<% }
		}
	  %>
	  <% if (buttonValue.equals("Delete Dept"))
		{
			int dno = Integer.parseInt(request.getParameter("v_deptno")); //to read html variable name's values 
		
			Department deptObj = new Department(); //blank one
			deptObj.setDepartmentNumber( dno);
		
			try 
			{
				ddi.removeDepartment(deptObj);
				//pw.println("<h4> Department is deleted</h4>");
			%>	<h4>Department is deleted </h4>
			<% } 
			catch(DepartmentNotFoundException e)
			{
				//pw.println("<h4>Department delete issue : "+e.getMessage()+"</h4>");
				String error = e.getMessage();
			%>	<h4>Department delete issue <%=error %></h4>
		  <%}
			catch (ChildRecordFoundException e)
			{
				// TODO Auto-generated catch block
				//pw.println("<h4>Department delete issue : "+e.getMessage()+"</h4>");
				String error =e.getMessage();
			%> <h4>Department delete issue <%=error %></h4>
			<% }	
		}%>
		<a href='http://localhost:8080/DepartmentCRUDOperations/'> Back to Home Page </a>
</body>
</html>
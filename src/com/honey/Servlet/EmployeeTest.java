package com.honey.Servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import com.honey.Employee.Employee;

@Path("/")
@com.sun.jersey.spi.resource.Singleton
public class EmployeeTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest httpRequest, HttpServletResponse httpResponse)	throws ServletException,
																							IOException {

		String requestPath = httpRequest.getPathInfo();
		String[] pathParts = requestPath.split("/");

		if (pathParts[1].equals("getDetails")) {
			int empId = Integer.valueOf(pathParts[2].trim());
			Map<Integer, Employee> empMap = Employee.getEmployees();
			System.out.println(empMap.get(empId));

			httpResponse.setStatus(HttpServletResponse.SC_OK);
			httpResponse.getWriter()
						.write(empMap	.get(empId)
										.toString());
			httpResponse.setStatus(200);
			httpResponse.getWriter()
						.flush();
			httpResponse.getWriter()
						.close();
		}

	}

//	@Override
//	protected void service(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
//			throws ServletException, IOException {
//		
//		
//		System.out.println("Entered the servlet... Working");
//		
//		
//		
//		if (httpRequest.getMethod().equals("GET")) {
//			String requestPath = httpRequest.getPathInfo();
//			String[] pathParts = requestPath.split("/");
//			
//			
//			if (pathParts[1].equals("getDetails")) {
//				int empId = Integer.valueOf(pathParts[2].trim());
//				Map<Integer, Employee> empMap = Employee.getEmployees();
//				System.out.println(empMap.get(empId));
//
//				httpResponse.setStatus(HttpServletResponse.SC_OK);
//				httpResponse.getWriter().write(empMap.get(empId).toString());
//				httpResponse.setStatus(200);
//				httpResponse.getWriter().flush();
//				httpResponse.getWriter().close();
//			}
//			
//			
//
//		}
//	}
}
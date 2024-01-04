package com.tharinduyalegama.usermanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.tharinduyalegama.usermanagement.User;
import com.tharinduyalegama.usermanagement.dao.UserDao;


public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	
    public UserServlet() {
        super();
        
        
    }

    
    
	public void init() throws ServletException {
		
		userDao = new UserDao();
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		doGet(request, response);
	}
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getServletPath();
			switch(action)
			{
				case "/new":
					showNewForm(request, response);
					break;
			
					
				case "/insert":
				try {
					insertUser(request, response);
					
				} catch (SQLException | IOException e) {
					
					e.printStackTrace();
				
				}
					break;
			
				
				case "/delete":
				try {
					deleteUser(request, response);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
					break;
					
				
				case "/edit":
				try {
					editUser(request, response);
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
					break;
					
					
				
				case "/update":
				try {
					updateUser(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
					default:
				try {
					listUser(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						break;
			}
	
	
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request,  response);
		
	}
	
	
	
	// insert user
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User newUser = new User(name, email, country);
		
			userDao.insertUser(newUser);
		response.sendRedirect("list");
		
	}
	
	
	
	// delete user
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			userDao.deleteUser(id);
		}catch (Exception e){
			e.printStackTrace();
		}
		response.sendRedirect("List");
		
	}
	
	
	//edit user
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		User existingUser;
		
		try {
			
			existingUser = userDao.selectUser(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	//update user
		private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
			
			User user = new User(id, name, email, country);
			
			userDao.updateUser(user);
			response.sendRedirect("List");
			
		}
		
		
		
		//default
				private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
				{
					try {
						List<User> listUser = userDao.selectAllUsers();
						request.setAttribute("listUser", listUser);
						RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
						dispatcher.forward(request, response);
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					
				}

	
	
	

}

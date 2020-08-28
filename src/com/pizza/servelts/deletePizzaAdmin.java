package com.pizza.servelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.model.Pizza;
import com.pizza.util.PizzaDAO;

@WebServlet("/deletePizzaAdmin")
public class deletePizzaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String pizzaID = request.getParameter("pizzaID");
		
		Pizza pizza = new Pizza();
		pizza.setPizzaID(pizzaID);
		
		PizzaDAO pizzaDAO = new PizzaDAO();
		try {
			
			pizzaDAO.deletePizzaByAdmin(pizza);
			response.sendRedirect("adminPizzaPanel.jsp");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}



}

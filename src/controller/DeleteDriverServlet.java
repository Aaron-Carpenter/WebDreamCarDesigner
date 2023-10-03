package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DriverIdentity;

@WebServlet("/DeleteDriverServlet")
public class DeleteDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the driver ID to delete from the form
        int driverId = Integer.parseInt(request.getParameter("deleteDriverId"));

        // Create an IdentityHelper instance to perform the deletion
        IdentityHelper identityHelper = new IdentityHelper();

        // Delete the driver identity by ID
        identityHelper.deleteIdentityById(DriverIdentity.class, driverId);

        // Redirect back to the AddIdentities.html page
        response.sendRedirect("AddIdentities.html");
    }
}

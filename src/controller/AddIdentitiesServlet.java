package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DriverIdentity;
import model.PassengerIdentity;

/**
 * Servlet implementation class AddIdentitiesServlet
 */
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet("/AddIdentitiesServlet")
public class AddIdentitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DreamCarDesigner");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        String driverFName = request.getParameter("driverFName");
        String driverLName = request.getParameter("driverLName");
        String passengerFName = request.getParameter("passengerFName");
        String passengerLName = request.getParameter("passengerLName");

        DriverIdentity driver = new DriverIdentity(driverFName, driverLName);
        PassengerIdentity passenger = new PassengerIdentity(passengerFName, passengerLName);

        try {
            tx.begin();
            em.persist(driver);
            em.persist(passenger);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        response.sendRedirect("AddIdentities.html");
    }
}


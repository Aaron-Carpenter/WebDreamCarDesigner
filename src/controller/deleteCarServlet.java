package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class deleteCar
 */
@WebServlet("/deleteCarServlet")
public class deleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idToDeleteParam = request.getParameter("idToDelete");
        
        int idToDelete = Integer.parseInt(idToDeleteParam);
        ListItemHelper dao = new ListItemHelper();
        ListItem carToDelete = dao.searchForItemById(idToDelete);
        
        dao.deleteItem(carToDelete);
        
        response.sendRedirect("index.html");
    }


}

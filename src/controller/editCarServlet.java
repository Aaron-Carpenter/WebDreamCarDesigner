package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class editMakeServlet
 */
@WebServlet("/editCarServlet")
public class editCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idToEditStr = request.getParameter("idToEdit");
        String newMake = request.getParameter("make");
        String newModel = request.getParameter("model");
        String newColor = request.getParameter("color");
        String newCustomMods = request.getParameter("customMods");

        int idToEdit = Integer.parseInt(idToEditStr);

        ListItemHelper dao = new ListItemHelper();

        ListItem carToEdit = dao.searchForItemById(idToEdit);

        if (carToEdit != null) {
            if (newMake != null) {
                carToEdit.setMake(newMake);
            }
            if (newModel != null) {
                carToEdit.setModel(newModel);
            }
            if (newColor != null) {
                carToEdit.setColor(newColor);
            }
            if (newCustomMods != null) {
                carToEdit.setCustomModifications(newCustomMods);
            }

            dao.updateItem(carToEdit);
        }

        response.sendRedirect("index.html");
    }



}

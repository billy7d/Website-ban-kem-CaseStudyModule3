package controller;

import model.IceCream;
import service.IceCreamDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/trangchu")
public class UserServlet extends HttpServlet {

    private IceCreamDAO iceCreamDAO = new IceCreamDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String input = request.getParameter("input");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":

                    break;
                case "edit":

                    break;
                case "delete":

                    break;
                case "sort":

                    break;
                case "search":
                    break;
                default:
                    listIceCream(request, response);
                    break;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private void listIceCream(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException{
        List<IceCream> iceCreamList = iceCreamDAO.selectAllIceCream();
        request.setAttribute("listIceCream", iceCreamList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Addmin/trangchu.jsp");
        dispatcher.forward(request, response);
    }
}

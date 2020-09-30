package controller;

import model.Item;
import model.Orders;
import service.IceCreamDAO;
import service.ItemDAO;
import service.OrderDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    ItemDAO itemDAO = new ItemDAO();
    OrderDAO orderDAO = new OrderDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action.equals("pay")){
                pay(request,response);
        }else if (action.equals("inforcustomer")){
            try {
                creatOrder(request,response);
                displayCart(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action.equals("order")){
            order(request,response);
        } else if (action.equals("remove")){
            remove(request,response);

        }else if (action.equals("increase")){
            increase(request, response);
        }

    }

    protected void displayCart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer/cart.jsp");
        dispatcher.forward(request, response);
    }



    protected void order(HttpServletRequest request,HttpServletResponse response) throws IOException {
        IceCreamDAO iceCreamDAO = new IceCreamDAO();
        HttpSession session = request.getSession();
        if (session.getAttribute("cart")==null){
            List<Item> cart = new ArrayList<>();
            cart.add(new Item(iceCreamDAO.searchIceCream(Integer.parseInt(request.getParameter("id"))),1));
            session.setAttribute("cart",cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = isExisting(Integer.parseInt(request.getParameter("id")),cart);

            if (index == -1){
                cart.add(new Item(iceCreamDAO.searchIceCream(Integer.parseInt(request.getParameter("id"))),1));
            } else {
                Item item = cart.get(index);
                int quantity = item.getQuantity() +1;
                item.setQuantity(quantity);

            }
            session.setAttribute("cart",cart);
        }
        response.sendRedirect("/trangchu");
    }



    protected void pay(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        request.setAttribute("cart", cart);
        displayCart(request,response);
    }



    protected void remove(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExisting(Integer.parseInt(request.getParameter("id")),cart);
        cart.get(index).setQuantity(cart.get(index).getQuantity()-1);
        if(cart.get(index).getQuantity() == 0){
            cart.remove(index);
        }
        session.setAttribute("cart",cart);
        displayCart(request,response);
    }


    protected void increase(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExisting(Integer.parseInt(request.getParameter("id")),cart);
        cart.get(index).setQuantity(cart.get(index).getQuantity()+1);
        session.setAttribute("cart",cart);
        displayCart(request,response);
    }

    private int isExisting(int id, List<Item> cart){
        for (int i =0;i< cart.size();i++){
            if (cart.get(i).getIceCream().getIceCreamId()==id){
                return i;
            }
        }
        return -1;
    }

    private void creatOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String name = request.getParameter("name");
        String numberPhone = request.getParameter("number");
        String address = request.getParameter("address");
        Orders orders = new Orders(name, address, numberPhone);
        orderDAO.insertOrder(orders);
    }


    protected void creatItem(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");

        request.setAttribute("cart", cart);
        displayCart(request,response);
    }




}

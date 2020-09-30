package service;

import model.Item;
import model.Orders;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrderDAO {
    private String jdbcURL="jdbc:mysql://localhost:3306/ice_cream_shop?userSSL=false";
    private String jdbcUsername = "root";
    private String jbdcPassword = "123456";


    public OrderDAO(){

    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jbdcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    public boolean insertOrder(Orders order)throws SQLException{
        boolean isInsertOrder = false;
        String query = "{CALL insert_order(?,?,?,?)}";
        double total = 0;
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query);){
            callableStatement.setString(1, order.getNameCustomer());
            callableStatement.setString(2, order.getAddressCustomer());
            callableStatement.setString(3,order.getNumberPhoneCustomer());
            callableStatement.setDouble(4,total);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isInsertOrder;
    }

}

package service;

import model.IceCream;

import java.sql.SQLException;
import java.util.List;

public class copyIceCreamDAO {

    public void insertIceCream(IceCream iceCream) throws SQLException {

    }

    public List<IceCream> selectAllIceCream() throws SQLException {
        return null;
    }

    public boolean deleteIceCream(int id) throws SQLException {
        return false;
    }

    public boolean updateIceCream(IceCream iceCream) throws SQLException {
        return false;
    }

    public IceCream searchIceCream(int id) throws SQLException {
        return null;
    }

    public List<IceCream> searchIceCreamByCategory(String idCategory) {
        return null;
    }

    public List<IceCream> searchIceCreamByName(String name) throws SQLException {
        return null;
    }

    public List<IceCream> sortIceCreamByPrice(String Price) throws SQLException {
        return null;
    }

    public List<IceCream> sortIceCreambyQuantity(String Quantity) throws SQLException {
        return null;
    }
}

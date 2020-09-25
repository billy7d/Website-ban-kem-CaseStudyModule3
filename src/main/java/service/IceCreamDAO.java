package service;

import model.IceCream;

import java.sql.SQLException;
import java.util.List;

public class IceCreamDAO implements IiceCreamDAO {

    @Override
    public void insertIceCream(IceCream iceCream) throws SQLException {

    }

    @Override
    public List<IceCream> selectAllIceCream() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteIceCream(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateIceCream(IceCream iceCream) throws SQLException {
        return false;
    }

    @Override
    public IceCream searchIceCream(int id) throws SQLException {
        return null;
    }

    @Override
    public List<IceCream> searchIceCreamByCategory(String idCategory) {
        return null;
    }

    @Override
    public List<IceCream> searchIceCreamByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<IceCream> sortIceCreamByPrice(String Price) throws SQLException {
        return null;
    }

    @Override
    public List<IceCream> sortIceCreambyQuantity(String Quantity) throws SQLException {
        return null;
    }
}

package service;

import model.IceCream;

import java.sql.SQLException;
import java.util.List;

public interface IiceCreamDAO {
    public void insertIceCream(IceCream iceCream) throws SQLException;

    public IceCream selectIceCream(int id);

    public List<IceCream> selectAllIceCream();
}

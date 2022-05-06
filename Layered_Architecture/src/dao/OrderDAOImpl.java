package dao;

import model.CustomerDTO;
import model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements CrudDao<OrderDTO,String>{
    @Override
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return  false;

    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1");
        if(rst.next()){
            String id = rst.getString("id");
            int newOrderId = Integer.parseInt(id.replace("OID-", "")) + 1;
            return String.format("C00-%03d", newOrderId);
        }
        else {
            return "OID-001";
        }
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}

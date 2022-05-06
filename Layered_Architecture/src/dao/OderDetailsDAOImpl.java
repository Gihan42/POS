package dao;

import model.CustomerDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OderDetailsDAOImpl implements CrudDao<OrderDetailDTO,String>{
    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
       /* stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

            stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());*/
      return  SQLUtil.executeUpdate("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
        dto.getOrderId(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
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
    public OrderDetailDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}

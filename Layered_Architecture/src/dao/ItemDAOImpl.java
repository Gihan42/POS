package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDao {
   public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
     //   Connection connection = DBConnection.getDbConnection().getConnection();
    //    Statement stm = connection.createStatement();
       ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
       ArrayList<ItemDTO> allItems = new ArrayList<>();
       while (rst.next()) {
           allItems.add(new ItemDTO(rst.getString(1), rst.getString(2), rst.getBigDecimal(4), rst.getInt(3)));
       }
       return allItems;
    }
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
      //  PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
       /* pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3, dto.getUnitPrice());
        pstm.setInt(4, dto.getQtyOnHand());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
     }
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
     //   Connection connection = DBConnection.getDbConnection().getConnection();
      //  PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
     /*   pstm.setString(1, code);
        return  pstm.executeUpdate()>0;
      */
        return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?", code);
    }

    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, newItemCode + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();*/
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item WHERE code=?", code);
        if (rst.next()) {
            return new ItemDTO(rst.getString(1), rst.getString(2), rst.getBigDecimal(4), rst.getInt(3));
        }
        return null;
    }

    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
      //  PreparedStatement pstm = connection.prepareStatement("");
       /* pstm.setString(1, dto.getDescription());
        pstm.setBigDecimal(2, dto.getUnitPrice());
        pstm.setInt(3, dto.getQtyOnHand());
        pstm.setString(4, dto.getCode());
       return pstm.executeUpdate() >0;*/
        return  SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
      //  PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
       /* pstm.setString(1, code);
        return pstm.executeQuery().next();*/
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?", code).next();
    }
    public String genarateId() throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
       ResultSet rst =SQLUtil.executeQuery ("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ArrayList<ItemTM> genarateSalary(double salary) throws SQLException, ClassNotFoundException {
        return null;
    }
}

package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.CustomerDao;
import model.CustomerDTO;
import view.tdm.CustomerTM;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDao {
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
       // Statement stm = connection.createStatement();
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        while (rst.next()) {
            allCustomers.add(new CustomerDTO(
                    rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return allCustomers;
    }
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
      //  Connection connection = DBConnection.getDbConnection().getConnection();
     /*PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        return pstm.executeUpdate()>0;*/
        return SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",
                dto.getId(), dto.getName(), dto.getAddress());

    }
  public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
     //   Connection connection = DBConnection.getDbConnection().getConnection();
     // PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
    /*  pstm.setString(1,dto.getName() );
      pstm.setString(2, dto.getAddress());
      pstm.setString(3, dto.getId());
      return pstm.executeUpdate()>0;*/

     return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?",
              dto.getId(),dto.getName(),dto.getAddress());
    }
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
     //   Connection connection = DBConnection.getDbConnection().getConnection();
      //  PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
       /* pstm.setString(1, id);
        return pstm.executeQuery().next();*/
      return  SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id).next();
    }
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
        //PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        /*pstm.setString(1, id);
        return pstm.executeUpdate()>0;*/
      return  SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer WHERE id=?",id);
        if(rst.next()){
           return new CustomerDTO(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return null;
    }

    public String genarateId() throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
       // ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public ArrayList<CustomerTM> getAllCustomer(String address) {
        return null;
    }
}

package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDao {
     boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
     boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
     boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
     String genarateId() throws SQLException, ClassNotFoundException;
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
}

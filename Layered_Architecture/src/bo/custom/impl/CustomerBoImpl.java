package bo.custom.impl;

import bo.custom.CustomerBo;
import dao.DAOFactory;
import dao.custom.CustomerDao;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    //final CustomerDao customerDao=new CustomerDAOImpl();
    CustomerDao customerDao= (CustomerDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
         return customerDao.getAll();
    }
    public boolean saveCustomer( CustomerDTO dto) throws SQLException, ClassNotFoundException {
       return customerDao.save(dto);
    }
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.exist(id);
    }
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
       return customerDao.update(dto);
    }
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDao.delete(id);
    }
    public String genarateNewCustomerId() throws SQLException, ClassNotFoundException {
       return customerDao.genarateId();
    }
}

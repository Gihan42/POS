package bo;

import dao.custom.*;
import dao.custom.impl.*;
import db.DBConnection;
import model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PurchaseOrderBoIMPL {
    private final CustomerDao customerDAO = new CustomerDAOImpl();
    private final ItemDao itemDAO = new ItemDAOImpl();
    private final OrderDao orderDAO = new OrderDAOImpl();
    private final OrderDetailDao orderDetailsDAO = new OderDetailsDAOImpl();
    private final QueryDao queryDao=new QueryDaoImpl();

    public boolean PurchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {

            Connection connection = DBConnection.getDbConnection().getConnection();
            /*if order id already exist*/
            if (orderDAO.exist(orderId)) {

            }

            connection.setAutoCommit(false);
            boolean save = orderDAO.save(new OrderDTO(orderId, orderDate, customerId));

            if (!save) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detail : orderDetails) {
                boolean save1 = orderDetailsDAO.save(detail);
                if (!save1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
              //  ItemDTO item = findItem(detail.getItemCode());
                ItemDTO item = null;
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
                System.out.println(item);
                boolean update = itemDAO.update(item);

                if (!update) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
    }
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
      return customerDAO.search(id);
    }
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
      return itemDAO.search(code);
    }
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
       return itemDAO.exist(code);
    }
    public boolean existCustomerAvailable(String id) throws SQLException, ClassNotFoundException {
      return  customerDAO.exist(id);
    }
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
       return orderDAO.genarateId();
    }
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
      return  customerDAO.getAll();
    }
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
       return itemDAO.getAll();
    }
}

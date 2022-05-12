package bo.custom.impl;

import bo.custom.ItemBo;
import dao.custom.ItemDao;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {
    ItemDao itemDAO=new ItemDAOImpl();

    public    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
     return itemDAO.getAll();
    }
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
       return itemDAO.delete(id);
    }
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
      return  itemDAO.save(dto);
    }
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
      return  itemDAO.update(dto);
    }
    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
      return itemDAO.exist(id);
    }
    public String genarateItemCode() throws SQLException, ClassNotFoundException {
       return itemDAO.genarateId();
    }
}

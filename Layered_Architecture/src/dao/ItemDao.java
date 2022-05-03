package dao;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDao {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteitem(String code) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean exixtsItem(String code) throws SQLException, ClassNotFoundException;
    String genarateId() throws SQLException, ClassNotFoundException;
}

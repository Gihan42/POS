package dao.custom;

import dao.SuperDao;
import model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDao extends SuperDao {
    ArrayList<CustomDTO> searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException;
}

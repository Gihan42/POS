package dao.custom;

import model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDao {
    ArrayList<CustomDTO> searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException;
}

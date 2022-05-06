package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao <T,ID>{
     boolean save(T dto) throws SQLException, ClassNotFoundException;
     boolean update(T dto) throws SQLException, ClassNotFoundException;
     boolean exist(ID id) throws SQLException, ClassNotFoundException;
     boolean delete(ID id) throws SQLException, ClassNotFoundException;
     T search(ID id)throws SQLException, ClassNotFoundException;
     String genarateId() throws SQLException, ClassNotFoundException;
     ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}

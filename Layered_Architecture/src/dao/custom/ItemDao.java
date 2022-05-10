package dao.custom;

import dao.CrudDao;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDao extends CrudDao<ItemDTO,String> {
    public ArrayList<ItemTM> genarateSalary(double salary) throws SQLException,ClassNotFoundException;
}

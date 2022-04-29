package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import view.tdm.ItemTM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemDAOImpl {
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList <ItemDTO> allItem=new ArrayList<>();
        while(rst.next()){
            String code = rst.getString(1);
            String description = rst.getString(2);
            double unitPrice = rst.getDouble(3);
            int qtyOnHand = rst.getInt(4);
            allItem.add(new ItemDTO(code,description,unitPrice,qtyOnHand));
        }
        return allItem;
    }
}

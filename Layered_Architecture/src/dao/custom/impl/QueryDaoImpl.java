package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.QueryDao;
import model.CustomDTO;
import model.CustomerDTO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryDaoImpl implements QueryDao {
    public ArrayList<CustomDTO> searchOrderByOrderID(String id)throws SQLException,ClassNotFoundException{
      /*  String sql="select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?;";
        ResultSet rst = SQLUtil.executeQuery(sql, id);
        ArrayList<CustomDTO> orderRecords= new ArrayList();

        while (rst.next()) {
            String oid = rst.getString(1);
            String date = rst.getString(2);
            String customerID = rst.getString(3);
            String itemCode = rst.getString(4);
            int qty = rst.getInt(5);
            BigDecimal unitPrice = rst.getBigDecimal(6);

            CustomDTO customDTO= new CustomDTO();
            customDTO.setOid(oid);
            customDTO.setOrderDate(LocalDate.now());
            customDTO.setCustomerId(customerID);
            customDTO.setItemCode(itemCode);
            customDTO.setQty(qty);
            customDTO.setUnitPrice(unitPrice);

            orderRecords.add(customDTO);

        }
        return orderRecords;*/
        ResultSet rst = SQLUtil.executeQuery("select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?;", id);
        ArrayList<CustomDTO> orderRecords = new ArrayList();
        while (rst.next()) {
            orderRecords.add(new CustomDTO(rst.getString(1), LocalDate.parse(rst.getString(2)), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getBigDecimal(6)));
        }
        return orderRecords;
    }

    }



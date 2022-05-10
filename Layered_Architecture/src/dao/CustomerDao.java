package dao;

import model.CustomerDTO;
import view.tdm.CustomerTM;

import java.util.ArrayList;

public interface CustomerDao extends  CrudDao<CustomerDTO,String>{
    public ArrayList<CustomerTM> getAllCustomer(String address);
}

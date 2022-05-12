package dao;

import dao.custom.CustomerDao;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.OrderDAOImpl;
import model.CustomerDTO;

public class DAOFactory {
    private static DAOFactory daoFactory;

    DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
   public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,QUERYDAO;
   }
   public SuperDao getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new  CustomerDAOImpl() ;
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAILS:
                return new CustomerDAOImpl();
            case QUERYDAO:
                return new OrderDAOImpl();
        }
        }
   }

